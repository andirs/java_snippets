package gui.land;

public class Land 
{
    private String name;
    private long einwohner;
    private long flaeche;
    private String hauptstadt;
    private long bevDichte;
    
    public Land(String name, long einwohner, long flaeche, String hauptstadt)
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
    public String runden(long num)
    {
        double number;
        
        if (num > 999999)
        {
            number = Math.round( (double) num/1000000);
            return String.format("%.0f", number) + " Mill.";
        }
        else if (num > 1000)
        {
            number = Math.round( (double) num / 1000);
            return String.format("%.3f", number);
        }
        else
        {
            return Long.toString(num);
        }
    }
    
    public String toString()
    {
        return getName();
    }
    
    public String getNonStatString()
    {
        return "Name: " + getName() + "\n"
                + "Hauptstadt: " + getHauptstadt() + "\n"
                + "Einwohner: " + runden(getEinwohner()) + "\n"
                + "Fläche (in qkm): " + runden(getFlaeche()) + "\n"
                + "Bevölkerungsdichte (in Personen pro qkm): " + getBevDichte() + "\n";
    }
}
