package roundtable;

public class Philosoph extends Thread 
{
    private SemaphoreGroup sems;
    private int leftFork, rightFork, number;
    
    public Philosoph(SemaphoreGroup sems,
                     int number)
    {
        this.sems = sems;
        this.number = number;
        leftFork = number;
        if (number + 1 < sems.getNumberOfMembers())
        {
            rightFork = number+1;
        }
        else
        {
            rightFork = 0;
        }
        
        start();
    }
    
    public void think()
    {
        System.out.println("Philosoph: Philosopher " + number + " is thinking.");
        philosopherSleep();
    }
    
    public void eat()
    {
        System.out.println("Philosoph: Philosopher " + number + " is eating.");
        philosopherSleep();
    }
    
    public void philosopherSleep()
    {
        try
        {
            sleep( (long) (Math.random() * 10) * 1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    public void run()
    {
        int[] deltas = new int[sems.getNumberOfMembers()];
        for (int i = 0; i < deltas.length; i++)
        {
            deltas[i] = 0;
        }
        
        while (true)
        {
            think();
            deltas[leftFork] = -1;
            deltas[rightFork] = -1;
            sems.change(deltas);
            eat();
            deltas[leftFork] = 1;
            deltas[rightFork] = 1;
            sems.change(deltas);
        }
    }
}
