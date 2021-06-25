package main.java.project3.orchestration;

import main.java.project3.component.Component;
import main.java.project3.component.Computer;
import main.java.project3.persistance.ComputerBuilder;
import main.java.project3.logging.ConsoleLogger;

import java.util.Date;
import java.util.List;

import static java.lang.System.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ComputerRunner
{
    public static void main(String[] args) throws InterruptedException
    {
        ComputerBuilder computerBuilder = ComputerBuilder.getInstance();
        Date start = new Date();
        computerBuilder.buildComputer();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        List<Computer> computersBuilt = computerBuilder.getComputersBuilt();
        List<Component> componentsAssemblyList = computerBuilder.getcomponentsAssemblyList();

        computersBuilt.forEach(ignored ->
        {
            try
            {
                consoleLogger.logComputer(computersBuilt.size());
            } catch (Exception e)
            {
                consoleLogger.logError("Error in component assembly: ", e);
            }
        });

        int maxSize = 0;
        while (computerBuilder.isAssemblyLineOperational())
        {
            int size = componentsAssemblyList.size();
            if (size > maxSize)
                maxSize = size;
            Thread.sleep(100);
        }

        Date end = new Date();
        long difference = end.getTime() - start.getTime();
        out.println("It took " + difference + " milliseconds to build the computer");
        assertEquals(computersBuilt.size(), 1);
        assertEquals(true, computersBuilt.get(0).isBuilt());
        assertThat(maxSize, is(3));

    }

}


