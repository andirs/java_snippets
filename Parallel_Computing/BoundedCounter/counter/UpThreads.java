package counter;

public class UpThreads extends Thread 
{
	private static int N = 100;
	private BoundedCounter bc;
	
	public UpThreads(BoundedCounter bc, String name)
	{
		super(name);
		this.bc = bc;
		start();
	}
	
	public void run()
	{
		for (int i = 0; i < N; i++)
		{
			synchronized(bc)
			{
				bc.up();
				System.out.println(getName() + " counted up. Count: " + bc.get());
			}
		}
	}
}
