package main.java.project3.persistance;

import main.java.project3.component.Component;
import main.java.project3.component.Computer;
import main.java.project3.logging.ConsoleLogger;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComputerBuilder implements Runnable
{
    private ConsoleLogger consoleLogger = new ConsoleLogger();
    private static final int MAX_OF_THREE = 3;
    private static final ComputerBuilder INSTANCE = new ComputerBuilder();
    private Queue<Component> componentsRequiredQueue = new LinkedList<>();
    private List<Component> componentsAssemblyList = new ArrayList<>();
    private List<Computer> computersBuilt = new ArrayList<>();
    private boolean assemblyLineOperational = false;

    public static ComputerBuilder getInstance()
    {
        return INSTANCE;
    }

    public void buildComputer()
    {
        int cores = (Runtime.getRuntime().availableProcessors() / 2);
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        executorService.execute(INSTANCE);
        executorService.shutdown();
        setAssemblyLineOperational(true);
    }

    public synchronized void componentAdded(Component component)
    {
        setAssemblyLineOperational(true);
        if (component == null)
        {
            consoleLogger.logComponentNull("No Components have entered into the Queue");
        }
        if (componentsAssemblyList.size() < MAX_OF_THREE)
        {
            componentsAssemblyList.add(component);
            if (component != null)
            {
                component.build();
            }
        } else
        {
            componentsRequiredQueue.add(component);
        }
    }

    public synchronized void componentAssembled(Component component)
    {
        consoleLogger.logComponentDone(component.getComponentType());
        componentsAssemblyList.remove(component);
        consoleLogger.logComponent(componentsAssemblyList.size());
        Component nextComponent = componentsRequiredQueue.poll();

        if (nextComponent != null)
            componentAdded(nextComponent);

        else
        {
            consoleLogger.logComponentNext(componentsRequiredQueue.size());
        }

        if (componentsAssemblyList.isEmpty() && componentsRequiredQueue.isEmpty())
        {
            consoleLogger.logBuildEnd();
            setAssemblyLineOperational(false);
        }
    }

    @Override
    public void run()
    {
        consoleLogger.logBuildStart();
        Computer computer = new Computer();
        computer.build();
        while (computer.isBuilt().equals(Boolean.FALSE)) ;
        computersBuilt.add(computer);
        consoleLogger.logComputer(computersBuilt.size());
    }

    public List<Computer> getComputersBuilt()
    {
        return computersBuilt;
    }

    public List<Component> getcomponentsAssemblyList()
    {
        return componentsAssemblyList;
    }

    public boolean isAssemblyLineOperational()
    {
        return assemblyLineOperational;
    }

    private void setAssemblyLineOperational(boolean assemblyLineOperational)
    {
        this.assemblyLineOperational = assemblyLineOperational;
    }
}
