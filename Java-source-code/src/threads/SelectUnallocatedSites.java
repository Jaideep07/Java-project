package threads;

import database.DBAccessManager;

public class SelectUnallocatedSites extends Thread{
	
	public String unallocatedSites[][];
	
	DBAccessManager dbm = new DBAccessManager();
	
	public void run()
	{
		unallocatedSites = dbm.viewUnallocatedSites();
	}

}
