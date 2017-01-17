package iobyte;

/**
 * Simple thread-safe message queue solution.
 * Basic message-oriented middleware class.
 * Receives and sends byte[] arrays.
 */
public class ByteQueue 
{
    private int qsize, head, tail;
    private byte[][] queue;
    
    public ByteQueue(int maxSize)
    {
        if (maxSize <= 0)
            throw new IllegalArgumentException("Queue-Size has to be bigger than 0.");
        queue = new byte[maxSize][];
        System.out.println("Queue <byte> initialized. Size: " + maxSize);
    }
    
    /**
     * Stores byte array in queue.
     * Synchronized method to work thread safe.
     * @param msg - byte[] array
     */
    public synchronized void send(byte[] msg)
    {
        // If the queue is full, wait.
        while (qsize == queue.length)
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
        
        // Create new byte space for message
        queue[tail] = new byte[msg.length];
        for (int i = 0; i < msg.length; i++)
        {
            queue[tail][i] = msg[i];
        }
        
        qsize++;
        tail++;
        if (tail == queue.length)
        {
            tail = 0;
        }
        
        notifyAll();
    }
    
    /**
     * Returns first byte array from queue.
     * If queue is full, waits in thread safe manner. 
     * @return byte[] array
     */
    public synchronized byte[] receive()
    {
        // If there is no message stored yet, wait.
        while (qsize == 0)
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
        
        byte[] recMsg = queue[head];
        queue[head] = null;
        qsize--;
        head++;
        if (head == queue.length)
        {
            head = 0;
        }
        
        notifyAll();
        return recMsg;
    }

}
