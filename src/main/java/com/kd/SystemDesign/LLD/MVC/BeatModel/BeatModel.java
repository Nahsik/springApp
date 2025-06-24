package com.kd.SystemDesign.LLD.MVC.BeatModel;

import ch.qos.logback.core.joran.conditional.ThenAction;

import java.io.File;
import java.util.List;

public class BeatModel implements BeatModelInterface, Runnable {

    private List<BeatObserver> beatObservers;
    private List<BPMObserver> bpmObservers;
    private Thread thread;
    private int bpm = 90;
    private boolean stop = false;
    private Clip clip;

    @Override
    public void initialize() {
        try {
            File resource = new File("clap.wav");
            clip = new Clip();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void on() {
        bpm = 90;
        notifyBPMObservers();
        thread = new Thread(this);
        stop = false;
        thread.start();
    }

    @Override
    public void off() {
        stop = true;
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        notifyBeatObserver();
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    @Override
    public void registerObserver(BeatObserver beatObserver) {
        beatObservers.add(beatObserver);
    }

    @Override
    public void removeObserver(BeatObserver beatObserver) {
        beatObservers.remove(beatObserver);
    }

    @Override
    public void registerObserver(BPMObserver bpmObserver) {
        bpmObservers.add(bpmObserver);
    }

    @Override
    public void removeObserver(BPMObserver bpmObserver) {
        bpmObservers.remove(bpmObserver);
    }

    @Override
    public void run() {
        while (!stop) {
            //playBeat();
            notifyBeatObserver();
            try {
                Thread.sleep(60000 / getBPM());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void notifyBPMObservers() {
        bpmObservers.forEach(BPMObserver::update);
    }

    private void notifyBeatObserver() {
        beatObservers.forEach(BeatObserver::update);
    }
}
