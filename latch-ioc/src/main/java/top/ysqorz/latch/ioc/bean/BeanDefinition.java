package top.ysqorz.latch.ioc.bean;

/**
 * bean定义
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class BeanDefinition {
    private final Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }
}
