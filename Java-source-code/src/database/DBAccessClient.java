package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccessClient {
	
	Connection connect()
	{
		Connection c=null;
		try {

		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBMSproject","postgres","cv");
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

	
	public String[][] getProjectStatus(String Cid)
	{

		Connection c=connect();
		String Status[][] = new String[10][7];
		int i=0;
		try
		{
			PreparedStatement st=c.prepareStatement("SELECT Site.id,verification_status,TO_CHAR(Project.start_date,'DD-MM-YYYY'),TO_CHAR(Project.end_date,'DD-MM-YYY'),Project.completion_status,Site.city,Site.state FROM Site,Project,Client WHERE Site.project_no = Project.number AND Client.id=Site.client_id AND Client.id=?;");
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
				Status[i][6] = re.getString(7);
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

	public String clientRegistration(String fname, String lname, String street, String city,String state,String zipcode, String password, String email[], long phoneNo[])
	{
		Connection c=connect();
		String cId = "";
		try
		{
			PreparedStatement st=c.prepareStatement("INSERT INTO Client VALUES(?,?,?,?,?,?,?,crypt(?,gen_salt('bf',4)));");
			PreparedStatement st1 = c.prepareStatement("INSERT INTO Client_Emails VALUES(?,?);");
			PreparedStatement st2 = c.prepareStatement("INSERT INTO Client_phone_numbers VALUES(?,?);");
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
			st.setInt(7, Integer.parseInt(zipcode));
			st.setString(8, password);
			st.executeUpdate();
			for (String eml : email)
			{
				st1.setString(1,cId);
				st1.setString(2,eml);
				st1.executeUpdate();
			}
			for (long pNo : phoneNo)
			{
				st2.setString(1,cId);
				st2.setLong(2,pNo);
				st2.executeUpdate();
			}



			st.close();
			st1.close();
			st2.close();
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

}
