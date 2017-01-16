package readwrite;

/**
 * Toy-example that implements 20 Readers and Writers
 */

public class ReaderWriterExample 
{
    public static void main(String[] args)
    {
        MyData data = new MyData();
        int numberOfPlayers = 20;
        
        for (int i = 0; i < numberOfPlayers; i++)
        {
            new Reader(data, "Reader " + i);
            new Writer(data, "Writer " + i);
        }
    }
}
