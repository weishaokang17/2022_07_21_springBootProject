package per.wsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wsk.bean.Car;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handle01(){
        return "hello, spring boot 2!";
    }


    @Autowired
    private Car car;

    @RequestMapping("/mycar")
    public Car myCar(){
        return car;
    }

}
