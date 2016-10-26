public class Table 
{
    private boolean[] forks;
    private int philosophs;
    
    public Table(boolean[] forks, int philosophs)
    {
        this.forks = forks;
        this.philosophs = philosophs;
    }
    
    public boolean[] getForks()
    {
        return forks;
    }
    
    public synchronized void takeFork(int plate)
    {
        int forkNumberLeft = (((plate-1 % philosophs) + philosophs) % philosophs);
        int forkNumberRight = plate;
        while(!forks[forkNumberLeft] || !forks[forkNumberRight])
        {
            try
            {
                System.out.println(plate + " has to wait to eat.");
                wait();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        forks[forkNumberLeft] = false;
        forks[forkNumberRight] = false;
    }
    
    public synchronized void putFork(int plate)
    {
        int forkNumberLeft =  (((plate-1 % philosophs) + philosophs) % philosophs);
        int forkNumberRight = plate;
        
        forks[forkNumberLeft] = true;
        forks[forkNumberRight] = true;
        notifyAll();
    }
    
    public synchronized void eat(int plate)
    {
        
        System.out.println("Eating at plate: " + plate 
                               + " with Fork " + (((plate-1 % philosophs) + philosophs) % philosophs) 
                               + " and " + plate);
        
        try {
            // Eat some
            Thread.sleep((int) (Math.random() * 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    public synchronized void think(int plate)
    {
        System.out.println(plate + " thinks.");
    }

}
