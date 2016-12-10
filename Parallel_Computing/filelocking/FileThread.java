package pp.filelocking;

/*
 * Multi-Thread class for testing and show-casing purposes.
 */

public class FileThread extends Thread
{
    File file;
    int start, end;
    boolean up;
    
    public FileThread(String name, int start, int end, boolean up, File file)
    {
        super(name);
        this.file = file;
        this.start = start;
        this.end = end;
        this.up = up;
    }
    
    public void run()
    {
        if (up)
        {
            for (int i = start; i < end; i+=10)
            {
                file.lock(i+1, i+10);
                try {
                    sleep(1000);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        else
        {
            for (int i = end; i > start; i-=10)
            {
                file.unlock(i-9, i);
                try {
                    sleep(1000);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
    }
}
