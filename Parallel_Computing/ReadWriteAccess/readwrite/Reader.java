package readwrite;

/**
 * Dummy Reader that showcases read/write 
 * capabilities of Access in concert with MyData. 
 */
public class Reader extends Thread 
{
    private MyData data;
    
    public Reader(MyData data, String name)
    {
        super(name);
        this.data = data;
        start();
    }
    
    public void run()
    {
        for (int i = 0; i < 10000; i++)
        {
            System.out.println(getName() + ": Read value " + ((Integer)data.read()).intValue());
        }
    }
}
