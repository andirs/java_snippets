/**
* Quick Semaphore Implementation for synchronization jobs
*/

public class Semaphore 
{
    private int count;
    public Semaphore(int count)
    {
        if (count < 0)
        {
            this.count = count;
        }
        this.count = count;
    }
    
    public synchronized void p()
    {
        while(count == 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        count--;
    }
    
    public synchronized void v()
    {
        count++;
        notify();
    }

}
