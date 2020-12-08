package driver;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		UserLogin ul = new UserLogin();
		
		//String type = in.next();
		String usrname = in.next();
		String password = in.next();
		
		while(true)
		{
			int ch = in.nextInt(); // ch should be taken from the drop down menu
			switch(ch)
			{
				case(1): ul.clientLogin(usrname,password);
						 break;
				case(2): ul.retailerLogin(usrname, password);
						 break;
				case(3): ul.builderLogin(usrname,password);
						 break;
				case(4): ul.managerLogin(usrname,password);
						 break;
				case(5): ul.supervisorLogin(usrname,password);
						 break;
			}
		
		}
		
		
		

	}

}
