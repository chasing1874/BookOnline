package chasing.test;

import chasing.dao.UserDao;
import chasing.dao.impl.UserDaoImpl;
import chasing.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 柴柴快乐每一天
 * @create 2021-04-26  7:07 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin1234") == null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        userDao.saveUser(new User(null, "wzg168", "123456", "wzg168@qq.com"));
    }
}