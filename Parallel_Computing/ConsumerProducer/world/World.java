package world;

public class World 
{

    public static void main (String[] args)
    {
        Puffer puffer = new Puffer();
        Producer p1 = new Producer(1, 100, puffer, "Producer 1");
        Producer p2 = new Producer(101, 200, puffer, "Producer 2");
        Producer p3 = new Producer(201, 300, puffer, "Producer 3");
        Consumer c1 = new Consumer(1, 100, puffer, "Consumer 1");
        Consumer c2 = new Consumer(101, 200, puffer, "Consumer 2");
        Consumer c3 = new Consumer(201, 300, puffer, "Consumer 3");
    }
    
}
