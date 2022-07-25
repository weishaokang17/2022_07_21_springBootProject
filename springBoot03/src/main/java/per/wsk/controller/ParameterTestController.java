package per.wsk.controller;

import org.springframework.web.bind.annotation.*;
import per.wsk.bean.Person;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {




    //<a href="car/3/owner/lisi?age=18&inters=basketball&inters=game">car/{id}/owner/{username}</a>

    /**
     上面的a标签链接，
     下面的@PathVariable注解，是获取路径中的变量，@PathVariable("id") Integer id是获取路径中car后面的3，即id的值是3
     @PathVariable("username") String name 的值是lisi
     @PathVariable Map<String,String> pv 是获取所有的路径变量，类型是map，key是变量key，值是具体的值
     @RequestHeader("User-Agent") String userAgent 是获取请求的header中的 User-Agent这一项
     @RequestHeader Map<String,String> header 是获取header中所有的值

     @RequestParam("age") Integer age是获取上面a标签中 ？后面参数age的值，只能获取get请求中，不能用于post请求
     @RequestParam("inters") List<String> inters 因为上面a标签中，inters的值有多个，所以这里用集合接收
     @RequestParam Map<String,String> params 是获取a标签后面所有的请求参数，类型是map，同样是只能用于get请求，不能用于post请求

     浏览器中可能有多个cookie
     @CookieValue("_ga") String _ga 获取的是name是_ga的这个cookie的value值
     @CookieValue("_ga") Cookie cookie 是获取的是name是_ga的这个cookie
     */
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("_ga") String _ga,
                                     @CookieValue("_ga") Cookie cookie){
        Map<String,Object> map = new HashMap<>();

//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("headers",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("_ga",_ga);
        System.out.println(cookie.getName()+"===>"+cookie.getValue());
        return map;
    }




    /**
     * 数据绑定：页面提交的请求数据（GET、POST）都可以和对象属性进行绑定
     * @param person
     * @return
     */
    @PostMapping("/saveuser")
    public Person saveuser(Person person){
        return person;
    }

}
