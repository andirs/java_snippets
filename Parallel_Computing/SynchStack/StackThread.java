package SynchStack;

public class StackThread extends Thread
{
    private SynchStack stack;
    private boolean upper;
    
    public StackThread(String name, SynchStack stack, boolean upper)
    {
        super(name);
        this.stack = stack;
        this.upper = upper;
        start();
    }
    
    public void run()
    {
        int i = 0;
        while(true)
        {
            if (upper)
            {
                i++;
                System.out.println(getName() + " pushed package " + i);
                stack.push(getName() + " " + i + " (Size: "+ stack.getSize() + ")");
                try
                {
                    sleep((int) (Math.random() * 1000));
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            if (!upper)
            {
                System.out.println(getName() + " popped package: " + stack.pop());
                try
                {
                    sleep((int) (Math.random() * 1000));
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            
        }
    }

}
