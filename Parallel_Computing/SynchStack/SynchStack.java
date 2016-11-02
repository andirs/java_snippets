import java.util.ArrayList;

public class SynchStack 
{
    private Semaphore sem;
    private Semaphore mutex;
    private ArrayList<Object> stackList;
    
    public SynchStack()
    {
        sem = new Semaphore(0);
        mutex = new Semaphore(1);
        stackList = new ArrayList<Object>();
    }
    
    public int getSize()
    {
        return stackList.size();
    }
    
    // Methods of SynchStack
    /**
     * Adds element to the start of the SynchStack.
     * Uses additive and mutex Semaphore to implement synchronizing.
     */
    public void push(Object o)
    {
        // Enter synchronized mode 
        mutex.p();
        
        // Add object to stackList
        stackList.add(0, o);
        // Add 1 to semaphore counter in order 
        // to signal it's possible to get an Object
        sem.v();
        
        // Leave synchronized mode
        mutex.v();
    }
    
    /**
     * Returns first Object of list and removes it from list.
     * @return Object
     */
    public Object pop()
    {
        // First check Semaphore if there are objects to get 
        // otherwise the thread will wait until something is available
        sem.p();
        
        // Enter synchronized mode
        mutex.p();
        // Perform critical action
        Object returnItem = stackList.get(0);
        stackList.remove(0);
        // Leave synchronized mode
        mutex.v();
        return returnItem;
        
    }
    

}
