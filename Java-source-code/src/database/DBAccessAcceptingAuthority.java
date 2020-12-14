package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccessAcceptingAuthority {

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
			PreparedStatement st = c.prepareStatement("SELECT site_id,material_model,material_name FROM Supplies WHERE retailer_id=null;");
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
			PreparedStatement st=c.prepareStatement("UPDATE Supplies SET retailer_id = ? WHERE site_Id = ? AND material_model = ? AND material_name = ?;");
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
