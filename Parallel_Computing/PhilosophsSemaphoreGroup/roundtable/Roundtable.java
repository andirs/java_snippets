package roundtable;

public class Roundtable 
{
    public static void main(String[] args)
    {
        int numberOfPhilosophs = 7;
        int[] init = new int[numberOfPhilosophs];
        for (int i = 0; i < init.length; i++)
        {
            init[i] = 1;
        }
        SemaphoreGroup forks = new SemaphoreGroup(numberOfPhilosophs);
        forks.change(init);
        for (int i = 0; i < numberOfPhilosophs; i++)
        {
            new Philosoph(forks, i);
        }
    }
}
