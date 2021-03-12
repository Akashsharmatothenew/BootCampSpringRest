package com.SpringwithRest1.RestSpring.com.SpringwithRest1.RestSpring.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;

/**
 * Created by ttn on 11/3/21.
 */
@RestController
public class PersonVersionControler {

    @GetMapping(value = "Q10/2/param",params = "version=1")
    public PersonV1 paramV1(){

        return new PersonV1("Akash Sharma");
    }

    @GetMapping(value = "Q10/1/produces",produces = "application/tothenew.app-v1+json")
    public PersonV1 mimeV1(){
        return new PersonV1("Akash Sharma");
    }
    @GetMapping(value = "Q10/1/produces",produces = "application/tothenew.app-v2+json")
    public PersonV2 mimeV2(){
        return new PersonV2("Akash Sharma","aka@gmail.com",23,"Delhi");
    }
    @GetMapping(value = "Q10/2/param",params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2("Akash Sharma","aka@gmail.com",23,"Delhi");
    }
    @GetMapping("Q10/3/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Akash Sharma");
    }
    @GetMapping("Q10/3/v2/person")
    public PersonV2 personV2(){
        return new PersonV2("Akash Sharma","aka@gmail.com",23,"Delhi");
    }
    @GetMapping(value = "Q10/4/header", headers ="X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Akash Sharma");
    }
    @GetMapping(value = "Q10/4/header", headers ="X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2("Akash Sharma","aka@gmail.com",23,"Delhi");
    }


}
