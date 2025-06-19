package com.kd.SystemDesign.LLD.Command.Light;

public class Light {
    String state;
    String name;


    public Light(String name) {
        state = "off";
        this.name = name;
    }

    public void on() {
        this.state = "on";
        System.out.println(name + " Light is On...");
    }

    public void off() {
        this.state = "off";
        System.out.println(name + " Light is Off...");
    }
}
