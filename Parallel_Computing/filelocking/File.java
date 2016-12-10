package pp.filelocking;

import java.util.ArrayList;
import java.util.HashMap;
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
            if (lockIsPossible)
                System.out.println("Lock is possible");
            else
                System.out.println("Lock is impossible");
        }
    }
    
    public void unlock(int start, int end)
    {
        checkBorders(start, end);
    }
    
    public synchronized void checkBorders(int start, int end)
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
    
    public static void main (String[] args)
    {
        File test = new File(100);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(50);
        list.add(70);
        test.setArray(list);
        test.lock(10, 20);
        test.lock(20, 55);
        test.lock(55, 65);
        test.lock(50, 70);
        test.lock(65, 75);
        test.lock(75, 80);
     }

}
