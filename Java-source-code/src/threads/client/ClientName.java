package threads.client;

import database.DBAccess;

public class ClientName extends Thread{
	
	public String Name;
	String clientId;
	DBAccess db = new DBAccess();
	
	public ClientName()
	{
		clientId="";
	}
	
	public ClientName(String cId)
	{
		clientId=cId;
	}
	
	public void run()
	{
		Name = db.searchClientName(clientId);
	}

}
