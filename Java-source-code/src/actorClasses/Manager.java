package actorClasses;

import database.DBAccessManager;

public class Manager extends Builder implements ProjectOperations{

	DBAccessManager db = new DBAccessManager();

	public Manager(String mId)
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

	public String[][] viewProjectsForAssigning()
	{
		String projects[][] = db.viewProjectsForAssigning(id);
		return(projects);
	}

	public String[][] projectStatus(String pId)
	{
		String builders[][] = db.projectStatusManager(pId,id);
		return(builders);
	}

	public void updateProjectStatus(String pId, String status)
	{
		db.updateProjectStatusManager(pId,status);
	}

	public String[][] builderPerformanceTracking()
	{
		String performance[][] = db.builderPerformanceTrackingManager(id);
		return(performance);

	}
	
	public void giveSalaryBonus(String bId, double percent)
	{
		db.giveSalaryBonus(bId,percent);
	}


}
