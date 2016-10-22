package Philosophs;

public class Table 
{
    private boolean[] forks;
    private int philosophs;
    
    public Table(boolean[] forks, int philosophs)
    {
        this.forks = forks;
        this.philosophs = philosophs;
    }
    
    private boolean[] getForks()
    {
        return forks;
    }
    
    public synchronized void eat(int plate)
    {
        int forkNumberLeft = (((plate-1 % philosophs) + philosophs) % philosophs);
        int forkNumberRight = ((plate) % philosophs);
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
        System.out.println("Eating at plate: " + plate 
                               + " with Fork " + forkNumberLeft 
                               + " and " + forkNumberRight);
        forks[forkNumberLeft] = false;
        forks[forkNumberRight] = false;
        
        try {
            // Eat some
            Thread.sleep((int) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        think(plate);
        
    }
    
    public synchronized void think(int plate)
    {
        int forkNumberLeft =  (((plate-1 % philosophs) + philosophs) % philosophs);
        int forkNumberRight = ((plate) % philosophs);
        
        System.out.println(plate + " has to wait to think.");
        
        forks[forkNumberLeft] = true;
        forks[forkNumberRight] = true;
        System.out.println("Fork: " + forkNumberLeft
                           + " & Fork: " + forkNumberRight 
                           + " are free again.");
        notifyAll();
    }

}
