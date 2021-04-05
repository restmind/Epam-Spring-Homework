package com.epam.spring.core.implBeans;

import com.epam.spring.core.beans.GeneralBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class ImplBeanPostProcessor implements BeanPostProcessor {

    public ImplBeanPostProcessor() {
        System.out.println("=====Inside ImplBeanPostProcessor Constructor=====\n");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("=====Inside ImplBeanPostProcessor postProcessBeforeInitialization method=====\n");
        if (beanName.startsWith("bean")) {
            if (((GeneralBean) bean).getName() != null && ((GeneralBean) bean).getValue() > 0) {
                System.out.println("=====" + beanName + "(name: " + ((GeneralBean) bean).getName() + ", value: " +
                        ((GeneralBean) bean).getValue() + ") is validated=====\n");
            } else {
                throw new BeansException("Bean is not validated\n") {
                    @Override
                    public String getMessage() {
                        return super.getMessage();
                    }
                };
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("=====Inside ImplBeanPostProcessor postProcessAfterInitialization method=====\n");
        System.out.println("===== >> bean = " + bean + ", beanName = " + beanName + "=====\n");
        return bean;
    }
}
