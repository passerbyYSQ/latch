package top.ysqorz.latch.ioc.bean.impl;

import top.ysqorz.latch.ioc.bean.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObjectMap = new HashMap<>();

    @Override
    public Object getSingleton(String name) {
        return singletonObjectMap.get(name);
    }

    protected void addSingleton(String name, Object singleton) {
        singletonObjectMap.put(name, singleton);
    }
}
