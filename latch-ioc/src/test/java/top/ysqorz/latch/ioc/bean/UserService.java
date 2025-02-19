package top.ysqorz.latch.ioc.bean;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class UserService {
    private String userId;
    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryByUserId(userId));
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
