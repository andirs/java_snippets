package garage;

public class Parking 
{
	public static void main(String[] args)
	{
		ParkingGarage garage = new ParkingGarage(10);
		for (int i = 0; i <= 20; i++)
			new Car("Auto " + i, garage);
	}

}
