package top.ysqorz.latch.ioc.bean.impl;

import top.ysqorz.latch.ioc.bean.BeanDefinition;
import top.ysqorz.latch.ioc.bean.BeanFactory;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    /**
     * 模板方法固化流程
     */
    @Override
    public Object getBean(String name) {
        return getBean(name, new Object[0]);
    }

    @Override
    public Object getBean(String name, Object... args) {
        // 如果单例已缓存，则直接返回
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        // 获取bean定义并实例化bean
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String name);

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object... args);
}
