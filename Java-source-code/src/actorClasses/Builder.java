package actorClasses;

import database.*;


public class Builder {
	public String id;
	public String name;
	protected String address;
	public char gender;
	private double salary;
	public String email;
	DBAccessBuilder db = new DBAccessBuilder();

	public Builder()
	{
		id="";
	}

	public Builder(String id)
	{
		String Details[] = db.getBuilderDetails(id);
		this.id = id;
		this.salary = db.getBuilderSalary(id);
		this.name = Details[0];
		this.email = Details[1];
		this.address = Details[2];
		this.gender = Details[3].charAt(0);
		
	}
	
	public double getSalary()
	{
		return (salary);
	}

	public String getAddress()
	{
		return (address);
	}

	public void updateProjectStatus(String PNumber, String status)
	{
		db.updateProjectStatusBuilder(PNumber, status, id);
	}
	
	public String[][] getProjects()
	{
		String Projects[][] = db.getBuilderProjects(this.id);
		return(Projects);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Builder b=new Builder("B1");
	
	}

}
