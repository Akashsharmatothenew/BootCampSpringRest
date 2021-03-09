package com.SpringwithRest1.RestSpring.helloworld;

/**
 * Created by ttn on 7/3/21.
 */
public class HelloWorldBean {
    String message;
    public HelloWorldBean (String msg){
        this.message=msg;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s]", message);
    }
}
