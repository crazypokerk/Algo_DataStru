package com.exe.wenda.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/3/26 16:16
 */
//可以存储任何类型的对象，相当于一个对象中可以放很多属性
public class ViewObject {
    private Map<String, Object> objs = new HashMap<String, Object>();

    public void set(String key, Object value) {
        objs.put(key, value);
    }

    public Object get(String key) {
        return objs.get(key);
    }
}
