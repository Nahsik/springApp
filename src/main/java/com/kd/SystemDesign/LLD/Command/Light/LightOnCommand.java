package com.kd.SystemDesign.LLD.Command.Light;

import com.kd.SystemDesign.LLD.Command.Command;

public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        System.out.print("undo command => ");
        light.off();
    }
}
