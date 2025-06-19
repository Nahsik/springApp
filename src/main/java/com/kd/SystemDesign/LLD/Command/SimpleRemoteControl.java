package com.kd.SystemDesign.LLD.Command;

public class SimpleRemoteControl {

    private Command slot;

    SimpleRemoteControl(){
    }

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
