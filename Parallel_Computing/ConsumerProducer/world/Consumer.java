package world;

public class Consumer extends Thread 
{
    private int start, end, goods;
    private Puffer puffer;
    
    public Consumer(int start, int end, Puffer puffer, String name)
    {
        super(name);
        // Check and see, if start value is bigger than end
        if (start > end)
        {
            throw new IllegalArgumentException("Start value is larger than end value.");
        }
        this.puffer = puffer;
        this.start = start;
        this.end = end;
        start();
    }
    
    public void run()
    {
        for (int i = start; i <= end; i++)
        {
            synchronized(puffer)
            {    
                goods = puffer.get();
                System.out.println(Thread.currentThread().getName() + " got goods " + goods);
            }
        }
        
    }

}
