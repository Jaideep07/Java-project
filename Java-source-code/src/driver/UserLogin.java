package driver;

import database.*;

public class UserLogin {
	
	DBAccess db = new DBAccess();

	public void clientLogin(String usrName, String password)
	{
		int returnVal = db.searchClient(usrName, password);
		if(returnVal==1)
		{
			// logged in successfully call a constructor to client Dashboard
			System.out.println("Success");
		}
		
		else
		{
			// Display a pop up for this output
			System.out.println("Incorrect username or password");
		}
	}
	
	public void retailerLogin(String usrName, String password)
	{
		int returnVal = db.searchRetailer(usrName, password);
		if(returnVal==1)
		{
			// logged in successfully call a constructor to client Dashboard
			System.out.println("Success");
		}
		
		else
		{
			// Display a pop up for this output
			System.out.println("Incorrect username or password");
		}
		
	}

}
