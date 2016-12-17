package udpserver;

import java.net.*;

public class Client 
{
    private static final int TIMEOUT = 10000;
    
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Usage: <name of server> <count of increments>");
            return;
        }
        
        try(UDPSocket udpSocket = new UDPSocket())
        {
            udpSocket.setTimeout(TIMEOUT);
            
            InetAddress serverAddress = InetAddress.getByName(args[0]);
            System.out.println("Counter was set to 0");
            udpSocket.send("reset", serverAddress, 1250);
            
            String reply = null;
            
            try
            {
                reply = udpSocket.receive(20);
                System.out.println("Counter: " + reply);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            
            System.out.println("Counter is being incremented");
            int incrementTimes = new Integer(args[1]).intValue();
            long startTime = System.currentTimeMillis();
            
            for (int i = 0; i < incrementTimes; i++)
            {
                udpSocket.send("increment", serverAddress, 1250);
                try
                {
                    reply = udpSocket.receive(20);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
            
            long duration = System.currentTimeMillis() - startTime;
            
            System.out.println("Duration (all): " + duration + " (msecs)");
            
            if (incrementTimes > 0)
            {
                System.out.println("Duration (average): " 
                                  + duration / (float) incrementTimes 
                                  + " (mescs)");
            }
            
            System.out.println("Last counter: " + reply);
            System.out.println("Expected counter: " + incrementTimes);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        System.out.println("DatagramSocket was closed...");
        
    }

}
