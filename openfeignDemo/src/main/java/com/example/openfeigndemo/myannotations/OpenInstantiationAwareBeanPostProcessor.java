package com.example.openfeigndemo.myannotations;

/**
 * @BelongsProject: openfeignDemo
 * @BelongsPackage: com.example.openfeigndemo.myannotations
 * @Author: gepengjun
 * @CreateTime: 2023-09-01  15:41
 * @Description: TODO
 * @Version: 1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.PropertyValues;

/**
 * @author authorZhao
 * @date 2019/12/20
 */
@Slf4j
public class OpenInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor, ApplicationContextAware {


    private ApplicationContext applicationContext;
    /**
     * 实例化前，后面的方法可以不用看了
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {


        if(!beanClass.isAnnotationPresent(CustomProxy.class)){
            return null;
        }
        log.info("正在为：{}生成代理对象,被代理的类为：{}",beanName,beanClass.getName());
        //动态代理里面需要实现的方法，本文采用的是jdk动态代理
        //返回代理对象
        Object object = ProxyFactory.createProxy(beanClass);
        return object;

    }

    /**
     * 实例化后
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }


    /**
     * 初始化钱
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * 初始化后
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}


