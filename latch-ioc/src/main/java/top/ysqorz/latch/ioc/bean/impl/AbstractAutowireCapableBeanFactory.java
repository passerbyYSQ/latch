package top.ysqorz.latch.ioc.bean.impl;

import top.ysqorz.latch.ioc.bean.BeanDefinition;
import top.ysqorz.latch.ioc.bean.BeanReference;
import top.ysqorz.latch.ioc.bean.InstantiationStrategy;
import top.ysqorz.latch.ioc.bean.PropertyValue;
import top.ysqorz.latch.ioc.util.ReflectUtil;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new JdkInstantiationStrategy();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object... args) {
        Object bean = instantiateBean(beanDefinition, args);
        applyPropertyValues(beanDefinition, bean);
        addSingleton(name, bean);
        return bean;
    }

    protected void applyPropertyValues(BeanDefinition beanDefinition, Object bean) {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues()) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            // A 依赖 B，获取 B 的实例化 TODO 暂时不考虑循环依赖
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getBeanName()); // 要求B必须有 空参构造
            }
            ReflectUtil.setFieldValue(bean, name, value);
        }
    }

    public Object instantiateBean(BeanDefinition beanDefinition, Object... args) {
        return getInstantiationStrategy().instantiate(beanDefinition, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
