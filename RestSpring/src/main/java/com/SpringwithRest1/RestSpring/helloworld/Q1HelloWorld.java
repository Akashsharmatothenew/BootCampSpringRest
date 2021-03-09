package com.SpringwithRest1.RestSpring.helloworld;

import org.springframework.web.bind.annotation.*;

/**
 * Created by ttn on 7/3/21.
 */
//Controler
    @RestController
public class Q1HelloWorld {
        //Get
         //URI -/Q1

    //method
    //@RequestMapping(method = RequestMethod.GET, path = "/Q1")

    @GetMapping(path="/Q1hello")
    public String displayHello(){
        return "Hello world";
    }

    //create object or return bean
    @GetMapping(path = "/Q1")
    public HelloWorldBean helloworldbean(){
        return new HelloWorldBean("Hello World");
    }
    //pathvariable
    @GetMapping(path ="/Q1/{name}")
    public HelloWorldBean helloWorldPathvariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s ",name));
    }

}
