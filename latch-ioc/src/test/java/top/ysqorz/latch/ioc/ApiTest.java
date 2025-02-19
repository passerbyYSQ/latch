package top.ysqorz.latch.ioc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.ysqorz.latch.ioc.bean.*;
import top.ysqorz.latch.ioc.bean.impl.DefaultListableBeanFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class ApiTest {
    private DefaultListableBeanFactory beanFactory;

    @BeforeEach
    public void beforeEach() {
        // 1.初始化 BeanFactory
        beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(User.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
    }

    @Test
    public void testGetBean_Singleton() {
        // 3.第一次获取 bean
        User user1 = (User) beanFactory.getBean("userService");
        user1.printUserInfo();

        // 4.第二次获取
        User user2 = (User) beanFactory.getBean("userService");
        user2.printUserInfo();

        assertEquals(user1, user2);
    }

    @Test
    public void testGetBean_ParameterizedConstructor() {
        // 3. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(User.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 4.获取bean
        User user = (User) beanFactory.getBean("userService", "王小明", 18);
        user.printUserInfo();
    }

    @Test
    public void testGetBean_ApplyPropertyValues() {
        // 3. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 4. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 5. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 6. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
