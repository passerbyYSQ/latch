package top.ysqorz.latch.ioc.bean;

/**
 * bean定义
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class BeanDefinition {
    private final Class<?> beanClass;
    private final PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, new PropertyValues());
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
