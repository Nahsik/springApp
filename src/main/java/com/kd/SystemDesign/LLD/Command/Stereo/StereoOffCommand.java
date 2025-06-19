package com.kd.SystemDesign.LLD.Command.Stereo;

import com.kd.SystemDesign.LLD.Command.Command;

public class StereoOffCommand implements Command {

    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.setVolume(0);
        stereo.off();
    }

    @Override
    public void undo() {
        System.out.print("undo command => ");
        stereo.on();
        stereo.setCD();
        stereo.setVolume(10);
    }
}
