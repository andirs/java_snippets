package gui.country;

import java.text.NumberFormat;

public class Country 
{
    private String name;
    private long einwohner;
    private long flaeche;
    private String hauptstadt;
    private long bevDichte;
    
    public Country(String name, long einwohner, long flaeche, String hauptstadt)
    {
        this.name = name;
        this.einwohner = einwohner;
        this.flaeche = flaeche;
        this.hauptstadt = hauptstadt;
        bevDichte = Math.round(einwohner / (double) flaeche);
    }
    
    public String getName()
    {
        return name;
    }
    
    public long getEinwohner()
    {
        return einwohner;
    }
    
    public long getFlaeche()
    {
        return flaeche;
    }
    
    public String getHauptstadt()
    {
        return hauptstadt;
    }
    
    public int getBevDichte()
    {
        return (int) bevDichte;
    }
    
    /**
     * Returns String for easy print-out.
     * @return  String for print-out as stored in the Object.
     */
    public String getInfoString()
    {
        return "Name: " + getName() + "\n"
             + "Hauptstadt: " + getHauptstadt() + "\n"
             + "Einwohner: " + getEinwohner() + "\n"
             + "Fläche (in qkm): " + getFlaeche() + "\n"
             + "Bevölkerungsdichte (in Personen pro qkm): " + getBevDichte() + "\n";
    }
    
    /**
     * Turn precise values into easy to read values for print-out.
     * Values > 1,000,000 will be rounded up to next Million
     * Values > 1,000 will be rounded up to next Thousand
     * @param  num  long value
     * @return      String for print-out with possible additions.
     */
    public String format(long zahl)
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
    
    public String getNonStatString()
    {
        return "Name: " + getName() + "\n"
                + "Hauptstadt: " + getHauptstadt() + "\n"
                + "Einwohner: " + format(getEinwohner()) + "\n"
                + "Fläche (in qkm): " + format(getFlaeche()) + "\n"
                + "Bevölkerungsdichte (in Personen pro qkm): " + getBevDichte() + "\n";
    }
}
