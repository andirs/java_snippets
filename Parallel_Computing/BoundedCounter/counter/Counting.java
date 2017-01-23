package counter;

public class Counting
{
	public static void main (String[] args)
	{
		int amount = 3;
		BoundedCounter bc = new BoundedCounter(10, 50);
		UpThreads[] ut = new UpThreads[amount];
		DownThreads[] dt = new DownThreads[amount];
		
		for (int i = 0; i < amount; i++)
		{
			ut[i] = new UpThreads(bc, "UpThread " + i);
			dt[i] = new DownThreads(bc, "DownThread " + i);
		}
	}
}
