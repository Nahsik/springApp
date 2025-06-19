package com.kd.SystemDesign.LLD.Command.Stereo;

public class Stereo {
    String name;
    int volume;

    public Stereo(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + "Stereo is on");
    }

    public void setCD() {
        System.out.println(name + " Stereo CD is Set");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(name + "Stereo volume is set to:" + volume);
    }

    public void off() {
        System.out.println(name + "Stereo is off");
    }
}
