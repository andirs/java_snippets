package plusminus;
import javax.swing.JButton;

public class ButtonView extends JButton implements PlusMinusListener 
{
    public static final int MAX_LIMIT = 1;
    public static final int MIN_LIMIT = 2;
    
    private int limitType;
    
    public ButtonView(String text, PlusMinusModel model,
                      int limitType)
    {
        super(text);
        this.limitType = limitType;
        this.valueChanged(model);
    }
    
    public void valueChanged(PlusMinusModel model)
    {
        int limit;
        if(limitType == MAX_LIMIT)
        {
            limit = model.getMax();
        }
        else
        {
            limit = model.getMin();
        }
        if (model.getCounter() == limit)
        {
            setEnabled(false);
        }
        else
        {
            setEnabled(true);
        }
    }
}
