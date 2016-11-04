package plusminus;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.*;

public class CounterView extends JLabel implements PlusMinusListener 
{
    public static final int DECIMAL_FORMAT = 1;
    public static final int HEXADECIMAL_FORMAT = 2;
    public static final int OCTAL_FORMAT = 3;
    
    private int format;
    
    public CounterView(PlusMinusModel model, int format)
    {
        this.format = format;
        this.valueChanged(model);
    }
    
    public CounterView(PlusMinusModel model)
    {
        this(model, DECIMAL_FORMAT);
    }
    
    public void valueChanged(PlusMinusModel model)
    {
        String s = "Unknown Format";
        switch(format)
        {
        case DECIMAL_FORMAT:
            s = model.getCounter() + " (decimal)";
            break;
        case HEXADECIMAL_FORMAT:
        case OCTAL_FORMAT:
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            String formatString, appendix;
            if(format == HEXADECIMAL_FORMAT)
            {
                formatString = "%x";
                appendix = " (hexadecimal)";
            }
            else
            {
                formatString = "%o";
                appendix = " (octal)";
            }
            pw.printf(formatString, model.getCounter());
            s = sw.toString() + appendix;
        }
        setText(s);
    }
}
