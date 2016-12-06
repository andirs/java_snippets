package gui.mvc.spinner;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyChangeListener implements ChangeListener 
{
    private JLabel infoLabel;
    
    public MyChangeListener(JLabel infoLabel)
    {
        this.infoLabel = infoLabel;
    }
    
    public void stateChanged(ChangeEvent e)
    {
        String newValue = "";
        
        if (e.getSource() instanceof JSpinner)
        {
            JSpinner s = (JSpinner) e.getSource();
            newValue = s.getValue().toString();
        }
        
        else if (e.getSource() instanceof MySpinnerModel)
        {
            MySpinnerModel model = (MySpinnerModel) e.getSource();
            newValue = model.getValue().toString();
        }
        
        infoLabel.setText("neuer Wert: " + newValue);
        System.out.println("-------------------------------------------");
        System.out.println("Event Source:");
        System.out.println(e.getSource().toString());
        System.out.println("-------------------------------------------");
    }
}
