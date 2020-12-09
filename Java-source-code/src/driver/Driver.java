package driver;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

class loginUI{
	loginUI(){
		JFrame loginWindow = new JFrame("User Login");
		ImageIcon img = new ImageIcon("src/Construction.jpg");
		JLabel background = new JLabel("",img,JLabel.CENTER);
		
		JPanel log = new JPanel();
		log.setBounds(310,190,400,350);
		log.setBackground(new Color(102, 179, 255));
		loginWindow.add(log);
		
		JLabel CMS = new JLabel("Construction Company Managment System");
		CMS.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		CMS.setForeground(Color.DARK_GRAY);
		log.add(CMS);
		
		JLabel WEL = new JLabel("Welcome to login page!");
		WEL.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		WEL.setForeground(Color.DARK_GRAY);
		log.add(WEL);
		
		JLabel userID = new JLabel("USERID: ");
		userID.setBounds(300,100,400,300);
		
		log.add(userID);
		
		JLabel password = new JLabel("Password: ");
		
		password.setForeground(Color.DARK_GRAY);
		log.add(password);
		
		background.setBounds(0,0,1024,1024);
		loginWindow.add(background);
		loginWindow.setSize(1024,1024);
		
		
		
		loginWindow.setLayout(null);
		loginWindow.setVisible(true);
	}
}
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new loginUI();
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

