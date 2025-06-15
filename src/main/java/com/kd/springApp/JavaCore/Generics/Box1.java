package com.kd.springApp.JavaCore.Generics;

public class Box1<T extends Number> {
    T obj;

    Box1(T t){
        this.obj = t;
    }

    public T getObj(){
        return obj;
    }

    public void setObj(T t){
        this.obj = t;
    }
}
