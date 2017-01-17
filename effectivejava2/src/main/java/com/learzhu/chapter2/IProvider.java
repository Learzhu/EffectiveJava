package com.learzhu.chapter2;

/**
 * IProvider.java是EffectiveJava的获取对象的提供者类。
 *
 * @author 祝杭鹏
 * @version 1.0 2017/1/17
 */
public interface IProvider {
    IService newService();
}
