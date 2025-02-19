package top.ysqorz.latch.ioc.bean;

/**
 * 单例注册中心
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String name);
}
