package readwrite;

/**
 * Dummy Writer that showcases read/write 
 * capabilities of Access in concert with MyData. 
 */
public class Writer extends Thread 
{
    private MyData data;
    
    public Writer(MyData data, String name)
    {
        super(name);
        this.data = data;
        start();
    }
    
    public void run()
    {
        for (int i = 0; i < 10000; i++)
        {
            data.write(i);
            System.out.println(getName() + ": wrote value " + i);
        }
    }

}
