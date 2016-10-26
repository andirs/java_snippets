/**
* Quick Semaphore Implementation for synchronization jobs
* Offers additive and simple semaphore use.
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
    
    public synchronized void p(int value)
    {
        while(count - value <= 0)
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
        count -= value;
    }
    
    public synchronized void v(int value)
    {
        count += value;
        notifyAll();
    }

    public void p()
    {
        p(1);
    }

    public void v()
    {
        v(1);
    }
}
