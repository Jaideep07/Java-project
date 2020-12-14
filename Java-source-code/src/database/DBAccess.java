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


	public void updateProjectStatusBuilder(String Pnum, String status,String Bid)
	{
		Connection c=connect();
		try
		{
			PreparedStatement st=c.prepareStatement("UPDATE Works_on SET completion_status=? where builder_id=? AND project_no=?;");
			st.setString(1, status+"%");
			st.setString(2, Bid);
			st.setString(3, Pnum);
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

	public void allocateProject(String Pname, String assignedDate, String startDate, String endDate, String tenure,String mId, String siteId)
	{
		Connection c=connect();

		try
		{
			String groupNo="";
			PreparedStatement st1 = c.prepareStatement("SELECT number FROM Groups WHERE manager_id = ?");
			st1.setString(1,mId);
			ResultSet re = st1.executeQuery();
			while(re.next())
			{
				groupNo = re.getString("number");
			}
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("SELECT count(*) FROM Project");
			int l=0;
			while(r.next())
			{
				l=r.getInt(1)+1;
			}

			String pNo = "P"+String.valueOf(l);

			PreparedStatement st2 = c.prepareStatement("INSERT INTO Project VALUES(?,?,?,?,?,?,?,?);");
			st2.setString(1, pNo);
			st2.setString(2, Pname);
			st2.setDate(3, Date.valueOf(assignedDate));
			st2.setDate(4, Date.valueOf(startDate));
			st2.setDate(5, Date.valueOf(endDate));
			st2.setInt(6, Integer.parseInt(tenure));
			st2.setString(7, groupNo);
			st2.setString(8, "0%");
			st2.executeUpdate();

			PreparedStatement st = c.prepareStatement("UPDATE Site SET project_no=? WHERE id=? AND project_no=null AND verification_status='verified' ;");
			st.setString(1, pNo);
			st.setString(2, siteId);
			st.executeUpdate();

			st.close();
			s.close();
			st2.close();
			c.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}


	}

	public String[][] viewUnallocatedSites()
	{
		Connection c=connect();
		String Sites[][] = new String[10][6];
		int i=0;
		try
		{
			Statement st=c.createStatement();
			ResultSet re = st.executeQuery("SELECT id,city,state,site_area_sqyards,site_terrain,soil_type FROM Project,Works_on,Site WHERE verification_status='verified' AND Site.project_no=null;");
			while(re.next())
			{
				Sites[i][0] = re.getString(1);
				Sites[i][1] = re.getString(2);
				Sites[i][2] = re.getString(3);
				Sites[i][3] = re.getString(4);
				Sites[i][4] = re.getString(5);
				Sites[i][5] = re.getString(6);
				i++;
			}
			st.close();
			c.close();
			return(Sites);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(Sites);
		}


	}

	public void assignProject(String pId, String bId)
	{
		Connection c=connect();
		try
		{
			PreparedStatement st=c.prepareStatement("INSERT INTO Works_on VALUES(?,?,5,'0%');");
			st.setString(1, bId);
			st.setString(2, pId);
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

	public String[][] viewProjectsForAssigning(String mId)
	{

			Connection c=connect();
			String Projects[][] = new String[10][7];

			try
			{
				String groupNo="";
				PreparedStatement st1 = c.prepareStatement("SELECT number FROM Groups WHERE manager_id = ?");
				st1.setString(1,mId);
				ResultSet re = st1.executeQuery();
				while(re.next())
				{
					groupNo = re.getString("number");
				}
				PreparedStatement st = c.prepareStatement("SELECT DISTINCT number,TO_CHAR(Project.start_date,'DD-MM-YYYY'),TO_CHAR(Project.end_date,'DD-MM-YYYY'),Project.completion_status,Site.city,Site.state,COUNT(Works_on.builder_id) FROM Site,Project,Works_On WHERE Site.project_no = Project.number AND Works_on.project_no = Project.number AND verification_status='verified' AND Project.group_number = ? GROUP BY(project.number,Site.city,Site.state);");
				st.setString(1,groupNo);
				ResultSet r = st.executeQuery();
				int i=0;
				while(r.next())
				{
					Projects[i][0] = r.getString(1);
					Projects[i][1] = r.getString(2);
					Projects[i][2] = r.getString(3);
					Projects[i][3] = r.getString(4);
					Projects[i][4] = r.getString(5);
					Projects[i][5] = r.getString(6);
					Projects[i][6] = r.getString(7);
					i++;
				}
				st.close();
				st1.close();
				c.close();
				return(Projects);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
				System.exit(0);
				return(Projects);
			}


		}

	public String[][] projectStatusManager(String pId, String mId)
	{
		Connection c=connect();
		String builders[][] = new String[15][3];
		try
		{
			String groupNo="";
			PreparedStatement st1 = c.prepareStatement("SELECT number FROM Groups WHERE manager_id = ?");
			st1.setString(1,mId);
			ResultSet re = st1.executeQuery();
			while(re.next())
			{
				groupNo = re.getString("number");
			}

			PreparedStatement st = c.prepareStatement("SELECT Works_on.builder_id, Works_on.project_no,Works_on.completion_status FROM Works_on,Works_in WHERE Works_on.builder_id = Works_in.builder_id AND Works_in.group_number = ?;");
			st.setString(1, groupNo);
			ResultSet r = st.executeQuery();
			int i=0;
			while(r.next())
			{
				builders[i][0] = r.getString(1);
				builders[i][1] = r.getString(2);
				builders[i][2] = r.getString(3);
				i++;
			}
			return(builders);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(builders);
		}
	}

	public void updateProjectStatusManager(String pId, String status)
	{
		Connection c=connect();
		try
		{
			PreparedStatement st=c.prepareStatement("UPDATE Project SET completion_status=? where number=?;");
			st.setString(1, status+"%");
			st.setString(2, pId);
			System.out.println(pId);
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

	public String[][] builderPerformanceTrackingManager(String mId)
	{
		Connection c=connect();
		String performance[][] = new String[15][3];
		try
		{
			String groupNo="";
			PreparedStatement st1 = c.prepareStatement("SELECT number FROM Groups WHERE manager_id = ?");
			st1.setString(1,mId);
			ResultSet re = st1.executeQuery();
			while(re.next())
			{
				groupNo = re.getString("number");
			}

			PreparedStatement st = c.prepareStatement("SELECT Works_in.builder_id, COUNT(project_no),SUM(hours) FROM Works_on,Works_in WHERE Works_in.builder_id=Works_on.builder_id AND Works_in.group_number=? GROUP BY(Works_in.builder_id) ORDER BY COUNT(project_no) DESC, SUM(hours) DESC;");
			st.setString(1, groupNo);
			ResultSet r = st.executeQuery();
			int i=0;
			while(r.next())
			{
				performance[i][0] = r.getString(1);
				performance[i][1] = r.getString(2);
				performance[i][2] = r.getString(3);
				i++;
			}
			return(performance);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(performance);
		}

	}
	
	public void giveSalaryBonus(String bId, double percent)
	{
		Connection c=connect();
		try
		{
			PreparedStatement st=c.prepareStatement("UPDATE Builder SET salary=salary*? where id=?;");
			st.setDouble(1, percent);
			st.setString(2, bId);
			
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
	
	public String[][] builderPerformanceTrackingSupervisor(String sId)
	{
		Connection c=connect();
		String performance[][] = new String[15][3];
		try
		{
			PreparedStatement st = c.prepareStatement("SELECT Works_on.builder_id, COUNT(project_no),SUM(hours) FROM Works_on,Builder A, Builder B WHERE A.supervisor_id = B.id AND A.id = Works_on.builder_id AND B.id =?  GROUP BY(Works_on.builder_id) ORDER BY COUNT(project_no) DESC, SUM(hours) DESC;");
			st.setString(1, sId);
			ResultSet r = st.executeQuery();
			int i=0;
			while(r.next())
			{
				performance[i][0] = r.getString(1);
				performance[i][1] = r.getString(2);
				performance[i][2] = r.getString(3);
				i++;
			}
			return(performance);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(performance);
		}

	}
	
	public void allocateRawMaterials(String siteId, String materialName, String materialModel)
	{
		Connection c=connect();
		try
		{
			PreparedStatement st1=c.prepareStatement("INSERT INTO Raw_materials VALUES(?,?,?,'clay',500,200,100);");
			st1.setString(1, siteId);
			st1.setString(2, materialModel);
			st1.setString(3, materialName);
			st1.executeUpdate();
			PreparedStatement st=c.prepareStatement("INSERT INTO supplies VALUES(null,?,?,?);");
			st.setString(1, siteId);
			st.setString(2, materialModel);
			st.setString(3, materialName);
			st.executeUpdate();
			st1.close();
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
	
	public String[][] projectStatusSupervisor(String pId)
	{
		Connection c=connect();
		String performance[][] = new String[15][3];
		try
		{
			PreparedStatement st = c.prepareStatement("SELECT Works_on.builder_id, project_no, completion_status FROM Works_on,Builder A, Builder B WHERE A.supervisor_id = B.id AND A.id = Works_on.builder_id AND B.id =?;");
			st.setString(1, pId);
			ResultSet r = st.executeQuery();
			int i=0;
			while(r.next())
			{
				performance[i][0] = r.getString(1);
				performance[i][1] = r.getString(2);
				performance[i][2] = r.getString(3);
				i++;
			}
			return(performance);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(performance);
		}
		
	}
	
	public void allocateSubcontracts(String pNo, String contractName, String companyName, long contactNumber)
	{
		Connection c=connect();
		try
		{
			PreparedStatement st=c.prepareStatement("INSERT INTO Subcontracts VALUES(?,?,?,?,?);");
			st.setString(1, pNo);
			st.setString(2, contractName);
			st.setString(3, companyName);
			st.setLong(4, contactNumber);
			st.setString(5, "pending");
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
	
	public String[][] getRawMaterials()
	{
		Connection c=connect();
		String rawMaterials[][] = new String[18][4];
		try
		{
			PreparedStatement st = c.prepareStatement("SELECT DISTINCT material_name ,material_model,material_type ,manufacturer FROM Retailer_Material;");
			ResultSet r = st.executeQuery();
			int i=0;
			while(r.next())
			{
				rawMaterials[i][0] = r.getString(1);
				rawMaterials[i][1] = r.getString(2);
				rawMaterials[i][2] = r.getString(3);
				rawMaterials[i][3] = r.getString(4);
				i++;
			}
			return(rawMaterials);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(rawMaterials);
		}
		
	}
	
	public String[][] getRetailers()
	{
		Connection c=connect();
		String retailers[][] = new String[18][4];
		try
		{
			PreparedStatement st = c.prepareStatement("SELECT id,name,state,service_rating FROM Retailer;");
			ResultSet r = st.executeQuery();
			int i=0;
			while(r.next())
			{
				retailers[i][0] = r.getString(1);
				retailers[i][1] = r.getString(2);
				retailers[i][2] = r.getString(3);
				retailers[i][3] = r.getString(4);
				i++;
			}
			return(retailers);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(retailers);
		}
		
	}
	
	public String[][] getUnallocatedRawMaterials()
	{
		Connection c=connect();
		String rawMaterials[][] = new String[18][4];
		try
		{
			PreparedStatement st = c.prepareStatement("SELECT site_id,material_model,material_name FROM Supplies WHERE retialer_id=null;");
			ResultSet r = st.executeQuery();
			int i=0;
			while(r.next())
			{
				rawMaterials[i][0] = r.getString(1);
				rawMaterials[i][1] = r.getString(2);
				rawMaterials[i][2] = r.getString(3);
				i++;
			}
			return(rawMaterials);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(rawMaterials);
		}
		
	}
	
	public void approveRawMaterials(String rId, String siteId, String materialModel, String materialName)
	{
		Connection c=connect();
		try
		{
			PreparedStatement st=c.prepareStatement("UPDATE Supplies SET rId = ? WHERE siteId = ?, material_model = ?, material_name = ?;");
			st.setString(1, rId);
			st.setString(2, siteId);
			st.setString(3, materialModel);
			st.setString(4, materialName);
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
	
	public void approveSubcontracts(String pId)
	{
		Connection c=connect();
		try
		{
			PreparedStatement st=c.prepareStatement("UPDATE Subcontracts SET verification_status = 'verified' WHERE verification_status='pending' AND project_number = ?;");
			st.setString(1, pId);
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
	
	public String[][] viewSubcontracts()
	{
		Connection c=connect();
		String subcontracts[][] = new String[10][5];
		try
		{
			PreparedStatement st = c.prepareStatement("SELECT * FROM Subcontracts WHERE verification_status='pending';");
			ResultSet r = st.executeQuery();
			int i=0;
			while(r.next())
			{
				subcontracts[i][0] = r.getString(1);
				subcontracts[i][1] = r.getString(2);
				subcontracts[i][2] = r.getString(3);
				subcontracts[i][3] = r.getString(4);
				subcontracts[i][4] = r.getString(5);
				i++;
			}
			return(subcontracts);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
			return(subcontracts);
		}
		
	}
	
}
