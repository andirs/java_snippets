package ipinfo;

import java.net.*;
import java.net.UnknownHostException;

/**
 * Simple app to determine IP addresses given a domain name.
 * Solving a toy problem for cs course.
 */

public class IPRequest 
{
    
    // Prints out IP addresses to given domain name
    public static void getIPs(String[] address)
    {
        InetAddress[] inetAddress = null;
        
        for (int i = 0; i < address.length; i++)
        {
            
            // Try getting all IP addresses by name
            // Heavy lifting is done by InetAddress Class
            try
            {
                inetAddress = InetAddress.getAllByName(address[i]);
            }
            catch (UnknownHostException e)
            {
                System.out.println("Couldn't find IP for " + address[i]);
                System.out.println("---------------------------------------------");
                continue;
            }
            
            if (inetAddress.length != 0)
            {
                System.out.println("List of IP addresses for " + address[i] + ":");
                
                for (InetAddress add : inetAddress)
                {

                    // First determine if an IP address is reachable
                    boolean reachable;
                    
                    try
                    {
                        reachable = add.isReachable(2000);
                    }
                    catch (Exception e)
                    {
                        reachable = false;
                    }
                    
                    String appendix = "";
                    
                    if (reachable)
                    {
                        appendix = "reachable";
                    }
                    else
                    {
                        appendix = "not reachable";
                    }
                    
                    // Print out IP address even if not reachable
                    System.out.println(add.getHostAddress() + " (" + appendix + ")");
                }
            }
            
            System.out.println("---------------------------------------------");
        }
        
    }
    
    public static void main (String[] args)
    {
        // Toy String to show quick implementation
        String inetAddressString[] = {"www.kicker.de", 
                                      "test.de", 
                                      "www.unknown.net", 
                                      "www.booya.org"};
        getIPs(inetAddressString);

        /* Outputs
        List of IP addresses for www.kicker.de:
        192.221.112.253 (not reachable)
        8.254.27.254 (not reachable)
        4.27.252.254 (not reachable)
        8.254.8.126 (not reachable)
        199.93.52.252 (not reachable)
        ---------------------------------------------
        List of IP addresses for test.de:
        104.45.6.189 (not reachable)
        ---------------------------------------------
        List of IP addresses for www.unknown.net:
        192.185.16.23 (reachable)
        ---------------------------------------------
        Couldn't find IP for www.booya.org
        ---------------------------------------------
        */
        
    }
    
}
