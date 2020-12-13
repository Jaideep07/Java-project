package actorClasses;

import database.*;
import java.util.Scanner;

public class Client {

	public String clientId;
	protected String name;
	protected String[] email;
	protected long[] phoneNo;
	protected String address;
	private String password;
	DBAccess db = new DBAccess();
	
	Client()
	{
		clientId="";
	}
	
	public Client(String cId)
	{
		clientId = cId;
		address = db.searchClientAddress(clientId);
		email = db.searchClientEmail(clientId);
		name = db.searchClientName(clientId);
		phoneNo = db.searchClientPhoneNo(clientId);
	}
	
	public String getName()
	{
		return(name);
	}
	
	public String getAddress()
	{
		return(address);
	}
	
	public String getPassword()
	{
		return(password);
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
	public String[][] trackProjectStatus()
	{
		String Status[][] = db.getProjectStatus(clientId);
		return(Status);
	}
	
	public void enterSiteInfo(String street, String city, String state, String zipCode,String siteArea,String siteTerrain, String soilType, String clientId, String dateOfPurchase, String ownershipType)
	{
		db.enterSiteInfo(street, city, state, zipCode, siteArea, siteTerrain, soilType, clientId, dateOfPurchase, ownershipType);
		
	}
	
	public void clientRegistration()
	{
		clientId = db.clientRegistration(name.split(" ",1)[0],name.split(" ",1)[1],address.split(", ",4)[0],address.split(", ",4)[1],address.split(", ",4)[2],address.split(", ",4)[3],password);
		
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String cId = in.next();
		Client c = new Client(cId);
		System.out.println(c.getName());
		System.out.println(c.getAddress());
		c.enterSiteInfo("afd", "adfa", "adfadf", "201310", "2322", "sddf", "sdfsdf", "C1", "2000-09-12", "joint");
		in.close();
		
	}

}

