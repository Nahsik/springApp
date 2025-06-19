package com.kd.SystemDesign.LLD.Command.Light;

import com.kd.SystemDesign.LLD.Command.Command;

public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        System.out.print("undo command => ");
        light.on();
    }
}
