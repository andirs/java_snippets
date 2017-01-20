package pipe;

public class Pipe 
{
    private int head, tail, psize;
    private byte[] puffer;
    
    public Pipe(int maxSize)
    {
        if (maxSize <= 0)
            throw new IllegalArgumentException();
        puffer = new byte[maxSize];
        head = 0;
        tail = 0;
        psize = 0;
    }
    
    public synchronized void send(byte[] msg)
    {
        // Send message in one stop
        if (msg.length <= puffer.length)
        {
            // If message too large for puffer 
            // minus existing messages in puffer: wait
            while (msg.length > puffer.length - psize)
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
            // Put message at tail of puffer
            for (int i = 0; i < msg.length; i++)
            {
                puffer[tail++] = msg[i];
                psize++;
                if (tail == puffer.length)
                    tail = 0;
            }
            notifyAll();
        }
        // If message too large to send in one go, split it up
        else
        {
            int toSendNow = 0;
            int toSend = msg.length;
            int byteCounter = 0;
            while (toSend > 0)
            {
                // If puffer full, wait.
                while (puffer.length - psize == 0)
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
                int available = puffer.length - psize;
                toSendNow = available;
                for (int i = 0; i < toSendNow; i++)
                {
                    puffer[tail++] = msg[byteCounter];
                    psize++;
                    if (tail == puffer.length)
                        tail = 0;
                    byteCounter++;
                }
                toSend -= available;
                notifyAll();
            }
        }
    }
    
    public synchronized byte[] receive(int msgSize)
    {
        if (msgSize <= 0)
            throw new IllegalArgumentException();
        // If puffer is empty, wait.
        while (psize == 0)
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
        // If message size is bigger than available puffer
        // adjust message size to available puffer size 
        if (msgSize > psize)
            msgSize = psize;
        
        byte[] returnMsg = new byte[msgSize];
        for (int i = 0; i < returnMsg.length; i++)
        {
            returnMsg[i] = puffer[head++];
            if (head == puffer.length)
                head = 0;
            psize--;
        }
        notifyAll();
        
        return returnMsg;
    }

}
