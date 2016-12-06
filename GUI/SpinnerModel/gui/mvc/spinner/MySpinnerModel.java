package gui.mvc.spinner;

import java.util.ArrayList;

import javax.swing.SpinnerModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MySpinnerModel implements SpinnerModel 
{
    private long value, min, max, increment;
    private ArrayList<ChangeListener> listeners;
    
    public MySpinnerModel(long min, long max, long increment)
    {
        this.value = min;
        this.min = min;
        this.max = max;
        this.increment = increment;
        this.listeners = new ArrayList<ChangeListener>();
    }
    
    public Object getNextValue()
    {
        if ((value + increment) > max)
        {
            return null;
        }
        else
        {
            return value+increment;
        }
    }
    
    public Object getPreviousValue()
    {
        if ((value - increment) < min)
        {
            return null;
        }
        else
        {
            return value - increment;
        }
    }
    
    public Object getValue()
    {
        return value;
    }
    
    public void setValue(Object o)
    {
        this.value = (long) o;
        
        for (ChangeListener listener : listeners)
        {
            listener.stateChanged(new ChangeEvent(this));
        }
    }
    
    public void addChangeListener(ChangeListener l)
    {
        listeners.add(l);
    }
    
    public void removeChangeListener(ChangeListener l)
    {
        listeners.remove(l);
    }

}
