package plusminus;
import java.awt.event.*;

public class PlusController implements ActionListener 
{
    private PlusMinusModel model;
    
    public PlusController(PlusMinusModel model)
    {
        this.model = model;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        model.increment();
    }
}
