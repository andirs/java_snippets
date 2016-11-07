package gui.land;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class LaenderInfos extends JFrame implements ActionListener 
{
    private JComboBox cb;
    private JLabel land;
    private JLabel einwohner;
    private JLabel flaeche;
    private JLabel haupstadt;
    
    public LaenderInfos(Land[] laender)
    {
        super("LänderInfos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // JComboBox erzeugen
        JComboBox cb = new JComboBox(laender);
        
        // Use custom ComboBoxRenderer to show country names 
        // and avoid overriding toString()
        ComboBoxRenderer renderer = new ComboBoxRenderer();
        cb.setRenderer(renderer);
        
        //JPanel mainJPanel = new JPanel();
        //mainJPanel.setLayout(new GridLayout(1,0));
        add(cb);
        
        setLocation(200, 200);
        setSize(300, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
    }
    
    public static void main(String[] args)
    {
        Land[] laender = new Land[3];
        laender[0] = new Land("Belgien", 10839905, 30528, "Brüssel");
        //System.out.println(TestLand.getInfoString());
        //System.out.println(Belgien.getNonStatString());
        laender[1] = new Land("Kanada", 36286425, 9984670, "Ottawa");
        //System.out.println(Kanada.getNonStatString());
        laender[2] = new Land("TinyLand", 855, 900, "Tiny Capital");
        //System.out.println(TinyLand.getNonStatString());
        
        new LaenderInfos(laender);
        
    }

}
