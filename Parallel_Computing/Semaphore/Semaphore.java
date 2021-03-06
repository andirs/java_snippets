/**
* Quick Semaphore Implementation for synchronization jobs
* Offers additive and simple semaphore use.
*/

public class Semaphore 
{
    private int count;
    public Semaphore(int count)
    {
        // Semaphore count can't get smaller than 0
        // if so, set it to 0 - which indicates an exclusive 
        // semaphore
        if (count < 0)
        {
            this.count = 0;
        }
        this.count = count;
    }
    
    public synchronized void p(int value)
    {
        // If the value is too big, wait.
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
        // Subtract value from internal semaphore count
        count -= value;
    }
    
    public synchronized void v(int value)
    {
        // Increase semaphore count by value and 
        // notify all waiting threads.
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
