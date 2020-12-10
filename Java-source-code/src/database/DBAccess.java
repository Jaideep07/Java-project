package database;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBAccess {

	
	Connection connect()
	{
		Connection c=null;
		try {
		
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBMSproject","postgres","postgres");
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

	public void addRetailer(String n, String street,String city,String state,int zip,String mail) {
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

	public double getBuilderSalary(String bId) {
		// TODO Auto-generated method stub
		Connection c=connect();
		double sal=0;
		try
		{
			PreparedStatement s=c.prepareStatement("select salary from Builder where id=?;");
			s.setString(1, bId);
			ResultSet rs=s.executeQuery();
	
			while(rs.next())
			{
				sal=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		System.out.println(sal); // gui part
		return sal;
	}

	public void viewRetailerOrders(String rId) {
		// TODO Auto-generated method stub
		Connection c=connect();
		String data[][]=new String[10][5];
		int i=0;
		try
		{
			PreparedStatement s=c.prepareStatement("select site_id,material_model,material_name from Supplies where retailer_id=?;");
			s.setString(1, rId);
			ResultSet rs=s.executeQuery();
			String s_id;
			String model;
			String name;
			while(rs.next())
			{
				s_id=rs.getString(1);
				model=rs.getString(2);
				name=rs.getString(3);
				data[i][0]=s_id;
				data[i][1]=model;
				data[i][2]=name;
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

	

}
