package threads.client;

import database.DBAccess;

public class ClientAddress extends Thread{
	
	public String address;
	String clientId;
	DBAccess db = new DBAccess();
	
	public ClientAddress()
	{
		clientId="";
	}
	
	public ClientAddress(String cId)
	{
		clientId=cId;
	}
	
	public void run()
	{
		address = db.searchClientAddress(clientId);
	}

}
