package com.kd.SystemDesign.LLD.Command.Stereo;

import com.kd.SystemDesign.LLD.Command.Command;

public class StereoOnCommand implements Command {

    Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(10);
    }

    @Override
    public void undo() {
        System.out.print("undo command => ");
        stereo.setVolume(0);
        stereo.off();
    }
}
