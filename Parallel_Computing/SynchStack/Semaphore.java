package SynchStack;

public class Semaphore 
{
    private int count;
    
    public Semaphore(int initialValue)
    {
        // Initialize Semaphore. initialValue can never be < 0
        if (initialValue < 0)
        {
            throw new IllegalArgumentException("Initial value has to be larger than 0");
        }
        count = initialValue;
    }
    
    /**
     * Reduces Semaphore count by one.
     * If count is equal to 0, the acting thread has to wait
     * until it's woken up and quick enough to proceed.
     */
    public synchronized void p()
    {
        while (count == 0)
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
    
    /**
     * Increases Semaphore count by one and notifies one 
     * waiting Thread to proceed. 
     */
    public synchronized void v()
    {
        count++;
        notifyAll();
    }
}
