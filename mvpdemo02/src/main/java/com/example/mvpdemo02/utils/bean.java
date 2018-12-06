package com.example.mvpdemo02.utils;

public class bean<T> {
    private String name;
    private String pass;
    private T data;

    public bean(String name, String pass, T data) {
        this.name = name;
        this.pass = pass;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
