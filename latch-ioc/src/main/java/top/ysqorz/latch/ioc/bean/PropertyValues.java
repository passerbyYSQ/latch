package top.ysqorz.latch.ioc.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * ...
 *
 * @author yaoshiquan
 * @date 2025/2/19
 */
public class PropertyValues implements Iterator<PropertyValue>, Iterable<PropertyValue> {
    private final List<PropertyValue> propertyValues = new ArrayList<>();
    private Iterator<PropertyValue> iterator;

    public void addPropertyValue(PropertyValue pv) {
        propertyValues.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return Collections.unmodifiableList(propertyValues);
    }

    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue pv : propertyValues) {
            if (pv.getName().equals(name)) {
                return pv;
            }
        }
        return null;
    }

    @Override
    public Iterator<PropertyValue> iterator() {
        return iterator = propertyValues.iterator();
    }

    @Override
    public boolean hasNext() {
        if (iterator == null) {
            return false;
        }
        return iterator.hasNext();
    }

    @Override
    public PropertyValue next() {
        if (iterator == null) {
            return null;
        }
        return iterator.next();
    }
}
