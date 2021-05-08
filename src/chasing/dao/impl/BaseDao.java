package chasing.dao.impl;

import chasing.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-04-26  4:30 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public abstract class BaseDao {
    //update()方法用来执行insert、update、delete
    //失败返回-1
    private QueryRunner queryRunner = new QueryRunner();


    /**
     * @param sql
	 * @param args 
     * @return int
     * @author 
     * @describe: 
     * @date 2021/4/26 5:11 下午
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    
    /**
     * @param type 返回的对象类型
	 * @param sql   执行的sql语句
	 * @param args  sql对应的参数值
     * @return T
     * @author fine
     * @describe:   查询返回一个个javaBean的sql语句
     * @date 2021/4/26 5:12 下午
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * @param type
	 * @param sql
	 * @param args
     * @return java.util.List<T>
     * @author fine
     * @describe: 返回多个javaBean的sql语句
     * @date 2021/4/26 5:24 下午
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * @param sql
	 * @param args
     * @return java.lang.Object
     * @author fine
     * @describe: 执行返回一行一列的sql语句
     * @date 2021/4/26 5:28 下午
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }


}
