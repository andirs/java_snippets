package gui.land;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;

public class LaenderInfos extends JFrame 
                          implements ActionListener 
{
    private JComboBox countrySelector;
    private JCheckBox exactValues;
    
    // Create JLabel Array with 5 values
    // 0 = land; 1 = hauptstadt; 2 = einwohner; 3 = flaeche; 4 = density
    private JLabel[] labels = new JLabel[5];
    // private JLabel[] values = new JLabel[5];
    
    private JLabel countryName, capital, population, area, density;
    
    public LaenderInfos(Land[] laender)
    {
        super("LänderInfos");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // JComboBox initiieren
        countrySelector = new JComboBox(laender);
        countrySelector.setName("countrySelector");
        
        // ActionListener an JComboBox anmelden
        countrySelector.addActionListener(this);
        
        // Use custom ComboBoxRenderer to show country names 
        // and avoid overriding toString()
        //ComboBoxRenderer renderer = new ComboBoxRenderer();
        //countrySelector.setRenderer(renderer);
        
        // Create JCheckBox
        exactValues = new JCheckBox("genaue Angaben");
        exactValues.setName("exactValues");
        exactValues.setSelected(true);
        
        // ActionListener an JCheckBox anmelden
        exactValues.addActionListener(this);
        
        // Create JLabels labels
        labels[0] = new JLabel("Land:");
        labels[1] = new JLabel("Hauptstadt:");
        labels[2] = new JLabel("Einwohner:");
        labels[3] = new JLabel("Fläche (in qkm):");
        labels[4] = new JLabel("Bevölkerungsdichte (in Personen pro qkm):");
        
        // Create JLabels values for GUI references
        // Get values from first entry of laender[] to match selection
        /*
        values[0] = new JLabel(laender[0].getName());
        values[1] = new JLabel(laender[0].getHauptstadt());
        values[2] = new JLabel(Long.toString(laender[0].getEinwohner()));
        values[3] = new JLabel(Long.toString(laender[0].getFlaeche()));
        values[4] = new JLabel(Long.toString(laender[0].getBevDichte()));
        */
        
        ArrayList<JLabel> values = new ArrayList<JLabel>();
        countryName = new JLabel(laender[0].getName());
        countryName.setName("countryName");
        capital = new JLabel(laender[0].getHauptstadt());
        capital.setName("capital");
        population = new JLabel(Long.toString(laender[0].getEinwohner()));
        population.setName("population");
        area = new JLabel(Long.toString(laender[0].getFlaeche()));
        area.setName("area");
        density = new JLabel(Long.toString(laender[0].getBevDichte()));
        density.setName("density");
        values.add(countryName);
        values.add(capital);
        values.add(population);
        values.add(area);
        values.add(density);
        
        // Set Main Container Layout
        setLayout(new BorderLayout());
        
        // Create two JPanel for Selection Controller and View
        JPanel headJPanel = new JPanel();
        JPanel mainJPanel = new JPanel();
        
        // Add Combo- and Checkbox to headJPanel
        headJPanel.setLayout(new GridLayout(0, 1));
        headJPanel.add(countrySelector);
        headJPanel.add(exactValues);
        
        // Add Labels and Values to mainJPanel
        mainJPanel.setLayout(new GridLayout(0,2));
        for (int i = 0; i < labels.length; i++)
        {
            mainJPanel.add(labels[i]);
            mainJPanel.add(values.get(i));
        }
        
        add(headJPanel, BorderLayout.NORTH);
        add(mainJPanel, BorderLayout.CENTER);
        
        setLocation(200, 200);
        setSize(600, 200);
        setVisible(true);
    }
    
    public JComboBox getComboBox()
    {
        return countrySelector;
    }
    
    private String formatieren(long zahl)
    {
        double number;
        
        if (zahl > 999999)
        {
            number = Math.round( (double) zahl/1000000);
            return String.format("%.0f", number) + " Mill.";
        }
        else if (zahl > 1000)
        {
            number = Math.round( (double) zahl / 1000) * 1000;
            return NumberFormat.getIntegerInstance().format(number);
        }
        else
        {
            return Long.toString(zahl);
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        // Create temporary storage for output Strings
        boolean exactFlag = this.exactValues.isSelected();
        Land selectedLand = (Land) this.countrySelector.getSelectedItem();
        //System.out.println(e.getSource() == countrySelector);
        
        // Never changing values
        /*
        values[0].setText(selectedLand.getName());
        values[1].setText(selectedLand.getHauptstadt());
        values[4].setText(Long.toString(selectedLand.getBevDichte()));
        */
        countryName.setText(selectedLand.getName());
        capital.setText(selectedLand.getHauptstadt());
        density.setText(Long.toString(selectedLand.getBevDichte()));
        
        
        if (e.getSource() == exactValues)
        {
            if (exactFlag)
            {
                /*
                values[2].setText(Long.toString(selectedLand.getEinwohner()));
                values[3].setText(Long.toString(selectedLand.getFlaeche()));
                */
                population.setText(Long.toString(selectedLand.getEinwohner()));
                area.setText(Long.toString(selectedLand.getFlaeche()));
            }
            else
            {       
                /*
                values[2].setText(formatieren(selectedLand.getEinwohner()));
                values[3].setText(formatieren(selectedLand.getFlaeche()));
                */
                population.setText(formatieren(selectedLand.getEinwohner()));
                area.setText(formatieren(selectedLand.getFlaeche()));
            }
        }
        
        else if (e.getSource() == countrySelector)
        {
            if (exactFlag)
            {
                /*
                values[2].setText(Long.toString(selectedLand.getEinwohner()));
                values[3].setText(Long.toString(selectedLand.getFlaeche()));
                */
                population.setText(Long.toString(selectedLand.getEinwohner()));
                area.setText(Long.toString(selectedLand.getFlaeche()));
            }
            else
            {         
                /*
                values[2].setText(formatieren(selectedLand.getEinwohner()));
                values[3].setText(formatieren(selectedLand.getFlaeche()));
                */
                population.setText(formatieren(selectedLand.getEinwohner()));
                area.setText(formatieren(selectedLand.getFlaeche()));
            }
        }
    }

    
    public static void main(String[] args)
    {
        /*
        Land[] laender = new Land[5];
        
        laender[0] = new Land("Schweden", 9415570, 450295, "Stockholm");
        //laender[0] = new Land("Luxemburg", 511840, 2586, "Luxemburg");
        laender[1] = new Land("Belgien", 10839905, 30528, "Brüssel");

        laender[2] = new Land("Kanada", 36286425, 9984670, "Ottawa");

        laender[3] = new Land("Schweiz", 8306200, 41285, "Bern");
        laender[4] = new Land("Deutschland", 82175684, 357375, "Berlin");
        
        LaenderInfos test = new LaenderInfos(laender);
        */
    }
}
