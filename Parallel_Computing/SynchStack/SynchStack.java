/**
* Simple synchronized implementation of a stack using only 
* Semaphores for synchronization and multi-threaded object consistency.
*/

package SynchStack;

import java.util.ArrayList;

public class SynchStack 
{
    private Semaphore sem;
    private ArrayList<Object> stackList;
    
    public SynchStack()
    {
        sem = new Semaphore(0);
        stackList = new ArrayList<Object>();
    }
    
    public int getSize()
    {
        return stackList.size();
    }
    
    // Methods of SynchStack
    /**
     * Adds element to the start of the SynchStack.
     * Uses Semaphore class to implement synchronizing.
     */
    public void push(Object o)
    {
        // Add 1 to semaphore counter in order 
        // to signal it's possible to get an Object
        stackList.add(0, o);
        sem.v();
    }
    
    /**
     * Returns first Object of list and removes it from list.
     * If list is empty this function throws an IllegalStateException
     * @return Object
     */
    public Object pop()
    {
        sem.p();
        Object returnItem = stackList.get(0);
        stackList.remove(0);
        return returnItem;
    }
    

}
