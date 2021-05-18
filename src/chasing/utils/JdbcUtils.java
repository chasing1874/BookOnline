package chasing.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 柴柴快乐每一天
 * @create 2021-04-26  10:33 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();


    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接池中的连接
     * @return  返回null说明连接失败；有值就获取连接成功
     */
    public static Connection getConnection() {

        Connection conn = conns.get();
        if (conn == null){
            try {
                conn = dataSource.getConnection();//从数据库连接池中初次获取连接
                conns.set(conn);    // 保存到ThreadLocal对象中，供后面的jdbc操作使用，保证其唯一性
                conn.setAutoCommit(false);  // 设置为手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        try {
//            conn = dataSource.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return conn;
    }

    /**
     * 提交事务，并关闭释放连接（包括con和conns）
     */
    public static void commitAndClose() {
        Connection connection = conns.get();
        // 如果不等于null说明之前使用过连接操作数据库
        if (connection != null) {
            try {
                // 提交事务
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭连接
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 一定要执行remove操作，否则会出错，因为Tomcat底层使用了线程池技术
            conns.remove();
        }
    }


    public static void rollbackAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }


//    public static void close(Connection conn) {
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//    }

}


