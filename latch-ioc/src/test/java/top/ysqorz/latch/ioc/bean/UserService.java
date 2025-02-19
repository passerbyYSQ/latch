package top.ysqorz.latch.ioc.bean;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class UserService {
    private Object name;
    private int age;

    public UserService() {
    }

    public UserService(Object name, int age) {
        this.name = name;
        this.age = age;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + this);
    }

    @Override
    public String toString() {
        return "{" +
                "name=" + name +
                ", age=" + age +
                "}";
    }
}
