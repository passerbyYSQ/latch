package top.ysqorz.latch.ioc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.ysqorz.latch.ioc.bean.BeanDefinition;
import top.ysqorz.latch.ioc.bean.UserService;
import top.ysqorz.latch.ioc.bean.impl.DefaultListableBeanFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();

        // 4.第二次获取
        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService2.queryUserInfo();

        assertEquals(userService1, userService2);
    }
}
