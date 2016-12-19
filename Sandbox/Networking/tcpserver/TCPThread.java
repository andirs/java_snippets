package tcpserver;

public class TCPThread extends Thread 
{
    private TCPSocket connection;
    private boolean isRunning;
    
    public TCPThread(TCPSocket socket)
    {
        this.connection = socket;
        this.isRunning = true;
        this.start();
    }
    
    public void shutdown()
    {
        this.isRunning = false;
    }
    
    public boolean isNumeric(String s)
    {
        boolean isNumeric = true;
        for (int i = 0; i < s.length(); i++)
        {
            if (Character.isAlphabetic(s.charAt(i)))
            {
                isNumeric = false;
                break;
            }
        }
        return isNumeric;
    }
    
    public void run()
    {
        try(TCPSocket s = connection)
        {
            while(isRunning)
            {
                String request = s.receiveLine();
                if (request != null)
                {
                    try
                    {
                        if (isNumeric(request))
                        {
                            int secs = Integer.parseInt(request);
                            Thread.sleep(secs * 1000);
                        }
                        else
                        {
                            if (request.equals("shutdown"))
                            {
                                shutdown();
                            }
                        }
                        
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    s.sendLine(request);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Connection closed...");
    }
}
