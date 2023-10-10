package com.example.openfeigndemo.myannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @BelongsProject: openfeignDemo
 * @BelongsPackage: com.example.openfeigndemo.myannotations
 * @Author: gepengjun
 * @CreateTime: 2023-09-01  09:36
 * @Description: TODO
 * @Version: 1.0
 */
public class ProxyFactory {

    /**
     * @description: 创建具体的代理对象
     * @author: gepengjun
     * @date: 2023/9/1 17:30
     * @param: [targetInterface]
     * @return: T
     **/
    public static  <T> T createProxy(Class<T> targetInterface) {
        return (T) Proxy.newProxyInstance(
                targetInterface.getClassLoader(),
                new Class[]{targetInterface},
                new CustomProxyHandler()
        );
    }
}
