package garage;

public class ParkingGarage 
{
	private int places;
	private int nextCar;
	private int nextWaitNr;
	
	public ParkingGarage(int places)
	{
		if (places < 0)
		{
			throw new IllegalArgumentException("Parameter < 0");
		}
		this.places = places;
	}
	
	public synchronized int getPlaces()
	{
		return places;
	}
	
	public synchronized void enter()
	{
		int myCarNr = nextWaitNr++;
		
		while (myCarNr != nextCar || places == 0)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
			}
		}
		places--;
		nextCar++;
		notifyAll();
	}
	
	public synchronized void leave()
	{
		places++;
		nextCar++;
		notifyAll();
	}
}