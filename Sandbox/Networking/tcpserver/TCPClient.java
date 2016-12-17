package tcpserver;

public class TCPClient 
{
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Usage: <servername/ip-address> <incrementCount>");
            return;
        }
        
        System.out.println("Establishing connection...");
        try (TCPSocket tcpSocket = new TCPSocket(args[0], 1250))
        {
            System.out.println("Counter is being resetted...");
            tcpSocket.sendLine("reset");
            String reply = tcpSocket.receiveLine();
            
            System.out.println("Increasing counter...");
            int steps = new Integer(args[1]).intValue();
            long startTime = System.currentTimeMillis();
            
            for (int i = 0; i < steps; i++)
            {
                tcpSocket.sendLine("increment");
                reply = tcpSocket.receiveLine();
            }
            
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("Duration (overall): " + duration + " (msecs)");
            if (steps > 0)
            {
                System.out.println("Duration (average): " + duration / (float) steps + " (msecs)");    
            }
            System.out.println("Counter: " + reply);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        System.out.println("TCP connection closed...");
    }

}
