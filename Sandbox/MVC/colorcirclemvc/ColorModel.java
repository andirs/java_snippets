package colorcirclemvc;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * MVC-Model: Model
 * Changes and returns color based on user input.
 */

public class ColorModel 
{
    private Color color;
    private ArrayList<ViewListener> listeners;
    
    public ColorModel()
    {
        listeners = new ArrayList<ViewListener>();
        color = Color.RED;
    }
    
    public void setColor(Color c)
    {
        color = c;
        fireModelChanged();
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void addViewListener(ViewListener circlePanel)
    {
        listeners.add(circlePanel);
    }
    
    public void removeViewListener(ViewListener l)
    {
        listeners.remove(l);
    }
    
    public void fireModelChanged()
    {
        for (ViewListener l : listeners)
        {
            l.valueChanged(this);
        }
    }

}
