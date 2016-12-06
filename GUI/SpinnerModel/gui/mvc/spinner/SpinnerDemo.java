/*
 * Spinner implementation with ChangeListener and 
 * handcrafted SpinnerModel.
 */

package gui.mvc.spinner;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.WindowConstants;

public class SpinnerDemo extends JFrame
{
    public SpinnerDemo(String name, long min, long max, long increment)
    {
        // Create View and Design
        super(name);
        setLayout(new GridLayout(0,1));
        setSize(200, 80);
        setLocation(200,200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        // Instantiate JSpinner
        MySpinnerModel model = new MySpinnerModel(min, max, increment);
        JSpinner spinner = new JSpinner(model);
        spinner.setName("spinner");
        
        
        JLabel infoLabel = new JLabel("neuer Wert: " + model.getValue());
        infoLabel.setName("infoLabel");
        
        // Add Change Listener
        MyChangeListener listener = new MyChangeListener(infoLabel);
        model.addChangeListener(listener);
        
        // Add elements to JFrame
        add(spinner);
        add(infoLabel);
        setVisible(true);
    }
    
    /*
     * main method not needed for grading
    public static void main(String[] args)
    {
        SpinnerDemo demo1 = new SpinnerDemo("Spinnerdemo", -12, 12, 2);
    }
    */
    
}
