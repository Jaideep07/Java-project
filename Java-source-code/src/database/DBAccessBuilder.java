package database;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Date;

public class DBAccessBuilder {
	
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
