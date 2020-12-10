package actorClasses;

import database.*;

public class Builder {
	public String builderId;
	public String fname;
	public String lname;
	protected String street;
	protected String city;
	protected String state;
	protected int zip;
	public char gender;
	private double salary;
	public String email;
	DBAccess db = new DBAccess();

	Builder()
	{
		builderId="";
	}

	public double getSalary(String bId)
	{
		return db.getBuilderSalary(bId);
	}

	public String getAddress()
	{
		return (street+", "+city+", "+state+", "+zip);
	}

	public void updateProjectStatus(String bId)
	{

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Builder b=new Builder();
		b.getSalary("B1");
	}

}
