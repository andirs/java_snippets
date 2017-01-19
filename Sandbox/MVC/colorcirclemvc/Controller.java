package colorcirclemvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MVC: Controller Class that responds to 
 * button push and sends information to model.
 */

public class Controller implements ActionListener 
{
    
    private ColorModel model;
    
    public Controller(ColorModel m)
    {
        model = m;
    }
    
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        if (command.equals("Red"))
        {
            model.setColor(Color.RED);
        }
        if (command.equals("Green"))
        {
            model.setColor(Color.GREEN);
        }
    }

}
