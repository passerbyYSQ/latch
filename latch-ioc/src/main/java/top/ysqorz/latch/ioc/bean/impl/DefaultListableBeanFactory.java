package top.ysqorz.latch.ioc.bean.impl;

import top.ysqorz.latch.ioc.bean.BeanDefinition;
import top.ysqorz.latch.ioc.bean.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new RuntimeException("No bean named '" + name + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
