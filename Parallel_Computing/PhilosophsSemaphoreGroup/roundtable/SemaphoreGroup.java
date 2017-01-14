package roundtable;

public class SemaphoreGroup 
{
    private int[] values;
    
    public SemaphoreGroup(int numberOfMembers)
    {
        if (numberOfMembers <= 0)
            throw new IllegalArgumentException();
        
        values = new int[numberOfMembers];
        System.out.println("SemaphoreGroup: Group with " + numberOfMembers + " values created.");
    }
    
    public boolean canChange(int[] deltas)
    {
        if (values.length != deltas.length)
            throw new IllegalArgumentException("Differen group lengths. Values and deltas need to match.");
        
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] + deltas[i] < 0)
                return false;
        }
        
        return true;
    }
    
    public synchronized void change(int[] deltas)
    {
        while (!canChange(deltas))
        {
            try
            {
                //System.out.println("SemaphoreGroup: Waiting initiated.");
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < values.length; i++)
        {
            values[i] += deltas[i];
        }
        notifyAll();
    }
    
    public int getNumberOfMembers()
    {
        return values.length;
    }
}
