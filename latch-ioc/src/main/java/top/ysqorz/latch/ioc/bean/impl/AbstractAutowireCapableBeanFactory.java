package top.ysqorz.latch.ioc.bean.impl;

import top.ysqorz.latch.ioc.bean.BeanDefinition;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        try {
            // TODO 临时实现
            Object bean = beanDefinition.getBeanClass().newInstance();
            addSingleton(name, bean);
            return bean;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
