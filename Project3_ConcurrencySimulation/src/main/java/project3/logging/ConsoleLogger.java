package main.java.project3.logging;

import static java.lang.System.*;

public class ConsoleLogger
{
    private static final String START = " assembly has STARTED ";
    private static final String END = " assembly has ENDED ";
    private static final String THREAD = "on Thread No: ";
    private static final String CONSOLE = "Console Log ";

    public void logComputer(int computersBuilt)
    {
        out.println(CONSOLE + " 1:  " + computersBuilt + " Computer has been successfully assembled");
    }

    public void logComponent(int componentsAssemblyList)
    {
        out.println(CONSOLE + " 2:  " + componentsAssemblyList + " Component(s) are currently being assembled");
    }

    public void logComponentDone(String component)
    {
        out.println(CONSOLE + " 3:  " + component + " Component of the computer" + END + "and is being REMOVED");
    }

    public void logComponentNext(int componentsRequiredQueue)
    {
        out.println(CONSOLE + " 4:  " + componentsRequiredQueue + " Component(s) left in Queue");
    }

    public void logComponentNull(String component)
    {
        out.println(CONSOLE + " 5:  " + component + " Component" + END);
    }

    public void logBuildStart()
    {
        out.println(CONSOLE + " 6:  " + "Computer" + START);
    }

    public void logBuildEnd()
    {
        out.println(CONSOLE + " 7:  " + "Full Computer" + END);
    }

    public void logCPUstart(String component, long thread)
    {
        out.println(CONSOLE + " 8:  " + component + START + THREAD + thread);
    }

    public void logCPUend(String component, long thread)
    {
        out.println(CONSOLE + " 9:  " + component + END + THREAD + thread);
    }

    public void logMotherboardstart(String component, long thread)
    {
        out.println(CONSOLE + "10:  " + component + START + THREAD + thread);
    }

    public void logMotherboardend(String component, long thread)
    {
        out.println(CONSOLE + "11:  " + component + END + THREAD + thread);
    }

    public void logRAMstart(String component, long thread)
    {
        out.println(CONSOLE + "12:  " + component + START + THREAD + thread);
    }

    public void logRAMend(String component, long thread)
    {
        out.println(CONSOLE + "13:  " + component + END + THREAD + thread);
    }

    public void logSATAstart(String component, long thread)
    {
        out.println(CONSOLE + "14:  " + component + START + THREAD + thread);
    }

    public void logSATAend(String component, long thread)
    {
        out.println(CONSOLE + "15:  " + component + END + THREAD + thread);
    }


    public void logError(String msg, Exception e)
    {
        err.println("\t\t\t---ERROR---\n " + msg + ";" + e + "\n------\n");
    }
}
