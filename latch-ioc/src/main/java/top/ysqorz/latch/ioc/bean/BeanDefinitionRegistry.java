package top.ysqorz.latch.ioc.bean;

/**
 * bean定义的注册中心
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String name);
}
