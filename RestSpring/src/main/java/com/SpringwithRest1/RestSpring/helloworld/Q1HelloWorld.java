package com.SpringwithRest1.RestSpring.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by ttn on 7/3/21.
 */
//Controler
    @RestController
public class Q1HelloWorld {


        //internatization
    @Autowired
    MessageSource messageSource;
        //Get
         //URI -/Q1

    //method
    //@RequestMapping(method = RequestMethod.GET, path = "/Q1")

    /*@GetMapping(path="/Q1hello")
    public String displayHello(){
        return "Hello world";
    }

    //create object or return bean
    @GetMapping(path = "/Q1")
    public HelloWorldBean helloworldbean(){
        return new HelloWorldBean("Hello World");
    }*/
    //pathvariable
    @GetMapping(path ="/Q2/{name}")
    public HelloWorldBean helloWorldPathvariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello , %s ",name));
    }
    @GetMapping(path ="/Q1")
    public String helloWorldInternalization(@RequestHeader(name="Accept-Language",required = false) Locale locale){
        return messageSource.getMessage("good.morning.message",null,locale);
    }
}
