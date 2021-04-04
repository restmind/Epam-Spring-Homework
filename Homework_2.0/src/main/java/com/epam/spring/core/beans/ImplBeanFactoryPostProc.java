package com.epam.spring.core.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class ImplBeanFactoryPostProc implements BeanFactoryPostProcessor {

    public ImplBeanFactoryPostProc() {
        System.out.println("=====Inside ImplBeanFactoryPostProc Constructor=====\n");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition newBean = new GenericBeanDefinition();
        newBean.setBeanClass(BeanB.class);
        newBean.setInitMethodName("anotherCustomInitMethod");
        newBean.setDestroyMethodName("customDestroyMethod");
        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("beanB", newBean);
    }
}
