package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/*
* 配置类==配置文件
* 1、@Configuration   告诉Spring这是一个配置类
* 2、@Bean("person")  //指定组件在容器中的名字，不设置的话会以person01方法名作为组件名
* 3、@ComponentScan(value = "com.atguigu") 包扫描
* */
@Configuration
/*
@ComponentScan(value = "com.atguigu")  //包扫描
excludeFilters:过滤某个组件不被扫描，无法完成组件注册
type = FilterType.ANNOTATION：以注解形式进行过滤
 classes = {Controller.class, Service.class}):Controller和Service不能进行注册
* */
@ComponentScan(value = "com.atguigu",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {Controller.class, Service.class})
})
public class MainConfig {

    /*
    * 一、配置类的设置
    * @Bean 给容器注册一个bean,类型则为返回值类型，id默认为方法名也可以在@Bean注解里重命名
    * */
    @Bean("person")  //指定组件在容器中的名字，不设置的话会以person01方法名作为组件名
    @Scope("prototype")
    public Person person01(){
        return new Person("lisi",20);
    }

    /*
    * 二、包扫描
    * 只要标注了@Controller、@Service、@Repository、@Component
    * */
}
