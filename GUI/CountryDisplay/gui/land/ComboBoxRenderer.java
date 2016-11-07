/*
 * Custom ComboBoxRenderer Class for GUI.
 * Extracts country name from Land object
 * to display properly in JComboBox.
 * This avoids overriding toString() method
 * and can be easily extended in order to create
 * a more individual solution.
 * For more information about ComboBoxRenderer refer to
 * the Oracle Java Documentation.
 */
package gui.land;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer 
{
    public ComboBoxRenderer()
    {
        //setOpaque(true);
        //setHorizontalAlignment(LEFT);
        //setVerticalAlignment(CENTER);
    }
    
    /**
     * Checks if given value is of class Land and extracts the
     * name of the country based on land.getName() and
     * modifies Cell text to display a String 
     * @return  ComboBoxRenderer
     */
    public Component getListCellRendererComponent(
                                        JList list,
                                        Object value,
                                        int index,
                                        boolean isSelected,
                                        boolean cellHasFocus)
    {
        if (value instanceof Land)
        {
            Land land = (Land) value;
            setText(land.getName());
        }
        
        return this;
    }
}
