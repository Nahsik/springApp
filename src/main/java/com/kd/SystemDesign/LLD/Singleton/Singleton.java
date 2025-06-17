package com.kd.SystemDesign.LLD.Singleton;

public class Singleton {
    private volatile Singleton singleton;
    private Singleton() {}
    public Singleton getInStance() {
        if (null == singleton) {
            synchronized (this) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
