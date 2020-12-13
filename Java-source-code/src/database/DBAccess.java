package database;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Date;  

public class DBAccess {

	
	Connection connect()
	{
		Connection c=null;
		try {
		
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBMSproject","postgres","Wildwest");
		}
		catch(SQLException e1)
		{
			System.out.println(e1.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		return(c);
	}
	
	public int searchClient(String usrName, String password)
	{
		Connection c = connect();
		int i=0;
		try {
			PreparedStatement st = c.prepareStatement("SELECT id FROM Client WHERE id = ? AND passcode = crypt( ? ,passcode) ;");
			st.setString(1,usrName);
			st.setString(2,password);
			ResultSet re = st.executeQuery();
			
			
			while(re.next())
			{
				if(usrName.equals(re.getString("id")))
				{
					System.out.println(re.getString("id"));
					i++;
				}
			}
		return(i);
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(-1);
		}
		
	}
	
	public int searchRetailer(String usrName, String password)
	{
		Connection c = connect();
		int i=0;
		try {
			PreparedStatement st = c.prepareStatement("SELECT id FROM Retailer WHERE id = ? AND passcode = crypt( ? ,passcode) ;");
			st.setString(1,usrName);
			st.setString(2,password);
			ResultSet re = st.executeQuery();
			
			
			while(re.next())
			{
				if(usrName.equals(re.getString("id")))
				{
					System.out.println(re.getString("id"));
					i++;
				}
			}
		return(i);
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(-1);
		}
		
	}
	
	public int searchBuilder(String usrName, String password)
	{
		Connection c = connect();
		int i=0;
		try {
			PreparedStatement st = c.prepareStatement("SELECT id FROM Builder WHERE id = ? AND passcode = crypt( ? ,passcode) ;");
			st.setString(1,usrName);
			st.setString(2,password);
			ResultSet re = st.executeQuery();
			
			
			while(re.next())
			{
				if(usrName.equals(re.getString("id")))
				{
					System.out.println(re.getString("id"));
					i++;
				}
			}
		return(i);
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(-1);
		}
		
	}
	
	public int searchManager(String usrName, String password)
	{
		Connection c = connect();
		int i=0;
		try {
			PreparedStatement st = c.prepareStatement(" SELECT id FROM Builder,Groups WHERE passcode=crypt(?,passcode) AND Groups.manager_id=? AND id = ?;");
			st.setString(2,usrName);
			st.setString(3,usrName);
			st.setString(1,password);
			ResultSet re = st.executeQuery();
			
			
			while(re.next())
			{
				if(usrName.equals(re.getString("id")))
				{
					System.out.println(re.getString("id"));
					i++;
				}
			}
		return(i);
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(-1);
		}
		
	}
	
	public int searchSupervisor(String usrName, String password)
	{
		Connection c = connect();
		int i=0;
		try {
			PreparedStatement st = c.prepareStatement("SELECT distinct A.id FROM Builder A, Builder B WHERE A.passcode=crypt(?,A.passcode) AND A.id=B.supervisor_id AND A.id = ?;");
			st.setString(2,usrName);
			st.setString(1,password);
			ResultSet re = st.executeQuery();
			
			
			while(re.next())
			{
				if(usrName.equals(re.getString("id")))
				{
					System.out.println(re.getString("id"));
					i++;
				}
			}
		return(i);
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(-1);
		}
		
	}
	
	public String searchClientName(String clientId)
	{
		Connection c = connect();
		String name="";
		try {
			PreparedStatement st = c.prepareStatement("SELECT fname,lname FROM Client WHERE id = ? ;");
			st.setString(1,clientId);
			ResultSet re = st.executeQuery();
			while(re.next())
			{
				name = re.getString("fname")+ " " + re.getString("lname");
			}
			return(name);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(name);
		}
	}
	
	public String[] searchClientEmail(String clientId)
	{
		Connection c = connect();
		String Email[] = new String[10];
		try {
			PreparedStatement st = c.prepareStatement("SELECT email FROM Client_Emails WHERE id = ? ;");
			st.setString(1,clientId);
			ResultSet re = st.executeQuery();
			
			int i=0;
			while(re.next())
			{
				Email[i] = re.getString("email");
				i++;
			}
			
			return(Email);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(Email);
		}
	}
	
	public long[] searchClientPhoneNo(String clientId)
	{
		Connection c = connect();
		long PhoneNo[] = new long[10];
		try {
			
			PreparedStatement st = c.prepareStatement("SELECT phone FROM Client_phone_numbers WHERE id = ? ;");
			st.setString(1,clientId);
			ResultSet re = st.executeQuery();
			
			int i=0;
			while(re.next())
			{
				PhoneNo[i] = re.getLong("phone");
				i++;
			}
			
			return(PhoneNo);
			
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(PhoneNo);
		}
	}
	
	public String searchClientAddress(String clientId)
	{
		Connection c = connect();
		String address = new String();
		try {
			
			PreparedStatement st = c.prepareStatement("SELECT street_name,city,state,zip_code FROM Client WHERE id = ? ;");
			st.setString(1,clientId);
			ResultSet re = st.executeQuery();
			
			while(re.next())
			{
				address = address + re.getString("street_name")+", "+ re.getString("city")+", "+ re.getString("state")+", "+ re.getString("zip_code");
			}
			
			return(address);
			
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(address);
		}
	}

	public void addRetailerMaterials(String id, String name, String model, String type, String mnf) {
		Connection c=connect();
		try
		{
			PreparedStatement st=c.prepareStatement("insert into Retailer_material values(?,?,?,?,?);");
			st.setString(1, id);
			st.setString(2, name);
			st.setString(3, model);
			st.setString(4,type);
			st.setString(5,mnf);
			st.executeQuery();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		
	}
	
	
	public boolean checkExistingRetailer(String n, String street,String city,String state,int zip,String mail)
	{
		Connection c = connect();
		int num=0;
		try
		{
			PreparedStatement st=c.prepareStatement("select count(id) from Retailer where name=? and Street_name=? and city=? and state=? and zip_code=? and email=? ;");
			st.setString(1, n);
			st.setString(2, street);
			st.setString(3, city);
			st.setString(4, state);
			st.setInt(5, zip);
			st.setString(6, mail);
			ResultSet rs=st.executeQuery();
			
			while(rs.next())
			{
				num=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		if(num==0)
		{
			return false; 
		}
		else
		{
			return true;
		}
	}

	public void retailerRegistration(String n, String street,String city,String state,int zip,String mail) {
		Connection c=connect();
		try
		{
			if(checkExistingRetailer(n,street,city,state,zip,mail))
			{
				System.out.println("Reatiler already exist"); // gui part
			}
			else
			{
				PreparedStatement s=c.prepareStatement("select count(*) from Retailer;");
				ResultSet r=s.executeQuery();
				int num = 0;
				while(r.next())
				{
					num=r.getInt(1);
				}
				String id="R"+(num+1);
				PreparedStatement st=c.prepareStatement("insert into Retailer values(?,?,?,?,?,?,?);");
				st.setString(1, id);
				st.setString(2, n);
				st.setString(3, street);
				st.setString(4, city);
				st.setString(5, state);
				st.setInt(6, zip);
				st.setString(7, mail);
				st.executeQuery();
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		
	}


	public void viewRetailerOrders(String rId) {
		// TODO Auto-generated method stub
		Connection c=connect();
		String orderDetail[][]=new String[10][5];
		int i=0;
		try
		{
			PreparedStatement s=c.prepareStatement("select site_id,material_model,material_name from Supplies where retailer_id=?;");
			s.setString(1, rId);
			ResultSet rs=s.executeQuery();

			while(rs.next())
			{
				orderDetail[i][0]=rs.getString(1);
				orderDetail[i][1]=rs.getString(2);
				orderDetail[i][2]=rs.getString(3);
				i++;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		//return data for gui part
		
	}
	
	public String[] getBuilderDetails(String Bid)
	{
		Connection c=connect();
		String Details[]=new String[4];
		try
		{
			PreparedStatement s=c.prepareStatement("select fname,lname,email,street_name,city,state,zip_code,gender from Builder where id=?;");
			s.setString(1, Bid);
			ResultSet rs=s.executeQuery();

			while(rs.next())
			{
				Details[0]=rs.getString("fname")+' '+rs.getString("lname");
				Details[1]=rs.getString("email");
				Details[2] = rs.getString("street_name")+ ", " +rs.getString("city")+ ", "
						+rs.getString("state")+ ", " + String.valueOf(rs.getInt("zip_code"));
				Details[3] = rs.getString("gender");
			
			}
			return(Details);
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(Details);
		}
	}
	
	public double getBuilderSalary(String Bid)
	{
		Connection c=connect();
		double salary = 0;
		try
		{
			PreparedStatement s=c.prepareStatement("select salary from Builder where id=?;");
			s.setString(1, Bid);
			ResultSet rs=s.executeQuery();

			while(rs.next())
			{
				salary=rs.getDouble("salary");
			}
			return(salary);
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(salary);
		}
		
	}
	
	public void updateProjectStatus(String Pnum, double status,String Bid)
	{
		Connection c=connect();
		try
		{
			PreparedStatement st=c.prepareStatement("UPDATE Works_on SET completion_status=? where builder_id=? AND project_no=?;");
			st.setString(1, String.valueOf(status));
			st.setString(2, Bid);
			st.setString(3, Pnum);
			st.executeQuery();
			c.commit();
			st.close();
			c.close();
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		
	}
	
	public String[][] getProjectStatus(String Cid)
	{
		
		Connection c=connect();
		String Status[][] = new String[10][6]; 
		int i=0;
		try
		{
			PreparedStatement st=c.prepareStatement("SELECT Site.id,TO_CHAR(Project.start_date,'DD-MM-YYYY'),TO_CHAR(Project.end_date,'DD-MM-YYY'),Project.completion_status,Site.city,Site.state FROM Site,Project,Client WHERE Site.project_no = Project.number AND Client.id=Site.client_id AND Client.id=?;");
			st.setString(1, Cid);
			ResultSet re = st.executeQuery();
			while(re.next())
			{
				Status[i][0] = re.getString(1);
				Status[i][1] = re.getString(2);
				Status[i][2] = re.getString(3);
				Status[i][3] = re.getString(4);
				Status[i][4] = re.getString(5);
				Status[i][5] = re.getString(6);
				i++;
			}
			st.close();
			c.close();
			return(Status);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(Status);
		}
		
	}
	
	public void enterSiteInfo(String street, String city, String state, String zipCode,String siteArea,String siteTerrain, String soilType,String clientId, String dateOfPurchase, String ownershipType)
	{
		Connection c=connect();
		try
		{
			PreparedStatement st=c.prepareStatement("INSERT INTO Site VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("SELECT count(*) FROM Site");
			int l=0;
			while(r.next())
			{
				l = r.getInt(1);
			}
			st.setString(1, "S"+String.valueOf(l+1));
			st.setString(2, street);
			st.setString(3, city);
			st.setString(4, state);
			st.setInt(5, Integer.parseInt(zipCode));
			st.setInt(6, Integer.parseInt(siteArea));
			st.setString(7, siteTerrain);
			st.setString(8, soilType);
			st.setString(9, null);
			st.setString(10, clientId);
			st.setDate(11, Date.valueOf(dateOfPurchase));
			st.setString(12, ownershipType);
			st.setString(13, "pending");
			
			st.executeUpdate();
			st.close();
			c.close();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
			
	}
	
	public String clientRegistration(String fname, String lname, String street, String city,String state,String zipcode, String password)
	{
		Connection c=connect();
		String cId = "";
		try
		{
			PreparedStatement st=c.prepareStatement("INSERT INTO Client VALUES(?,?,?,?,?,?,?);");
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("SELECT count(*) FROM Client");
			int l=0;
			while(r.next())
			{
				l = r.getInt(1);
			}
			cId = "C"+String.valueOf(l+1);
			st.setString(1, cId);
			st.setString(2, fname);
			st.setString(3, lname);
			st.setString(4, street);
			st.setString(5, city);
			st.setString(6, state);
			st.setInt(7, Integer.parseInt(password));

			
			st.executeUpdate();
			st.close();
			c.close();
			return(cId);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(cId);
		}
		
		
		
	}
	
	public String[][] getBuilderProjects(String Bid)
	{

		Connection c=connect();
		String Working_on[][] = new String[10][6]; 
		int i=0;
		try
		{
			PreparedStatement st=c.prepareStatement("SELECT Project.number, Project.name, Site.street_name,Site.city,Site.state,CAST(Site.zip_code AS varchar) FROM Project,Works_on,Site WHERE Project.number=Works_on.project_no AND Works_on.project_no=Site.project_no AND Works_on.Builder_Id = ?;");
			st.setString(1, Bid);
			ResultSet re = st.executeQuery();
			while(re.next())
			{
				Working_on[i][0] = re.getString(1);
				Working_on[i][1] = re.getString(2);
				Working_on[i][2] = re.getString(3);
				Working_on[i][3] = re.getString(4);
				Working_on[i][4] = re.getString(5);
				Working_on[i][5] = re.getString(6);
				i++;
			}
			st.close();
			c.close();
			return(Working_on);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(Working_on);
		}
		
	}	

}
