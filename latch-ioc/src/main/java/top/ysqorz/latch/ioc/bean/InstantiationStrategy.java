package top.ysqorz.latch.ioc.bean;

/**
 * bean的实例化策略
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, Object... args);
}
