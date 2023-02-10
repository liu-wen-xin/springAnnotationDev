package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;

import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    //抽取applicationContext打印的方法
    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //默认是单实例 person==person2为ture
        Object person = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person==person2);
    }

    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        Object person = applicationContext.getBean("person");
        System.out.println(person);
    }

    @Test
    public void test03() {

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        //动态获取环境变量的值
        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
     //   System.out.println(property);  //输出Windows 10
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }



    @Test
    public void TestImport(){
        printBeans(applicationContext);
    }
}
