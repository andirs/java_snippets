package readwrite;

/**
 * Controls access to data input.
 * Synchronized method that favors writers over readers.
 */
public abstract class Access 
{
    private int activeReaders = 0, waitingReaders = 0, activeWriters = 0, waitingWriters = 0;
    protected abstract Object readReal();
    protected abstract void writeReal(Object data);
    
    public synchronized void beforeRead()
    {
        waitingReaders++;
        while (waitingWriters != 0 || activeWriters != 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        waitingReaders--;
        activeReaders++;
    }
    
    public synchronized void afterRead()
    {
        activeReaders--;
        notifyAll();
    }
    
    public synchronized void beforeWrite()
    {
        waitingWriters++;
        while (activeWriters != 0 || activeReaders != 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        waitingWriters--;
        activeWriters++;
    }
    
    public synchronized void afterWrite()
    {
        activeWriters--;
        notifyAll();
    }
    
    public Object read()
    {
        beforeRead();
        Object data = readReal();
        afterRead();
        return data;
    }
    
    public void write(Object data)
    {
        beforeWrite();
        writeReal(data);
        afterWrite();
    }
}
