package chasing.test;

import chasing.pojo.User;
import chasing.service.UserService;
import chasing.service.impl.UserServiceimpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 柴柴快乐每一天
 * @create 2021-04-26  7:35 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class UserServiceTest {

    UserService userService = new UserServiceimpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null, "hhh111", "111", "hhh111@qq.com"));
        userService.registUser(new User(null, "ttt111", "111", "ttt111@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "wzg168", "123456", null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzg168")) {
            System.out.println("用户已存在");
        } else {
            System.out.println("用户名可用");
        }
    }
}