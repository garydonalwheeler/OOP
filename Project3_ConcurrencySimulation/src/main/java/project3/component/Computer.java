package main.java.project3.component;

import java.util.ArrayList;
import java.util.List;

public class Computer
{
    private Component cpu;
    private Component motherboard;
    private List<SataCable> sataCables = new ArrayList<>(4);
    private List<RamMemory> ramMemories = new ArrayList<>(4);

    public Computer()
    {
        build();
    }

    public void build()
    {
        cpu = new Cpu();
        motherboard = new Motherboard();
        sataCables.add(new SataCable());
        sataCables.add(new SataCable());
        sataCables.add(new SataCable());
        sataCables.add(new SataCable());
        sataCables.add(new SataCable());
        ramMemories.add(new RamMemory());
        ramMemories.add(new RamMemory());
        ramMemories.add(new RamMemory());
        ramMemories.add(new RamMemory());
    }

    public Boolean isBuilt()
    {
        boolean finishedBuilding = true;
        finishedBuilding = cpu.isBuilt();
        finishedBuilding &= motherboard.isBuilt();

        for (SataCable sataCable : sataCables)
        {
            finishedBuilding &= sataCable.isBuilt();
        }
        for (RamMemory ramMemory : ramMemories)
        {
            finishedBuilding &= ramMemory.isBuilt();
        }
        return finishedBuilding;
    }
}
