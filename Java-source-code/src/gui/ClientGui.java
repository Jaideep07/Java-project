package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import actorClasses.Client;

class registerClient implements ActionListener{
	String userid = null;
	JButton exitC = null;
	JButton registerC = null;
	JPanel CPane = null;
	JFrame CRegis = null;
	JLabel clientDetails = null;
	JLabel noteC = null;
	
	JLabel streetName = null;
	JTextField streetNameC = null;
	JLabel city = null;
	JTextField cityC = null;
	JLabel state = null;
	JTextField stateC = null;
	JLabel zipCode = null;
	JTextField zipCodeC = null;
	
	JLabel fname = null;
	JTextField fnameC = null;
	JLabel lname = null;
	JTextField lnameC = null;
	JLabel passcode = null;
	JPasswordField passcodeC = null;
	
	JLabel phone = null;
	JTextField phoneC = null;
	JLabel email = null;
	JTextField emailC = null;
	JLabel msg = null; 
	Client c = new Client();
	public registerClient(){
		CRegis = new JFrame("Client Registration");
		ImageIcon img = new ImageIcon("src/Construction.jpg");
		JLabel background = new JLabel("",img,JLabel.CENTER);
		
		CPane = new JPanel();
		CPane.setBounds(80,40,545,410);
		CPane.setBackground(new Color(102, 179, 255));
		CRegis.add(CPane);
		
		JLabel header = new JLabel("Client Registration");
		header.setBounds(25,9,270,25);
		header.setForeground(Color.red);
		header.setFont(new Font("Times New Roman", Font.BOLD, 25));
		CRegis.add(header);
		
		clientDetails = new JLabel("Client Details");
		clientDetails.setBounds(210,10,200,25);
		clientDetails.setForeground(Color.DARK_GRAY);
		clientDetails.setFont(new Font("Times New Roman", Font.BOLD, 25));
		CPane.add(clientDetails);
		
		streetName = new JLabel("Street name:");
		streetName.setBounds(75,40,200,25);
		streetName.setForeground(Color.GRAY);
		streetName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(streetName);
		
		streetNameC = new JTextField("");
		streetNameC.setBounds(275,42,200,20);
		streetNameC.setForeground(Color.GRAY);
		streetNameC.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(streetNameC);
		
		city = new JLabel("City:");
		city.setBounds(75,70,200,25);
		city.setForeground(Color.GRAY);
		city.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(city);
		
		cityC = new JTextField("");
		cityC.setBounds(275,72,200,20);
		cityC.setForeground(Color.GRAY);
		cityC.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(cityC);
		
		state = new JLabel("State:");
		state.setBounds(75,100,200,25);
		state.setForeground(Color.GRAY);
		state.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(state);
		
		stateC = new JTextField("");
		stateC.setBounds(275,102,200,20);
		stateC.setForeground(Color.GRAY);
		stateC.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(stateC);
		
		zipCode = new JLabel("Zip code:");
		zipCode.setBounds(75,130,200,25);
		zipCode.setForeground(Color.GRAY);
		zipCode.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(zipCode);
		
		zipCodeC = new JTextField("");
		zipCodeC.setBounds(275,132,200,20);
		zipCodeC.setForeground(Color.GRAY);
		zipCodeC.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(zipCodeC);
		
		fname = new JLabel("First name:");
		fname.setBounds(75,160,200,25);
		fname.setForeground(Color.GRAY);
		fname.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(fname);
		
		fnameC = new JTextField("");
		fnameC.setBounds(275,162,200,20);
		fnameC.setForeground(Color.GRAY);
		fnameC.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(fnameC);
		
		lname = new JLabel("Last name:");
		lname.setBounds(75,190,200,25);
		lname.setForeground(Color.GRAY);
		lname.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(lname);
		
		lnameC = new JTextField("");
		lnameC.setBounds(275,192,200,20);
		lnameC.setForeground(Color.GRAY);
		lnameC.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(lnameC);
		
		passcode = new JLabel("Set password:");
		passcode.setBounds(75,280,200,25);
		passcode.setForeground(Color.GRAY);
		passcode.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(passcode);
		
		passcodeC = new JPasswordField("");
		passcodeC.setBounds(275,282,200,20);
		passcodeC.setForeground(Color.GRAY);
		passcodeC.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(passcodeC);
		
		phone = new JLabel("Phone number:");
		phone.setBounds(75,220,200,25);
		phone.setForeground(Color.GRAY);
		phone.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(phone);
		
		phoneC = new JTextField("");
		phoneC.setBounds(275,222,200,20);
		phoneC.setForeground(Color.GRAY);
		phoneC.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(phoneC);
		
		email = new JLabel("Email ID:");
		email.setBounds(75,250,200,25);
		email.setForeground(Color.GRAY);
		email.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(email);
		
		emailC = new JTextField("");
		emailC.setBounds(275,252,200,20);
		emailC.setForeground(Color.GRAY);
		emailC.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(emailC);
		
		registerC = new JButton("Register!");
		CPane.add(registerC);
		registerC.setBounds(210, 340, 130, 35);
		
		noteC = new JLabel("**ClientID is generated as soon as you register.");
		noteC.setBounds(150,380,300,20);
		noteC.setForeground(Color.red);
		noteC.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		CPane.add(noteC);
		
		exitC = new JButton("Exit");
		exitC.setBounds(600,9,90,18);
		exitC.setForeground(Color.red);
		exitC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		CRegis.add(exitC);
		
		msg = new JLabel("");
		msg.setBounds(230,320,200,20);
		msg.setForeground(Color.red);
		msg.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(msg);
		
		background.setBounds(0,0,720,500);
		CRegis.add(background);
		CRegis.setSize(720,500);
		
		CPane.setLayout(null);
		CRegis.setLayout(null);
		CRegis.setVisible(true);
		
		streetNameC.addActionListener(this);
		cityC.addActionListener(this);
		stateC.addActionListener(this);
		zipCodeC.addActionListener(this);
		fnameC.addActionListener(this);
		lnameC.addActionListener(this);
		passcodeC.addActionListener(this);
		phoneC.addActionListener(this);
		emailC.addActionListener(this);
		exitC.addActionListener(this);
		registerC.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(exitC)) {
			CRegis.dispose();
		}
		else if(e.getSource().equals(registerC)) {
			
			String[] s = new String[1];
			s[0] = emailC.getText();
			long[] l = new long[1];
			l[0] = Long.parseLong(phoneC.getText());
			String id = c.clientRegistration(fnameC.getText(), lnameC.getText(), streetNameC.getText(), cityC.getText(), stateC.getText(), zipCodeC.getText(), passcodeC.getText(), s, l);
			msg.setText("Your Id is "+id);
			JFrame frame= new JFrame("Message");
			JOptionPane.showMessageDialog(frame, "Registered Successfully!");
		}
	}
}

class isClientRegistered implements ActionListener{
	JFrame isCregistered = null;
	JButton clRegis = null;
	JButton cContinue = null;
	public isClientRegistered(){
		isCregistered = new JFrame("Have You Registered?");
		
		JLabel nClient = new JLabel("New Client?");
		nClient.setBounds(85,9,200,25);
		nClient.setForeground(Color.blue);
		nClient.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		isCregistered.add(nClient);
		
		clRegis = new JButton("Register!");
		clRegis.setBounds(80, 45, 120, 22);
		isCregistered.add(clRegis);
		
		JLabel RClient = new JLabel("Already Registered?");
		RClient.setBounds(55,85,200,25);
		RClient.setForeground(Color.blue);
		RClient.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		isCregistered.add(RClient);
		
		cContinue = new JButton("Continue");
		cContinue.setBounds(80, 120, 120, 22);
		isCregistered.add(cContinue);
		
		isCregistered.setSize(300,200);
		isCregistered.setLayout(null);
		isCregistered.setVisible(true);
		
		cContinue.addActionListener(this);
		clRegis.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(cContinue)) {
			isCregistered.dispose();
		}
		else {
			new registerClient();
			isCregistered.dispose();
		}
	}
}

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
	
	Client cl = null;
	public siteRegistration(String username){
		userid = username;
		cl = new Client(userid);
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
		
		/*
		streetNameT.addActionListener(this);
		cityT.addActionListener(this);
		stateT.addActionListener(this);
		zipCodeT.addActionListener(this);
		areaT.addActionListener(this);
		terrinTypeT.addActionListener(this);
		soilTypeT.addActionListener(this);
		ownerTypeT.addActionListener(this);
		dateOfPurchaseT.addActionListener(this);*/
		exitS.addActionListener(this);
		registerS.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(exitS)) {
			siteRegis.dispose();
		}
		else if(e.getSource().equals(registerS)) {
			
			cl.enterSiteInfo(streetNameT.getText(), cityT.getText(), stateT.getText(), zipCodeT.getText(), areaT.getText(), terrinTypeT.getText(), soilTypeT.getSelectedText(), dateOfPurchaseT.getText(), ownerTypeT.getText());
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
	
	public ClientGui() {
		new isClientRegistered();
	}
	
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientGui();
	}

}