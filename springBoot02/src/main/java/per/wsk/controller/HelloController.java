package per.wsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wsk.bean.Person;

@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person person(){

        String userName = person.getUserName();
        System.out.println(userName);
        return person;
    }

}
