package udpserver;

import java.io.*;
import java.net.*;

public class UDPMulticastSocket extends UDPSocket 
{
    public UDPMulticastSocket(int port) throws IOException
    {
        super(new MulticastSocket(port));
    }
    
    public void join(String mcAddress) throws IOException
    {
        InetAddress group = InetAddress.getByName(mcAddress);
        ((MulticastSocket) socket).joinGroup(group);
    }
    
    public void leave(String mcAddress) throws IOException
    {
        InetAddress group = InetAddress.getByName(mcAddress);
        ((MulticastSocket) socket).leaveGroup(group);
    }

}
