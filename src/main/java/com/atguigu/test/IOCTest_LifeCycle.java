package com.atguigu.test;

import com.atguigu.config.MainConfig2;
import com.atguigu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    @Test
    public void test01() {
        //创建ioc容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        String[] names = applicationContext.getBeanDefinitionNames();
/*        for (String name : names) {
            System.out.println(name);
        }*/
    }

}
