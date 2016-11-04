package plusminus;
import java.awt.event.*;

public class MinusController implements ActionListener
{
    private PlusMinusModel model;
    
    public MinusController(PlusMinusModel model)
    {
        this.model = model;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        model.decrement();
    }
}
