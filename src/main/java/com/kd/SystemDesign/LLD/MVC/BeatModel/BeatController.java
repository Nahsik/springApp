package com.kd.SystemDesign.LLD.MVC.BeatModel;

public class BeatController implements ControllerInterface {

    BeatModelInterface model;

    public BeatController(BeatModelInterface model) {
        this.model = model;
//        view = new DJView(this, model);
//        view.createView();
//        view.createControls();
//        view.disableStopMenuItem();
//        view.enableStartMenuItem();
        model.initialize();
    }

    @Override
    public void start() {
        model.on();
//        view.disableStartMenuItem();
//        view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        model.off();
//        view.disableStopMenuItem();
//        view.enableStartMenuItem();
    }

    @Override
    public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
    }

    @Override
    public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
    }

    @Override
    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }
}
