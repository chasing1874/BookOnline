package chasing.test;

import chasing.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author 柴柴快乐每一天
 * @create 2021-04-26  11:01 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class JdbcUtilsTest {


    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 30; i++) {
            Connection con = JdbcUtils.getConnection();
            System.out.println(con);
        }
    }

}
