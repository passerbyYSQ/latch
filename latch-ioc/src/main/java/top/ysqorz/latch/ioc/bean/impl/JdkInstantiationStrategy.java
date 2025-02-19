package top.ysqorz.latch.ioc.bean.impl;

import top.ysqorz.latch.ioc.bean.BeanDefinition;
import top.ysqorz.latch.ioc.bean.InstantiationStrategy;
import top.ysqorz.latch.ioc.util.ReflectUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Cglib的实现交给外部，此模块不引入第三方依赖
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class JdkInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, Object... args) {
        Class<?> clazz = beanDefinition.getBeanClass();
        try {
            Class<?>[] paramTypes = ReflectUtil.getClasses(args);
            Constructor<?> constructor = ReflectUtil.getConstructor(clazz, paramTypes);
            if (constructor == null) {
                return clazz.getDeclaredConstructor().newInstance();
            } else {
                return constructor.newInstance(args);
            }
        } catch (InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
