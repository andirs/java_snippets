public class Philosoph extends Thread 
{
    private int plate;
    private Table table;
    private int bellyIsFull;

    public Philosoph(String name, int plate, Table table, int bellyIsFull)
    {
        super(name);
        this.plate = plate;
        this.table = table;
        this.bellyIsFull = bellyIsFull;
        start();
    }
    
    public void run()
    {
        while(bellyIsFull > 0)
        {
            table.takeFork(plate);
            try
            {
                sleep((int) (Math.random() * 2000));
                table.eat(plate);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            table.putFork(plate);
            table.think(plate);
            bellyIsFull--;
        }
        
        System.out.println(getName() + " is full.");
    }
    
}
