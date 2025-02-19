package top.ysqorz.latch.ioc.bean;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class User {
    private Object name;
    private int age;

    public User() {
    }

    public User(Object name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printUserInfo() {
        System.out.println("用户信息：" + this);
    }

    @Override
    public String toString() {
        return "{" +
                "name=" + name +
                ", age=" + age +
                "}";
    }
}
