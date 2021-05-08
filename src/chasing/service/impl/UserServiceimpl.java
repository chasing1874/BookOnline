package chasing.service.impl;

import chasing.dao.UserDao;
import chasing.dao.impl.UserDaoImpl;
import chasing.pojo.User;
import chasing.service.UserService;

/**
 * @author 柴柴快乐每一天
 * @create 2021-04-26  7:30 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class UserServiceimpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;
    }
}
