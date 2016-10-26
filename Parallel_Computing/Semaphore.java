/**
* Quick Semaphore Implementation for synchronization jobs
*/

public class Semaphore 
{
    private int count;
    public Semaphore(int count)
    {
        this.count = count;
    }
    
    public synchronized void p()
    {
        try
        {
            while(count == 0)
            {
                wait();
            }
            count--;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    public synchronized void v()
    {
        count++;
        notify();
    }

}
