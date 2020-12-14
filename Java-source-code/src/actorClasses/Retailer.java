package actorClasses;

import database.*;
public class Retailer {
	public String retailerId;
	public String name;
	protected String street;
	protected String city;
	protected String state;
	protected int zip; 
	public String email;
	private String password;
	public double serviceRating;
	DBAccess db = new DBAccess();
	
	public Retailer()
	{
		retailerId="";
	}
	
	public Retailer(String Id)
	{
		retailerId=Id;
	}
	
	
	public String getAddress()
	{
		return (street+", "+city+", "+state+", "+zip);
	}

	public String retailerRegistration(String n,String st,String c,String s,int z,String password,String mail)
	{
		return db.retailerRegistration(n,st,c,s,z,password,mail);
	}
	
	public void addMaterialDetails(String m_name,String model,String type,String manufacturer)
	{
		db.addRetailerMaterials(retailerId,m_name,model,type,manufacturer);
	}
	
	public String[][] viewOrders(String rId)
	{
		return db.viewRetailerOrders(rId);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Retailer r=new Retailer();
		r.retailerRegistration("Nagesh", "MG-Road", "Vijayawada", "Andhra Pradesh", 521165,"nn", "nagesh@gmailcom");
	}

}
