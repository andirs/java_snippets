public class StackTest 
{
    public static void main (String[] args)
    {
        SynchStack stack1 = new SynchStack();
        
        // Quick test of semaphore implementation with 5 different threads
        // where 2 threads are adding and 3 threads are receiving.
        
        StackThread[] threadCollection = new StackThread[100];
        for (int i = 10; i < 100; i++)
        {
            threadCollection[i] = new StackThread("Thread " + i, stack1, false);
        }
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        for (int i = 0; i < 10; i++)
        {
            threadCollection[i] = new StackThread("Thread " + i, stack1, true);
        }
    }

}
