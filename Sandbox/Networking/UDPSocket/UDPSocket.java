import java.net.*;
import java.io.*;

/**
 * UDPSocket implementation with reply function.
 */
public class UDPSocket implements AutoCloseable 
{
    private InetAddress address;
    private int port;
    protected DatagramSocket socket;
    
    public UDPSocket() throws SocketException
    {
        this(new DatagramSocket());
    }
    
    public UDPSocket(int port) throws SocketException
    {
        this(new DatagramSocket(port));
    }
    
    protected UDPSocket(DatagramSocket s)
    {
        this.socket = s;
    }
    
    public void send(String s,
                     InetAddress address,
                     int port) throws IOException
    {
        byte[] msg = s.getBytes();
        DatagramPacket packet = new DatagramPacket(msg, msg.length, address, port);
        socket.send(packet);
    }
    
    public String receive(int maxLength) throws IOException
    {
        byte[] msg = new byte[maxLength];
        DatagramPacket packet = new DatagramPacket(msg, msg.length);
        socket.receive(packet);
        address = packet.getAddress();
        port = packet.getPort();
        
        return new String(msg, 0, packet.getLength());
    }
    
    public void reply(String s) throws IOException
    {
        if (address == null)
            throw new IllegalArgumentException();
        
        send(s, address, port);
    }
    
    public void setTimeout(int timeout) throws SocketException
    {
        socket.setSoTimeout(timeout);
    }
    
    public InetAddress getSenderAddress()
    {
        return address;
    }
    
    public int getSenderPort()
    {
        return port;
    }
    
    public void close()
    {
        socket.close();
    }
    

}
