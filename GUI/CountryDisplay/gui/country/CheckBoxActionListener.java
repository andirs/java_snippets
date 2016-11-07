package gui.country;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CheckBoxActionListener extends JFrame implements ActionListener
{
    /**
     * Action Listener for JCheckBox
     * Acts as model between CountryInformation and Country
     */
    private static final long serialVersionUID = 1L;
    CountryInformation information;
    
    public CheckBoxActionListener(CountryInformation information)
    {
        this.information = information;
    }
    public void actionPerformed(ActionEvent e)
    {
        Country selectedLand = (Country) information.getCountrySelector().getSelectedItem();
        if (((JCheckBox)e.getSource()).isSelected())
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
