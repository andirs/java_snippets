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
package gui.country;

import java.awt.*;
import javax.swing.*;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer 
{   
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
        if (value instanceof Country)
        {
            Country selectedCountry = (Country) value;
            setText(selectedCountry.getName());
        }
        
        return this;
    }
}
