package gui.country;
import java.awt.event.*;
import javax.swing.*;


public class ComboBoxActionListener extends JFrame implements ActionListener 
{
    CountryInformation information;
    
    public ComboBoxActionListener(CountryInformation information)
    {
        this.information = information;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        // Get information if the user wants the exact values
        boolean exactFlag = information.getExactValues();
        
        Country selectedLand = (Country) information.getCountrySelector().getSelectedItem();
        //System.out.println(e.getSource() == countrySelector);
        
        // Never changing values
        information.setValue(0, selectedLand.getName());
        information.setValue(1, selectedLand.getHauptstadt());
        information.setValue(4, Long.toString(selectedLand.getBevDichte()));
        
        if (exactFlag)
        {
            information.setValue(2, Long.toString(selectedLand.getEinwohner()));
            information.setValue(3, Long.toString(selectedLand.getFlaeche()));
        }
        else
        {         
            information.setValue(2, selectedLand.format(selectedLand.getEinwohner()));
            information.setValue(3, selectedLand.format(selectedLand.getFlaeche()));
        }
    }

}
