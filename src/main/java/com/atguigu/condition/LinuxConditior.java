package com.atguigu.condition;




import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/*使用@Conditional
 * 判断系统是否是Linux
 * 要使用@Conditional进行判断的类必须实现Conditional接口
 * */
public class LinuxConditior implements Condition {

    /*
    * ConditionContext：判断条件使用上下文环境
    * AnnotatedTypeMetadata：注释信息
    * */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //判断是否是linux系统
        //1、能获取ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3、获取当前环境信息
        Environment environment = context.getEnvironment();
        //4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        if (property.contains("Linux")) {
            return true;
        }
        return false;
    }
}
