package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccessManager {
	
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


}
