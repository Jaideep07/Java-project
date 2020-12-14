package actorClasses;

import database.DBAccess;

public class Supervisor extends Builder implements ProjectOperations{
	
	DBAccess db = new DBAccess();

	public Supervisor(String sId)
	{
		super(sId);
	}
	
	public void allocateRawMaterials(String siteId, String materailName ,String materialModel)
	{
		db.allocateRawMaterials(siteId,materailName,materialModel);
	}
	
	public String[][] getRawMaterials()
	{
		String rawMaterials[][] = db.getRawMaterials();
		return(rawMaterials);
	}
	
	public String[][] builderPerformanceTracking()
	{
		String builders[][] = db.builderPerformanceTrackingSupervisor(id);
		return(builders);
	}
	
	public String[][] projectStatus(String pId)
	{
		String performance[][] = db.projectStatusSupervisor(pId);
		return(performance);
	}
	
	public void allocateSubcontracts(String pNo, String contractName, String companyName, long contactNumber)
	{
		db.allocateSubcontracts(pNo,contractName,companyName,contactNumber);
	}

}
