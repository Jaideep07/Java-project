package threads;

import database.DBAccessManager;

public class BuilderPerformanceTracking extends Thread{
	
	public String builderPerformance[][];
	String mId;
	
	public BuilderPerformanceTracking()
	{
		mId = "";
	}
	
	public BuilderPerformanceTracking(String Id)
	{
		mId = Id;
	}
	
	DBAccessManager dbm = new DBAccessManager();
	
	public void run()
	{
		builderPerformance = dbm.builderPerformanceTrackingManager(mId);
	}

}
