package rmics;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class DataImpl implements Data, Serializable
{
    private ArrayList<String> list;
    
    public DataImpl()
    {
        list = new ArrayList<String>();
    }

    public synchronized void append(String s) throws RemoteException 
    {
        list.add(s);
    }

    public synchronized ArrayList<String> getValues() throws RemoteException 
    {
        return list;
    }

}
