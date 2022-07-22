package per.wsk.config;

import ch.qos.logback.classic.db.DBHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import per.wsk.bean.*;

@Configuration("proxyBeanMethods = false") //告诉springBoot这是一个配置类  相当于spring的配置文件
@Import({User.class, DBHelper.class})
//@ConditionalOnBean(name = "hashiqi")
@ImportResource("classpath:bean.xml") //该注解的作用是引入指定路径下的配置文件，配置文件内的bean实例就会注入到该类中
//下面这个EnableConfigurationProperties注解的作用：1、开启Car配置绑定功能  2、把这个Car这个组件自动注册到容器中
@EnableConfigurationProperties(Car.class)
public class Myconfig {


    @Bean//给容器中添加bean，以方法名作为组件bean的id，返回类型作为bean的类型，返回的值，就是bean实例
    public User user01(){
        return new User("张三",18);
    }

    @Bean("tom")  //此时bean实例名字叫tom，不叫tomcatPet
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }

    //组件就是实例，即bean

    /**
     类名上面@Configuration注解的属性proxyBeanMethods：代理bean的方法
     *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
     *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
     *      如果组件依赖必须使用Full模式默认。其他默认是否Lite模式，例如一个bean实例中的其中一个属性，是另一个bean实例，
     *
     */


    //类名上面的@Import注解，后面可以写多个要注入的类名，可以认为：这个注解和 下面通过 @Bean注解和构造器的 作用是一样的，
    //都是向该配置类中注入实例，@Import注解，更简便一些  这种方式注入的bean的id，是被注入类的全类名
    //参照详见MainController类中的测试



//    @Bean("hashiqi")
    public Dog dog(){
        return new Dog("哈士奇");
    }

    @ConditionalOnBean(name = "hashiqi") //当bean容器中包含hashiqi这个实例时，下面这个tiger-1才会注入进来,当这个注解标到类名上，表示不满足该条件，整个配置类的其他配置项都不会生效
    @Bean("tiger-1")
    public Tiger tiger(){
        return new Tiger("东北虎");
    }



}
