package top.ysqorz.latch.ioc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.ysqorz.latch.ioc.bean.BeanDefinition;
import top.ysqorz.latch.ioc.bean.UserService;
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
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
    }

    @Test
    public void testGetBean_Singleton() {
        // 3.第一次获取 bean
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();

        // 4.第二次获取
        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService2.queryUserInfo();

        assertEquals(userService1, userService2);
    }

    @Test
    public void testGetBean_ParameterizedConstructor() {
        // 3. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 4.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "王小明", 18);
        userService.queryUserInfo();
    }
}
