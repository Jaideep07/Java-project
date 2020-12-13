package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import actorClasses.Client;

class siteRegistration implements ActionListener{
	String userid = null;
	JButton exitS = null;
	JButton registerS = null;
	JPanel sitePane = null;
	JFrame siteRegis = null;
	JLabel siteDetails = null;
	JLabel noteS = null;
	
	JLabel streetName = null;
	JTextField streetNameT = null;
	JLabel city = null;
	JTextField cityT = null;
	JLabel state = null;
	JTextField stateT = null;
	JLabel zipCode = null;
	JTextField zipCodeT = null;
	
	JLabel area = null;
	JTextField areaT = null;
	JLabel terrinType = null;
	JTextField terrinTypeT = null;
	JLabel soilType = null;
	JTextField soilTypeT = null;
	
	JLabel ownerType = null;
	JTextField ownerTypeT = null;
	JLabel dateOfPurchase = null;
	JTextField dateOfPurchaseT = null;
	
	public siteRegistration(String username){
		userid = username;
		siteRegis = new JFrame("Site Registration");
		ImageIcon img = new ImageIcon("src/Construction.jpg");
		JLabel background = new JLabel("",img,JLabel.CENTER);
		
		sitePane = new JPanel();
		sitePane.setBounds(80,40,545,410);
		sitePane.setBackground(new Color(102, 179, 255));
		siteRegis.add(sitePane);
		
		JLabel header = new JLabel("Site Registration");
		header.setBounds(25,9,200,25);
		header.setForeground(Color.red);
		header.setFont(new Font("Times New Roman", Font.BOLD, 25));
		siteRegis.add(header);
		
		siteDetails = new JLabel("Site Details");
		siteDetails.setBounds(210,10,200,25);
		siteDetails.setForeground(Color.DARK_GRAY);
		siteDetails.setFont(new Font("Times New Roman", Font.BOLD, 25));
		sitePane.add(siteDetails);
		
		streetName = new JLabel("Street name:");
		streetName.setBounds(75,40,200,25);
		streetName.setForeground(Color.GRAY);
		streetName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sitePane.add(streetName);
		
		streetNameT = new JTextField("");
		streetNameT.setBounds(275,42,200,20);
		streetNameT.setForeground(Color.GRAY);
		streetNameT.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		sitePane.add(streetNameT);
		
		city = new JLabel("City:");
		city.setBounds(75,70,200,25);
		city.setForeground(Color.GRAY);
		city.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sitePane.add(city);
		
		cityT = new JTextField("");
		cityT.setBounds(275,72,200,20);
		cityT.setForeground(Color.GRAY);
		cityT.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		sitePane.add(cityT);
		
		state = new JLabel("State:");
		state.setBounds(75,100,200,25);
		state.setForeground(Color.GRAY);
		state.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sitePane.add(state);
		
		stateT = new JTextField("");
		stateT.setBounds(275,102,200,20);
		stateT.setForeground(Color.GRAY);
		stateT.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		sitePane.add(stateT);
		
		zipCode = new JLabel("Zip code:");
		zipCode.setBounds(75,130,200,25);
		zipCode.setForeground(Color.GRAY);
		zipCode.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sitePane.add(zipCode);
		
		zipCodeT = new JTextField("");
		zipCodeT.setBounds(275,132,200,20);
		zipCodeT.setForeground(Color.GRAY);
		zipCodeT.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		sitePane.add(zipCodeT);
		
		area = new JLabel("Area(in sq.yards):");
		area.setBounds(75,160,200,25);
		area.setForeground(Color.GRAY);
		area.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sitePane.add(area);
		
		areaT = new JTextField("");
		areaT.setBounds(275,162,200,20);
		areaT.setForeground(Color.GRAY);
		areaT.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		sitePane.add(areaT);
		
		terrinType = new JLabel("Terrain type:");
		terrinType.setBounds(75,190,200,25);
		terrinType.setForeground(Color.GRAY);
		terrinType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sitePane.add(terrinType);
		
		terrinTypeT = new JTextField("");
		terrinTypeT.setBounds(275,192,200,20);
		terrinTypeT.setForeground(Color.GRAY);
		terrinTypeT.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		sitePane.add(terrinTypeT);
		
		soilType = new JLabel("Soil type:");
		soilType.setBounds(75,220,200,25);
		soilType.setForeground(Color.GRAY);
		soilType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sitePane.add(soilType);
		
		soilTypeT = new JTextField("");
		soilTypeT.setBounds(275,222,200,20);
		soilTypeT.setForeground(Color.GRAY);
		soilTypeT.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		sitePane.add(soilTypeT);
		
		ownerType = new JLabel("Ownership type:");
		ownerType.setBounds(75,250,200,25);
		ownerType.setForeground(Color.GRAY);
		ownerType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sitePane.add(ownerType);
		
		ownerTypeT = new JTextField("");
		ownerTypeT.setBounds(275,252,200,20);
		ownerTypeT.setForeground(Color.GRAY);
		ownerTypeT.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		sitePane.add(ownerTypeT);
		
		dateOfPurchase = new JLabel("Date of purchase:");
		dateOfPurchase.setBounds(75,280,200,25);
		dateOfPurchase.setForeground(Color.GRAY);
		dateOfPurchase.setFont(new Font("Times New Roman", Font.BOLD, 18));
		sitePane.add(dateOfPurchase);
		
		dateOfPurchaseT = new JTextField("");
		dateOfPurchaseT.setBounds(275,282,200,20);
		dateOfPurchaseT.setForeground(Color.GRAY);
		dateOfPurchaseT.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		sitePane.add(dateOfPurchaseT);
		
		registerS = new JButton("Register!");
		sitePane.add(registerS);
		registerS.setBounds(210, 340, 130, 35);
		
		noteS = new JLabel("**SiteID is generated as soon as you register.");
		noteS.setBounds(150,380,300,20);
		noteS.setForeground(Color.red);
		noteS.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		sitePane.add(noteS);
		
		exitS = new JButton("Exit");
		exitS.setBounds(600,9,90,18);
		exitS.setForeground(Color.red);
		exitS.setFont(new Font("Times New Roman", Font.BOLD, 15));
		siteRegis.add(exitS);
		
		background.setBounds(0,0,720,500);
		siteRegis.add(background);
		siteRegis.setSize(720,500);
		
		sitePane.setLayout(null);
		siteRegis.setLayout(null);
		siteRegis.setVisible(true);
		
		streetNameT.addActionListener(this);
		cityT.addActionListener(this);
		stateT.addActionListener(this);
		zipCodeT.addActionListener(this);
		areaT.addActionListener(this);
		terrinTypeT.addActionListener(this);
		soilTypeT.addActionListener(this);
		ownerTypeT.addActionListener(this);
		dateOfPurchaseT.addActionListener(this);
		exitS.addActionListener(this);
		registerS.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(exitS)) {
			siteRegis.dispose();
		}
		else if(e.getSource().equals(registerS)) {
			Client cl = new Client(userid);
			cl.enterSiteInfo(streetNameT.getText(), cityT.getText(), stateT.getText(), zipCodeT.getText(), areaT.getText(), terrinTypeT.getText(), soilTypeT.getSelectedText(), userid, dateOfPurchaseT.getText(), ownerTypeT.getText());
			JFrame frame= new JFrame("Message");
			JOptionPane.showMessageDialog(frame, "Registered Successfully!");
		}
	}
}

public class ClientGui implements ActionListener {
	JFrame clientWindow = null;
	JButton exit = null;
	JButton addSite = null;
	public String userID = null;
	
	public ClientGui(String username){
		clientWindow = new JFrame("Client");
		ImageIcon img = new ImageIcon("src/Construction.jpg");
		JLabel background = new JLabel("",img,JLabel.CENTER);
		
		userID = username;
		Client c = new Client(username);
		
		JLabel user = new JLabel("Welcome! "+c.getName());
		user.setBounds(10,7,250,12);
		user.setForeground(Color.red);
		user.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clientWindow.add(user);
		
		JLabel userType = new JLabel("Client");
		userType.setBounds(320,7,200,12);
		userType.setForeground(Color.DARK_GRAY);
		userType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		clientWindow.add(userType);
		
		exit = new JButton("Exit");
		exit.setBounds(600,7,90,18);
		exit.setForeground(Color.red);
		exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		clientWindow.add(exit);
		
		JPanel pane = new JPanel();
		pane.setBounds(90,30,500,300);
		pane.setBackground(new Color(102, 179, 255));
		clientWindow.add(pane);
		
		JLabel projStat = new JLabel("Your Projects");
		projStat.setBounds(270,20,200,20);
		projStat.setForeground(Color.GRAY);
		projStat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pane.add(projStat);
		
		String[] columns = {"SiteID","Verification_status","Start_date","End_date","Status","City","State"};
		JTable table = new JTable(c.trackProjectStatus(),columns);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setSize(300,100);
		pane.add(scroll);
		
		
		addSite = new JButton("Add Site");
		addSite.setText("Add Site");
		clientWindow.add(addSite);
		addSite.setBounds(270, 350, 130, 35);
		
		background.setBounds(0,0,720,500);
		clientWindow.add(background);
		clientWindow.setSize(720,500);
		
		clientWindow.setLayout(null);
		clientWindow.setVisible(true);
		
		addSite.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(exit)) {
			clientWindow.dispose();
		}
		else if(e.getSource().equals(addSite)){
			new siteRegistration(userID);
		}
	}

}