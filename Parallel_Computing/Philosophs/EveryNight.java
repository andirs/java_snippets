package Philosophs;

public class EveryNight 
{

    public static void main(String[] args) 
    {
        boolean[] forks = new boolean[5];
        // Make all forks available for eating
        for (int i = 0; i < forks.length; i++)
        {
            forks[i] = true;
        }
        
        // Initialize the renown banquet of Socrates
        Table socratesTable = new Table(forks, 5);
        
        Philosoph hegel = new Philosoph("Hegel", 0, socratesTable, 5);
        Philosoph kant = new Philosoph("Kant", 1, socratesTable, 5);
        Philosoph socrates = new Philosoph("Socrates", 2, socratesTable, 5);
        Philosoph rousseau = new Philosoph("Rousseau", 3, socratesTable, 5);
        Philosoph locke = new Philosoph("Locke", 4, socratesTable, 5);
    }

}
