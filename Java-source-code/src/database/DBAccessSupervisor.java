package database;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBAccessSupervisor {
	
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
	
	public String[][] projectStatusSupervisor(String bId)
	{
		Connection c=connect();
		String performance[][] = new String[15][3];
		try
		{
			PreparedStatement st = c.prepareStatement("SELECT Works_on.builder_id, project_no, completion_status FROM Works_on,Builder A, Builder B WHERE A.supervisor_id = B.id AND A.id = Works_on.builder_id AND B.id =?;");
			st.setString(1, bId);
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
	
	 public void allocateRawMaterials(String siteId, String materialName, String materialModel,int materialQty, int reorderLevel, int avilableQty)
	    {
	        Connection c=connect();
	        try
	        {
	            PreparedStatement st1=c.prepareStatement("INSERT INTO Raw_materials VALUES(?,?,?,'clay',500,200,100);");
	            st1.setString(1, siteId);
	            st1.setString(2, materialModel);
	            st1.setString(3, materialName);
	            st1.setInt(4, materialQty);
	            st1.setInt(5, reorderLevel);
	            st1.setInt(6, avilableQty);
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

}
