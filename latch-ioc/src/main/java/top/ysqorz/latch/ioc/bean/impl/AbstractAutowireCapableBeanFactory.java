package top.ysqorz.latch.ioc.bean.impl;

import top.ysqorz.latch.ioc.bean.BeanDefinition;
import top.ysqorz.latch.ioc.bean.InstantiationStrategy;

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
        addSingleton(name, bean);
        return bean;
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
