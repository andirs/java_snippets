package world;

public class Producer extends Thread 
{
    private int start, end;
    private Puffer puffer;
    
    public Producer(int start, int end, Puffer puffer, String name)
    {
        super(name);
        if (start > end)
        {
            throw new IllegalArgumentException("Start value is larger than end value.");
        }
        this.start = start;
        this.end = end;
        this.puffer = puffer;
        start();
    }
    
    public void run()
    {
        for (int i = start; i <= end; i++)
        {
            synchronized(puffer)
            {
                puffer.set(i);
                System.out.println(Thread.currentThread().getName() + " deployed goods " + i);
            }
        }
    }
    

}
