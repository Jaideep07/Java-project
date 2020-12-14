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
	DBAccessClient db = new DBAccessClient();

	public Client()
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

	public void enterSiteInfo(String street, String city, String state, String zipCode,String siteArea,String siteTerrain, String soilType, String dateOfPurchase, String ownershipType)
	{
		db.enterSiteInfo(street, city, state, zipCode, siteArea, siteTerrain, soilType, clientId, dateOfPurchase, ownershipType);

	}

	public String clientRegistration(String fname, String lname, String street, String city,String state,String zipcode, String password, String email[], long phoneNo[])
	{
		clientId = db.clientRegistration(fname,lname,street,city,state,zipcode,password,email,phoneNo);
		return clientId;
	}

	public static void main(String[] args)
	{
		//Scanner in = new Scanner(System.in);
		//String cId = in.next();
		Client c = new Client();
		//System.out.println(c.getName());
		//System.out.println(c.getAddress());
		String email[]= {"c.v.awe","sdsdf"};
		long phoneNo[] = {122323243,34221212 };
		c.clientRegistration("afd", "adfa", "adfadf", "sgkn", "sdgks", "201310", "sdfsdf", email,phoneNo);
		//in.close();

	}

}
