package chasing.service;

import chasing.pojo.User;

/**
 * @author 柴柴快乐每一天
 * @create 2021-04-26  7:20 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public interface UserService {

    /**
     * @describe: 注册用户
     * @param user
     * @return void
     */
    public void registUser(User user);

    /**
     * @describe: 登录
     * @param user
     * @return chasing.pojo.User    如果返回null，说明登录失败，返回非空，登录成功
     */
    public User login(User user);

    /**
     * @describe: 检查用户名是否可用
     * @param username
     * @return boolean  返回True表示用户名已存在；返回false表示用户名可用
     */
    public boolean existsUsername(String username);

}
