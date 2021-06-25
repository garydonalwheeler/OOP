package main.java.project3.component;

import main.java.project3.logging.ConsoleLogger;
import main.java.project3.persistance.ComputerBuilder;

import static java.lang.System.*;

public class SataCable implements Component, Runnable
{
    private ConsoleLogger consoleLogger = new ConsoleLogger();
    private boolean isBuilt = false;
    private ComputerBuilder computerBuilder = ComputerBuilder.getInstance();

    public SataCable()
    {
        computerBuilder.componentAdded(this);
    }

    @Override
    public void run()
    {
        consoleLogger.logSATAstart(getComponentType(), Thread.currentThread().getId());
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            String msg = "InterruptedException";
            err.println("\t\t\t---ERROR---\n " + msg + ";" + e + "\n------\n");
            Thread.currentThread().interrupt();
        }
        consoleLogger.logSATAend(getComponentType(), Thread.currentThread().getId());
        isBuilt = true;
        computerBuilder.componentAssembled(this);
    }

    @Override
    public void build()
    {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public boolean isBuilt()
    {
        return isBuilt;
    }

    @Override
    public String getComponentType()
    {
        return "SATA Cable";
    }

}
