package rmics;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject
                         implements Service 
{
    private boolean isOpen = true;
    private DataImpl dataImpl;
    
    public ServiceImpl() throws RemoteException
    {
        isOpen = true;
        dataImpl = new DataImpl();
        try
        {
            UnicastRemoteObject.exportObject(dataImpl, 0);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * If Data object isn't exported, export it
     * and make it available by reference 
     */
    public synchronized Data open() throws RemoteException 
    {
        if (!isOpen)
        {
            isOpen = true;
            UnicastRemoteObject.exportObject(dataImpl, 0);
        }
        return dataImpl;
    }

    /**
     * Return Data object in the current state
     */
    public synchronized Data get() throws RemoteException 
    {
        return dataImpl;
    }

    public synchronized Data close() throws RemoteException 
    {
        if (isOpen)
        {
            isOpen = false;
            try
            {
                UnicastRemoteObject.unexportObject(dataImpl, false);
            }
            catch (Exception e)
            {
                System.out.println("Already unexported.");
            }
        }
        return dataImpl;
    }

    public synchronized boolean isOpen() throws RemoteException 
    {
        return isOpen;
    }

}
