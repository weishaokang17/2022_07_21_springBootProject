package per.wsk;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import per.wsk.bean.Pet;
import per.wsk.bean.User;
import per.wsk.config.Myconfig;

import java.util.Arrays;

/**
 * 主程序类;主配置类
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainController {


    /*public static void main(String[] args) {
        //1. 返回IOC容器们
        ConfigurableApplicationContext run = SpringApplication.run(MainController.class, args);
        //2. 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        Arrays.asList(names).forEach(System.out::println);
        //3. 获取Myconfig类中注入的bean实例
        Pet tom = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println(tom == tom02);
        //配置类Myconfig本身也是bean容器中的一个实例
        Myconfig myconfig = run.getBean(Myconfig.class);
        System.out.println(myconfig);
        //4.如果Myconfig配置类上面的@Configuration(proxyBeanMethods = true)，代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        User user = myconfig.user01();
        User user1 = myconfig.user01();
        System.out.println(user == user1);//如果Myconfig配置类上面的@Configuration(proxyBeanMethods = true)，二者相等，否则二者不相等
        System.out.println("-------------------------------------");
        //5.测试通过@Import注解，注入的实例
        DBHelper dbHelper = run.getBean(DBHelper.class);
        System.out.println(dbHelper);
        //6.
    }*/



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainController.class, args);

        boolean tiger = run.containsBean("tiger-1");
        boolean tom = run.containsBean("tom");
        System.out.println("是否包含 tiger 实例 " + tiger);
        System.out.println("是否包含 tom这个 实例 " + tom);


        boolean wangcai = run.containsBean("wangcai");
        boolean songjiang = run.containsBean("songjiang");
        System.out.println("是否包含songjiang "+songjiang);
        System.out.println("是否包含wangcai "+wangcai);


    }


}
