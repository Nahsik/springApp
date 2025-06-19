package com.kd.SystemDesign.LLD.Command;

import com.kd.SystemDesign.LLD.Command.Light.Light;
import com.kd.SystemDesign.LLD.Command.Light.LightOffCommand;
import com.kd.SystemDesign.LLD.Command.Light.LightOnCommand;
import com.kd.SystemDesign.LLD.Command.Stereo.Stereo;
import com.kd.SystemDesign.LLD.Command.Stereo.StereoOffCommand;
import com.kd.SystemDesign.LLD.Command.Stereo.StereoOnCommand;

public class RemoteControlTest {

    public static void main(String[] arg) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        simpleRemoteControl.setCommand(new LightOnCommand(new Light("Room0")));

        simpleRemoteControl.buttonWasPressed();

        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light("Room1");
        remoteControl.setCommand(1, new LightOnCommand(light), new LightOffCommand(light));

        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(1);
        System.out.println(remoteControl);

        Stereo stereo = new Stereo("Stereo");
        remoteControl.setCommand(0, new StereoOnCommand(stereo), new StereoOffCommand(stereo));
        remoteControl.onButtonWasPushed(0);
        //System.out.println(remoteControl);

        remoteControl.undoButtonWasPushed();

    }
}
