package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccessRetailer {
	
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
        System.out.println(num);
        if(num==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

 


    public String retailerRegistration(String n, String street,String city,String state,int zip,String password,String mail) {
        Connection c=connect();
        String ans="Registered";
        try
        {
            if(!(checkExistingRetailer(n,street,city,state,zip,mail)))
            {
                PreparedStatement s=c.prepareStatement("select count(*) from Retailer;");
                ResultSet r=s.executeQuery();
                int num = 0;
                while(r.next())
                {
                    num=r.getInt(1);
                }
                String id="R"+(num+1);
                PreparedStatement st=c.prepareStatement("insert into Retailer values(?,?,?,?,?,?,?,crypt(?,gen_salt('bf',4)));");
                st.setString(1, id);
                st.setString(2, n);
                st.setString(3, street);
                st.setString(4, city);
                st.setString(5, state);
                st.setInt(6, zip);
                st.setString(7, mail);
                st.setString(8, password);
                st.executeUpdate();
                ans="Registered Successfully and your id is "+ id;
            }
            else
            {
                ans="You are already Registered";
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        finally
        {
            return ans;
        }
        
    }

	
	public String[][] viewRetailerOrders(String rId) {
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
		return orderDetail;

	}

}
