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
	public double serviceRating;
	DBAccess db = new DBAccess();
	
	Retailer()
	{
		retailerId="";
	}
	
	
	public String getAddress()
	{
		return (street+", "+city+", "+state+", "+zip);
	}

	void retailerRegistration(String n,String st,String c,String s,int z,String mail)
	{
		db.addRetailer(n,st,c,s,z,mail);
	}
	
	void addMaterialDetails(String m_name,String model,String type,String manufacturer)
	{
		db.addRetailerMaterials(retailerId,m_name,model,type,manufacturer);
	}
	
	void viewOrders()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Retailer r=new Retailer();
		r.retailerRegistration("Nagesh", "MG-Road", "Vijayawada", "Andhra Pradesh", 521165, "nagesh@gmailcom");
	}

}
