package world;

public class Puffer 
{
    private boolean isFull;
    private int storage;
    
    public Puffer()
    {
        
    }
    
    /**
     * Returns value that's stored in Puffer storage
     * if slot is full and available.
     * @return int value
     */
    public synchronized int get()
    {
        while (!isFull)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        notifyAll();
        isFull = false;
        return storage;
        
    }
    
    /**
     * Sets int value in Puffer storage if slot is free.
     * @param goods
     */
    public synchronized void set(int goods)
    {
        while (isFull)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                e.getStackTrace();
            }
        }
        storage = goods;
        isFull = true;
        notifyAll();
    }

}
