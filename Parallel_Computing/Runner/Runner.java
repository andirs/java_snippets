package Runner;

public class Runner extends Thread 
{
	private Rennen rennen;
	
	public Runner(String name, Rennen r)
	{
		super(name);
		rennen = r;
	}
	
	public void run()
	{
		int timeT = (int)(Math.random() * 10000);
		try
		{
			sleep(timeT);
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
		
		rennen.crossLine(timeT, getName());
	}
}
