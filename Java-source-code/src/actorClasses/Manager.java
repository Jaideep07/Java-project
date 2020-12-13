package actorClasses;

import database.DBAccess;

public class Manager extends Builder implements ProjectOperations{

	DBAccess db = new DBAccess();
	
	Manager(String mId)
	{
		super(mId);
	}
	
	
	public void allocateProjects(String Pname, String assignedDate, String startDate, String endDate, String tenure, String siteId)
	{
		db.allocateProject(Pname,assignedDate,startDate,endDate,tenure, this.id,siteId);
		
	}
	
	public String[][] viewUnallocatedSites()
	{
		String Sites[][] = db.viewUnallocatedSites();
		return(Sites);
	}
	
	public void assignProject(String pId, String bId)
	{
		db.assignProject(pId,bId);
	}
	
	public String[][] viewProjectsForAssigning(String mId)
	{
		String projects[][] = db.viewProjectsForAssigning(mId);
		return(projects);
	}
	

}
