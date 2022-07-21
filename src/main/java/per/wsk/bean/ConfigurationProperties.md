传统的读取.properties文件的方法:
![img.png](img.png)

springBoot通过@ConfigurationProperties注解的方式:

先在application.properties文件中定义一些配置项：
![img_1.png](img_1.png)
定义实体类:
![img_2.png](img_2.png)
在controller中测试：
![img_3.png](img_3.png)
浏览器访问效果：
![img_4.png](img_4.png)

说明application.properties的这两个配置项注入到了car实例中

二、
上面是采用@Component + @ConfigurationProperties方式

也可以用
@EnableConfigurationProperties + @ConfigurationProperties方式：

去掉@Compoent注解
![img_5.png](img_5.png)
在配置类中加上@EnableConfigurationProperties注解，指明Car这个类
![img_6.png](img_6.png)

此时也可以实现上面的效果


