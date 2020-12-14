package actorClasses;

import database.DBAccessSupervisor;

public class Supervisor extends Builder implements ProjectOperations{
	
	DBAccessSupervisor db = new DBAccessSupervisor();

	public Supervisor(String sId)
	{
		super(sId);
	}
	
	public void allocateRawMaterials(String siteId, String materailName ,String materialModel,int materialQty, int reorderLevel, int avilableQty)
	{
		db.allocateRawMaterials(siteId,materailName,materialModel,materialQty,reorderLevel, avilableQty);
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
	
	public String[][] projectStatus(String bId)
	{
		String performance[][] = db.projectStatusSupervisor(bId);
		return(performance);
	}
	
	public void allocateSubcontracts(String pNo, String contractName, String companyName, long contactNumber)
	{
		db.allocateSubcontracts(pNo,contractName,companyName,contactNumber);
	}

}
