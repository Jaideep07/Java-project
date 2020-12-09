package actorClasses;

import threads.client.*;
import java.util.Scanner;

public class Client {

	public String clientId;
	protected String name;
	protected String[] email;
	protected long[] phoneNo;
	protected String address;
	
	Client()
	{
		clientId="";
	}
	
	Client(String cId)
	{
		clientId = cId;
		ClientAddress ca = new ClientAddress(clientId);
		ClientEmail ce = new ClientEmail(clientId);
		ClientName cn = new ClientName(clientId);
		ClientPhoneNo cp = new ClientPhoneNo(clientId);
		ca.start();
		ce.start();
		cn.start();
		cp.start();
		
		try
		{
			ca.join();
			ce.join();
			cn.join();
			cp.join();
		}
		
		catch(InterruptedException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		name = cn.Name;
		email = ce.email;
		phoneNo = cp.phoneNo;
		address = ca.address;
	}
	
	public String getName()
	{
		return(name);
	}
	
	public String getAddress()
	{
		return(address);
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String cId = in.next();
		Client c = new Client(cId);
		
		System.out.println(c.getName());
		System.out.println(c.getAddress());
		in.close();
		
	}

}

