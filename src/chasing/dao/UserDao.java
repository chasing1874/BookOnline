package chasing.dao;

import chasing.pojo.User;

/**
 * @author 柴柴快乐每一天
 * @create 2021-04-26  5:35 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public interface UserDao {

    /**
     * @describe: 根据用户名查询用户信息
     * @param username 用户名
     * @return chasing.pojo.User    如果返回null，说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * @describe: 根据用户名和密码查询用户信息
     * @param username
	 * @param password
     * @return chasing.pojo.User    如果返回null，说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * @describe: 保存用户信息
     * @param user
     * @return int  返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveUser(User user);

}
