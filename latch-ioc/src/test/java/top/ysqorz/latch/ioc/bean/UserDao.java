package top.ysqorz.latch.ioc.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class UserDao {
    private static final Map<String, String> userData = new HashMap<>();

    static {
        userData.put("10001", "张三");
        userData.put("10002", "李四");
        userData.put("10003", "王五");
    }

    public String queryByUserId(String userId) {
        return userData.get(userId);
    }
}
