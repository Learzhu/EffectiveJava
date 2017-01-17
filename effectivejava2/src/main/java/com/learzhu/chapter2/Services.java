package com.learzhu.chapter2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Services.java是EffectiveJava的用于获取保存各种Service实例的类。
 * <p>
 * 1.先注册提供者然后使用
 *
 * @author 祝杭鹏
 * @version 1.0 2017/1/17
 */

public class Services {
    private Services() {
    }

    public static final Map<String, IProvider> providers = new ConcurrentHashMap<>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    //    Provider registration API
    public static void registerDefaultProvider(IProvider provider) {
        registerProvider(DEFAULT_PROVIDER_NAME, provider);
    }

    //实际将对象加入到内存中的方法
    public static void registerProvider(String name, IProvider provider) {
        providers.put(name, provider);
    }

    //生成实际对象
    public static IService newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    //生成实际对象的实际方法
    public static IService newInstance(String name) {
        IProvider iProvider = providers.get(name);
        if (iProvider == null) {
            throw new IllegalArgumentException("No Iprovider registered with name: " + name);
        }
        return iProvider.newService();
    }
}
