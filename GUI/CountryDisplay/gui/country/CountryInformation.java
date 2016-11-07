package gui.country;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class CountryInformation extends JFrame
{
    /**
     * Shows an overview about countries and some key points
     * such as name, capital, population, area and density.
     * Creates graphic user interface to get information about
     * a select group of countries.
     * The information can be shown in detailed or less detailed form.
     */
    private static final long serialVersionUID = 1L;
    private JComboBox<Country> countrySelector;
    private JCheckBox exactValues;
    
    // Create JLabel Arrays with 5 labels and values
    // 0 = country; 1 = capital; 2 = population; 3 = area; 4 = density
    private JLabel[] displayLabels = new JLabel[5];
    private JLabel[] displayValues = new JLabel[5];
    
    public CountryInformation(Country[] countries)
    {
        super("Country Information");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // Initiate JComboBox
        countrySelector = new JComboBox<Country>(countries);
        countrySelector.setName("countrySelector");
        
        // ActionListener an JComboBox anmelden
        countrySelector.addActionListener(new ComboBoxActionListener(this));
        
        // Use custom ComboBoxRenderer to show country names 
        // and avoid overriding toString()
        ComboBoxRenderer renderer = new ComboBoxRenderer();
        countrySelector.setRenderer(renderer);
        
        // Create JCheckBox
        exactValues = new JCheckBox("genaue Angaben");
        exactValues.setName("exactValues");
        exactValues.setSelected(true);
        
        // ActionListener an JCheckBox anmelden
        exactValues.addActionListener(new CheckBoxActionListener(this));
        
        // Create JLabels labels
        displayLabels[0] = new JLabel("Land:");
        displayLabels[1] = new JLabel("Hauptstadt:");
        displayLabels[2] = new JLabel("Einwohner:");
        displayLabels[3] = new JLabel("Fläche (in qkm):");
        displayLabels[4] = new JLabel("Bevölkerungsdichte (in Personen pro qkm):");
        
        // Create JLabels values
        displayValues[0] = new JLabel(countries[0].getName());
        displayValues[1] = new JLabel(countries[0].getHauptstadt());
        displayValues[2] = new JLabel(Long.toString(countries[0].getEinwohner()));
        displayValues[3] = new JLabel(Long.toString(countries[0].getFlaeche()));
        displayValues[4] = new JLabel(Long.toString(countries[0].getBevDichte()));
        
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
        for (int i = 0; i < displayLabels.length; i++)
        {
            mainJPanel.add(displayLabels[i]);
            mainJPanel.add(displayValues[i]);
        }
        
        add(headJPanel, BorderLayout.NORTH);
        add(mainJPanel, BorderLayout.CENTER);
        
        setLocation(200, 200);
        setSize(600, 200);
        setVisible(true);
    }
    
    /**
     * Getter Method for countrySelector
     * @return  JComboBox<Country> this.countrySelector
     */
    public JComboBox<Country> getCountrySelector()
    {
        return countrySelector;
    }
    
    /**
     * Offers way to manipulate value for view.
     * @param idx:          id of String value to manipulate
     * @param changeValue:  String with content that is supposed to be displayed.
     */
    public void setValue(int idx, String changeValue)
    {
        displayValues[idx].setText(changeValue);
    }
    
    /**
     * Returns boolean value whether JCheckBox is selected or not.
     * @return  true or false
     */
    public boolean getExactValues()
    {
        return exactValues.isSelected();
    }
    
    public static void main(String[] args)
    {
        
        Country[] countries = new Country[6];
        
        countries[0] = new Country("Schweden", 9415570, 450295, "Stockholm");
        countries[1] = new Country("Belgien", 10839905, 30528, "Brüssel");
        countries[2] = new Country("Kanada", 36286425, 9984670, "Ottawa");
        countries[3] = new Country("Schweiz", 8306200, 41285, "Bern");
        countries[4] = new Country("Deutschland", 82175684, 357375, "Berlin");
        countries[5] = new Country("Luxemburg", 511840, 2586, "Luxemburg");
        
        CountryInformation countryFrame = new CountryInformation(countries);
        
    }
}
