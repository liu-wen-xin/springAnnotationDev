package com.atguigu.config;

import com.atguigu.bean.Color;
import com.atguigu.bean.Person;
import com.atguigu.condition.LinuxConditior;
import com.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.atguigu.condition.MyImportSelector;
import com.atguigu.condition.WindowsConditior;
import org.springframework.context.annotation.*;

@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class
})
public class MainConfig2 {

    /*@Scope指定对象的作用范围
    *prototype:多实例
    *singleton：单实例（默认的）
    *request:同一次请求创造一个实例（需要有web环境）
    *session:同一个session创造一个实例（需要有web环境）
    * */
    //@Scope("prototype")
    @Bean
    @Lazy
    public Person person(){
        return new Person("wangmazi",11);
    }


    /*
    * @Conditional({Conditional数组}):按照一定的条件进行判断,满足条件的组件给容器注册bean
    * 需求如下：
    * 如果是windows，就给容器注册lilei
    * 如果是linux，就给容器注册xiaoming
    * 默认情况下lilei和xiaoming都会注册到容器内
    *
    * */
    @Conditional({WindowsConditior.class})
    @Bean("lilei")
    public Person person01(){
        return new Person("lilei",11);
    }
    @Conditional({LinuxConditior.class})
    @Bean("xiaoming")
    public Person person02(){
        return new Person("xiaoming",11);
    }

}
