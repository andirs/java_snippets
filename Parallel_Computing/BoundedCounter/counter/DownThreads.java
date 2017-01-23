package counter;

public class DownThreads extends Thread 
{
	private static int N = 100;
	private BoundedCounter bc;
	
	public DownThreads(BoundedCounter bc, String name)
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
				bc.down();
				System.out.println(getName() + " counted down. Count: " + bc.get());
			}
		}
	}
}
