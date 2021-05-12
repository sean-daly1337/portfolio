package com.example.assignmenttwo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import security.AppProperties;

public class SpringApplicationContext implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;

    public static Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        CONTEXT = context;
    }

    @Bean
    public AppProperties appProperties() {
        return new AppProperties();
    }

}
