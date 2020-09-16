package com.flow2dot0.udemy.todoapp.todoapp.helloworld;

/**
 * User: flow2dot0-osx
 * Date: 15/09/2020
 * Time: 17:13
 */
public class HelloWorldBean {


    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
