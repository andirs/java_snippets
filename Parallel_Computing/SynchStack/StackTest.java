package SynchStack;

public class StackTest 
{
    public static void main (String[] args)
    {
        SynchStack stack1 = new SynchStack();
        
        // Quick test of semaphore implementation with 5 different threads
        // where 2 threads are adding and 3 threads are receiving.
        
        StackThread[] threadCollection = new StackThread[5];
        for (int i = 0; i < 2; i++)
        {
            threadCollection[i] = new StackThread("Thread " + i, stack1, true);
        }
        for (int i = 2; i < 5; i++)
        {
            threadCollection[i] = new StackThread("Thread " + i, stack1, false);
        }
    }

}
