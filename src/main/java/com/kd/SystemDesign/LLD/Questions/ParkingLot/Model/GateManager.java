package com.kd.SystemDesign.LLD.Questions.ParkingLot.Model;

import java.util.ArrayList;
import java.util.List;

public class GateManager {
    List<EntryGate> entries;
    List<ExitGate> exits;

    GateManager() {
        entries = new ArrayList<>();
        exits = new ArrayList<>();
    }

    public void addEntryGate(EntryGate entry) {
        entries.add(entry);
    }

    public void removeEntryGate(EntryGate entry) {
        entries.remove(entry);
    }

    public void addExitGate(ExitGate exit) {
        exits.add(exit);
    }

    public void removeExitGate(ExitGate exit) {
        exits.remove(exit);
    }
}
