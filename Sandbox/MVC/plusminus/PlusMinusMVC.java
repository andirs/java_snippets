package plusminus;
import java.awt.GridLayout;
import javax.swing.*;

public class PlusMinusMVC extends JFrame 
{
    public PlusMinusMVC(PlusMinusModel model, String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel c = new JPanel();
        c.setLayout(new GridLayout(0,1));
        
        CounterView view1 = new CounterView(model, 
                                            CounterView.DECIMAL_FORMAT);
        model.addPlusMinusListener(view1);
        CounterView view2 = new CounterView(model,
                                            CounterView.HEXADECIMAL_FORMAT);
        model.addPlusMinusListener(view2);
        CounterView view3 = new CounterView(model,
                                            CounterView.OCTAL_FORMAT);
        model.addPlusMinusListener(view3);
        
        ButtonView plus = new ButtonView(" + ", model, ButtonView.MAX_LIMIT);
        model.addPlusMinusListener(plus);
        
        ButtonView minus = new ButtonView(" - ", model, ButtonView.MIN_LIMIT);
        model.addPlusMinusListener(minus);
        
        c.add(plus);
        c.add(view1);
        c.add(view2);
        c.add(view3);
        c.add(minus);
        add(c);
        
        PlusController pc = new PlusController(model);
        MinusController mc = new MinusController(model);
        
        plus.addActionListener(pc);
        minus.addActionListener(mc);
        
        setSize(300, 150);
        setLocation(50, 50);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        if(args.length != 2)
        {
            System.out.println("Parameter: min max");
            System.exit(0);
        }
        int min = 0, max = 0;
        try
        {
            min = Integer.parseInt(args[0]);
            max = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Wrong Format (expected number)");
        }
        PlusMinusModel model = new PlusMinusModel(min, max);
        new PlusMinusMVC(model, "PlusMinus");
    }
}
