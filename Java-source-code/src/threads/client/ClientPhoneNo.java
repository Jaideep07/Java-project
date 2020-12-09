package threads.client;

import database.DBAccess;

public class ClientPhoneNo extends Thread{

	public long phoneNo[];
	String clientId;
	DBAccess db = new DBAccess();
	
	public ClientPhoneNo()
	{
		clientId="";
	}
	
	public ClientPhoneNo(String cId)
	{
		clientId=cId;
	}
	
	public void run()
	{
		phoneNo = db.searchClientPhoneNo(clientId);
	}

}
