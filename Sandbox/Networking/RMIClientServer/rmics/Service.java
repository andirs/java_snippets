package rmics;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Service interface for implementation of RMI functionality 
 * @author andirs
 */

public interface Service extends Remote 
{
    public Data open() throws RemoteException;
    public Data get() throws RemoteException;
    public Data close() throws RemoteException;
    public boolean isOpen() throws RemoteException;
}
