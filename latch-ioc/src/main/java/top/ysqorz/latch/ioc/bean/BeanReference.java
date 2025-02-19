package top.ysqorz.latch.ioc.bean;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
