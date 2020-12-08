package threads.client;
import database.*;

public class ClientEmail extends Thread{
	
	public String email[];
	String clientId;
	DBAccess db = new DBAccess();
	
	public ClientEmail()
	{
		clientId="";
	}
	
	public ClientEmail(String cId)
	{
		clientId=cId;
	}
	
	public void run()
	{
		email = db.searchClientEmail(clientId);
	}

}
