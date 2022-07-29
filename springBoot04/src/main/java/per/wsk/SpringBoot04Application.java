package per.wsk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("per.wsk.mapper")//该注解的作用: mapper这个包下的 类上面不用再写 @Mapper注解
public class SpringBoot04Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04Application.class, args);
    }

}
