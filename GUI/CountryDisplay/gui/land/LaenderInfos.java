package gui.land;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class LaenderInfos extends JFrame 
                          implements ActionListener 
{
    private JComboBox cb;
    
    // Create JLabel Array with 5 values
    // 0 = land; 1 = hauptstadt; 2 = einwohner; 3 = flaeche; 4 = density
    private JLabel[] labels = new JLabel[5];
    private JLabel[] values = new JLabel[5];
    /*
    private JLabel land;
    private JLabel einwohner;
    private JLabel flaeche;
    private JLabel haupstadt;
    */
    
    public LaenderInfos(Land[] laender)
    {
        super("LänderInfos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // JComboBox erzeugen
        JComboBox cb = new JComboBox(laender);
        
        // ActionListener an JComboBox anmelden
        cb.addActionListener(this);
        
        // Use custom ComboBoxRenderer to show country names 
        // and avoid overriding toString()
        ComboBoxRenderer renderer = new ComboBoxRenderer();
        cb.setRenderer(renderer);
        
        // Create JCheckBox
        JCheckBox detailedView = new JCheckBox("genaue Angaben");
        detailedView.setSelected(true);
        
        // Create JLabels labels
        labels[0] = new JLabel("Land:");
        labels[1] = new JLabel("Hauptstadt:");
        labels[2] = new JLabel("Einwohner:");
        labels[3] = new JLabel("Fläche (in qkm):");
        labels[4] = new JLabel("Bevölkerungsdichte (in Personen pro qkm):");
        
        // Create JLabels values for GUI references
        
        
        //JPanel mainJPanel = new JPanel();
        setLayout(new GridLayout(0, 1));
        add(cb);
        add(detailedView);
        for (int i = 0; i < labels.length; i++)
        {
            add(labels[i]);
        }
        
        setLocation(200, 200);
        setSize(600, 200);
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
