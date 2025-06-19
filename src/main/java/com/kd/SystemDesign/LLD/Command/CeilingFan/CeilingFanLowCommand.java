package com.kd.SystemDesign.LLD.Command.CeilingFan;

import com.kd.SystemDesign.LLD.Command.Command;

public class CeilingFanLowCommand implements Command {

    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
