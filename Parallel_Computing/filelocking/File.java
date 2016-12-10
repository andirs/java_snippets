/*
 * Implementation of simple file locker;
 * Simulates synchronized file locking method 
 * that's restricted to only one thread for any given interval.
 */      

package pp.filelocking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class File 
{
    private int fileSize;
    private ArrayList<Integer> lockMap;
    
    public File(int fileSize)
    {
        if (fileSize < 0)
        {
            throw new IllegalArgumentException("only positive values");
        }
        
        this.fileSize = fileSize;
        lockMap = new ArrayList<Integer>();
    }
    
    /**
     * Locks interval if not locked yet.
     * If locked, the thread waits.
     * @param start     - start of interval
     * @param end       - end of interval
     */
    public synchronized void lock(int start, int end)
    {
        checkBorders(start, end);
        int startCheck, endCheck;
        boolean lockIsPossible = true;
        
        // check if interval is locked already
        Iterator<Integer> iterator = lockMap.iterator();
        while (iterator.hasNext() && !(lockMap.isEmpty()))
        {
            startCheck = iterator.next();
            endCheck = iterator.next();
            if((start <= startCheck && end >= startCheck) || ((start >= startCheck && end <= endCheck)) || ((start >= startCheck) && (start <= endCheck)))
            {
                lockIsPossible = false;
            }
        }
        if (lockIsPossible)
        {
            System.out.println("Lock (" + start + " | " + end + ") added.");
            lockMap.add(start);
            lockMap.add(end);
        }
        else
        {
            System.out.println("Lock (" + start + " | " + end + ") is impossible");
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
            
            
    }
    
    /**
     * Unlocks interval if locked.
     * If unlocked, the method notifies all waiting threads.
     * @param start     - start of interval
     * @param end       - end of interval
     */
    public synchronized void unlock(int start, int end)
    {
        checkBorders(start, end);
        int startCheck = 0, endCheck = 0;
        boolean unlockIsPossible = false;
        
        // check if interval is locked already
        Iterator<Integer> iterator = lockMap.iterator();
        while (iterator.hasNext() && !(lockMap.isEmpty()))
        {
            startCheck = iterator.next();
            endCheck = iterator.next();
            if(start == startCheck && end == endCheck)
            {
                unlockIsPossible = true;
            }
            
        }
        if (unlockIsPossible)
        {
            System.out.println("Lock (" + start + " | " + end + ") removed.");
            lockMap.remove(Integer.valueOf(startCheck));
            lockMap.remove(Integer.valueOf(endCheck));
            notifyAll();
        }
        else
        {
            System.out.println("Unlock (" + start + " | " + end + ") is impossible");
        }
            
        
    }
    
    /**
     * Checks if given borders are valid.
     * @param start     - start of interval
     * @param end       - end of interval
     */
    public void checkBorders(int start, int end)
    {
        if ((end < start) || (end < 0) || (start < 0) || (end > fileSize))
        {
            throw new IllegalArgumentException("Check your values ++ End value: " + end + " | Start value: " + start + " | fileSize: " + fileSize);
        }
    }
    
    public void setArray(ArrayList<Integer> list)
    {
        this.lockMap = list;
    }
    
    public String print()
    {
        // Needs to be immutable
        //return (ArrayList<Integer>) Collections.unmodifiableList(lockMap);
        int parseCounter = 0;
        String output = "";
        for (int i : lockMap)
        {
            if (parseCounter % 2 == 1)
            {
                output += i + " ] ";
            }
            else 
            {
                output += "[ " + i + " | ";
            }
            parseCounter++;
            
        }
        
        System.out.println(output);
        
        return output;
    }

}
