package com.kd.springApp.JavaCore.Generics;

public class Box <T> {
    T obj;

    Box(T t){
        this.obj = t;
    }

    public T getObj(){
        return obj;
    }

    public void setObj(T t){
        this.obj = t;
    }
}
