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
		log.setBounds(310,190,400,290);
		log.setBackground(new Color(102, 179, 255));
		loginWindow.add(log);
		
		JLabel CMS = new JLabel("Construction Company Managment System");
		CMS.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		CMS.setForeground(Color.DARK_GRAY);
		CMS.setBounds(25,2,350,50);
		log.add(CMS);
		
		JLabel WEL = new JLabel("Welcome to login page!");
		WEL.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		WEL.setForeground(Color.DARK_GRAY);
		WEL.setBounds(125,35,350,30);
		log.add(WEL);
		
		JLabel loginType = new JLabel("Login type: ");
		loginType.setFont(new Font("Times New Roman", Font.BOLD, 16));
		loginType.setBounds(90,90,100,20);
		log.add(loginType);
		
	    String type[] = { "None","Manager","Retailer","Builder","Customer","Supervisor"};
	    JComboBox select = new JComboBox(type);
	    select.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    select.setBounds(200,90,100,22);
	    log.add(select);
		
		JLabel userID = new JLabel("USERID: ");
		userID.setBounds(90,130,100,20);
		userID.setFont(new Font("Times New Roman", Font.BOLD, 15));
		log.add(userID);
		
		JTextField id = new JTextField("");
	    id.setBounds(200,130,100,20);
	    log.add(id);
	    
		JLabel password = new JLabel("Password: ");
		password.setBounds(90,170,100,20);
		password.setFont(new Font("Times New Roman", Font.BOLD, 16));
		log.add(password);
		
		JPasswordField code = new JPasswordField("");
		code.setBounds(200,170,100,20);
		log.add(code);
		
		JButton enter = new JButton("Enter");
		enter.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		enter.setBounds(150,220,100,20);
		log.add(enter);
		
		background.setBounds(0,0,1024,1024);
		loginWindow.add(background);
		loginWindow.setSize(1024,1024);
		
		log.setLayout(null);
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

