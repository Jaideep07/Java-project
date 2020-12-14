package threads;

import database.DBAccessManager;

public class ViewProjectsForAssigning extends Thread{
	
	public String projectsForAssigning[][];
	String mId;
	
	public ViewProjectsForAssigning()
	{
		mId = "";
	}
	
	public ViewProjectsForAssigning(String Id)
	{
		mId = Id;
	}
	
	DBAccessManager dbm = new DBAccessManager();
	
	public void run()
	{
		projectsForAssigning = dbm.viewProjectsForAssigning(mId);
	}
	

}
