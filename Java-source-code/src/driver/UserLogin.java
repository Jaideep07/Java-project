package driver;

import database.*;

public class UserLogin {
	
	DBAccessLogin db = new DBAccessLogin();

	public String clientLogin(String usrName, String password)
	{
		int returnVal = db.searchClient(usrName, password);
		if(returnVal==1)
		{
			// logged in successfully call a constructor to client Dashboard
			return ("Success");
		}
		
		else
		{
			// Display a pop up for this output
			return ("Incorrect username or password");
		}
	}
	
	public String retailerLogin(String usrName, String password)
	{
		int returnVal = db.searchRetailer(usrName, password);
		if(returnVal==1)
		{
			// logged in successfully call a constructor to client Dashboard
			return ("Success");
		}
		
		else
		{
			// Display a pop up for this output
			return ("Incorrect username or password");
		}
		
	}
	
	public String builderLogin(String usrName, String password)
	{
		int returnVal = db.searchBuilder(usrName, password);
		if(returnVal==1)
		{
			// logged in successfully call a constructor to client Dashboard
			return ("Success");
		}
		
		else
		{
			// Display a pop up for this output
			return ("Incorrect username or password");
		}
		
	}
	
	public String managerLogin(String usrName, String password)
	{
		int returnVal = db.searchManager(usrName, password);
		if(returnVal==1)
		{
			// logged in successfully call a constructor to client Dashboard
			return ("Success");
		}
		
		else
		{
			// Display a pop up for this output
			return ("Incorrect username or password");
		}
		
	}
	
	public String supervisorLogin(String usrName, String password)
	{
		int returnVal = db.searchSupervisor(usrName, password);
		if(returnVal==1)
		{
			// logged in successfully call a constructor to client Dashboard
			return ("Success");
		}
		
		else
		{
			// Display a pop up for this output
			return ("Incorrect username or password");
		}
		
	}
	


}
