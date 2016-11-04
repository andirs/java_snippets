package plusminus;
import java.util.ArrayList;

public class PlusMinusModel 
{
    private int counter, min, max;
    private ArrayList<PlusMinusListener> listeners;
    
    public PlusMinusModel(int min, int max)
    {
        if (min > max)
        {
            throw new IllegalArgumentException("min > max");
        }
        this.min = min;
        this.max = max;
        this.counter = min;
        this.listeners = new ArrayList<PlusMinusListener>();
    }
    
    public void increment()
    {
        if (counter < max)
        {
            counter++;
            fireModelChanged();
        }
    }
    
    public void decrement()
    {
        if (counter > min)
        {
            counter--;
            fireModelChanged();
        }
    }
    
    public int getCounter()
    {
        return counter;
    }
    
    public int getMin()
    {
        return min;
    }
    
    public int getMax()
    {
        return max;
    }
    
    public void addPlusMinusListener(PlusMinusListener l)
    {
        listeners.add(l);
    }
    
    public void removePlusMinusListener(PlusMinusListener l)
    {
        listeners.remove(l);
    }
    
    private void fireModelChanged()
    {
        for (PlusMinusListener l: listeners)
        {
            l.valueChanged(this);
        }
    }
}
