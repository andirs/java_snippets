package counter;

public class BoundedCounter 
{
	private int counter, minimum, maximum;
	
	public BoundedCounter(int minimum, int maximum)
	{
		if (maximum < minimum)
		{
			throw new IllegalArgumentException();
		}
		
		this.minimum = minimum;
		this.maximum = maximum;
		counter = minimum;
	}
	
	public int get()
	{
		return counter;
	}
	
	public synchronized void up()
	{
		while (counter == maximum)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		counter++;
		notifyAll();
	}
	
	public synchronized void down()
	{
		while (counter == minimum)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		counter--;
		notifyAll();
	}

}
