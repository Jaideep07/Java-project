package actorClasses;

import database.DBAccessAcceptingAuthority;

public class AcceptingAuthority {
	
	DBAccessAcceptingAuthority db = new DBAccessAcceptingAuthority();
	
	public AcceptingAuthority()
	{
		
	}
	
	public String[][] getRetailers()
	{
		String retailers[][] = db.getRetailers();
		return(retailers);
	}
	
	public String[][] showUnallocatedMaterials()
	{
		String unallocatedRawMaterials[][] = db.getUnallocatedRawMaterials();
		return(unallocatedRawMaterials);
	}
	
	public void approveRawMaterial(String rId, String siteId, String materialModel, String materialName)
	{
		db.approveRawMaterials(rId,siteId,materialModel,materialName);
	}
	
	public void approveSubcontracts(String pId)
	{
		db.approveSubcontracts(pId);
	}
	
	public String[][] viewSubcontracts()
	{
		String subcontracts[][] = db.viewSubcontracts();
		return(subcontracts);
	}

}
