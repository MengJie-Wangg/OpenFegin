package com.example.openfeigndemo.myannotations;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @BelongsProject: openfeignDemo
 * @BelongsPackage: com.example.openfeigndemo.myannotations
 * @Author: gepengjun
 * @CreateTime: 2023-09-01  09:37
 * @Description: 自定义的代理对象
 * @Version: 1.0
 */
public class CustomProxyHandler implements InvocationHandler {
    RestTemplate restTemplate=new RestTemplate();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //首先获取对象
        Class<?> declaringClass = method.getDeclaringClass();
        //判断当前的被代理对象是否使用了自定的注解
        if(declaringClass.isAnnotationPresent(CustomProxy.class)){
            CustomProxy annotation = declaringClass.getAnnotation(CustomProxy.class);
            String servie = annotation.servie();
            String address = annotation.address();
            String url=address+servie;
            RequestMapping annotation1 = method.getAnnotation(RequestMapping.class);
            url=url+annotation1.value()[0];
            //判断请求方法是否入参
            if(args!=null&&args.length!=0){
                return restTemplate.getForObject(url,method.getReturnType(),args);
            }else {
                return restTemplate.getForObject(url,method.getReturnType());
            }
        }else{
            return null;
        }


    }
}
