package com.flow2dot0.udemy.todoapp.todoapp.basic;

public class BasicAuthenticationBean {

    private String message;

    public BasicAuthenticationBean(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BasicAuthenticationBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
