public class AttributOperation
{
	public final static int mehrwertsteuersatz = 19;

	public char alphabet;
	private boolean hunger;
	protected String[] freunde;
	public float verkaufspreis;
	private int gewinnmarge;
	private int einkaufspreis;

	public AttributOperation(int einkaufspreis)
	{
		this.hunger = true;
		this.freunde = new String[10];
		this.alphabet = new char[26];
		for (int i = 0; i < 26; i++)
			this.alphabet[i] = (char) i+'a';
		this.gewinnmarge = 25;
		this.einkaufspreis = einkaufspreis;
	}

	public float verkaufspreis()
	{
		return einkaufspreis + (einkaufspreis * gewinnmarge/100.0F)+(einkaufspreis * mehrwertsteuersatz/100.0F);
	}

	public void setEinkaufspreis(int preis)
	{
		einkaufspreis = preis;
	}

	public int getEinkaufspreis()
	{
		return einkaufspreis;
	}

	public static String getMehrwertsteuersatzAsString()
	{
		return Integer.toString(mehrwertsteuersatz);
	}

	public void setFreund(String freund, int pos)
	{
		this.freunde[pos] = freund;
	}

	public String[] getFreunde()
	{
		return freunde;
	}

	public String getAlphabet(int start, int end)
	{
		if (start > end)
			throw new IllegalArgumentException("Start value bigger than end value");
		if (start < 0) || (end < 0)
			throw new IllegalArgumentException("Value < 0");
		if (start > 26) || (end > 26)
			throw new IllegalArgumentException("Value > 26");

		String output = '';
		for (int i = start; i <= end; i++)
		{
			output += alphabet[i];
		}

		return output;

	}


}