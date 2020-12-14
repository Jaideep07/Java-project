package gui;

import actorClasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RetailerGui implements ActionListener {
	JFrame retailerWindow =null;
	JButton exit=null;
	JPanel p1=null;
	JPanel p2=null;
	JButton b=new JButton("Update");
	JTextField t1;
	JTextField t2;
	JTextField t3;
	JTextField t4;
	Retailer r;
	public RetailerGui() {
		new isRetailerRegistered();
	}
	public RetailerGui(String id)
	{
		r= new Retailer(id);
		retailerWindow = new JFrame();
		ImageIcon img = new ImageIcon("src/Construction.jpg");
		JLabel background = new JLabel("",img,JLabel.CENTER);
		
		JLabel user = new JLabel("Welcome! "+ r.name);
	    user.setBounds(10,7,250,12);
	    user.setForeground(Color.red);
	    user.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    retailerWindow.add(user);
		
		exit = new JButton("Exit");
        exit.setBounds(900,7,90,18);
        exit.setForeground(Color.red);
        exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
        retailerWindow.add(exit);
        exit.addActionListener(this);
        
        JPanel p3=new JPanel();
        JLabel lb=new JLabel("View Orders");
        lb.setFont(new Font("Times New Roman", Font.BOLD, 21));
        p3.setBackground(new Color(102,179,255));
        p3.setBounds(40, 60, 450, 50);
        p3.add(lb);
        p1=new JPanel(new BorderLayout());
        p1.setBounds(40, 110, 450, 450);
		p1.setBackground(new Color(102,179,255));
		String orders[][]=r.viewOrders(r.retailerId);
		String columns[]= {"Site Id","Material Model","Material Name"};
		JTable table1=new JTable(orders,columns);
		p1.add(new JScrollPane(table1));
		
		p2=new JPanel();
		p2.setBounds(540, 60, 450, 400);
		p2.setBackground(new Color(102,179,255));
		
		JLabel head =new JLabel("Add Materials");
		head.setFont(new Font("Times New Roman", Font.BOLD, 21));
		head.setBounds(30, 5, 80, 50);
		p2.add(head);
		
		JLabel l1=new JLabel("Material Name:");
		JLabel l2=new JLabel("Material Model:");
		JLabel l3=new JLabel("Material Type:");
		JLabel l4=new JLabel("Manufacturer:");
		l1.setBounds(580, 110, 130, 30);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		l2.setBounds(580, 150, 130, 30);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		l3.setBounds(580, 200, 130, 30);
		l3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		l4.setBounds(580, 250, 130, 30);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		t1=new JTextField("");
		t2=new JTextField("");
		t3=new JTextField("");
		t4=new JTextField("");
		t1.setBounds(750, 115, 160, 20);
		t2.setBounds(750, 165, 160, 20);
		t3.setBounds(750, 205, 160, 20);
		t4.setBounds(750, 255, 160, 20);
		retailerWindow.add(l1);retailerWindow.add(l2);retailerWindow.add(l3);retailerWindow.add(l4);
		retailerWindow.add(t1);retailerWindow.add(t2);retailerWindow.add(t3);retailerWindow.add(t4);
		
		b.setBounds(700, 520, 100, 30);
		b.addActionListener(this);
		
		retailerWindow.add(exit);
		retailerWindow.add(p1);
		retailerWindow.add(p2);
		retailerWindow.add(p3);
		retailerWindow.add(b);
		
		retailerWindow.add(background);
		//retailerWindow.setLayout(null);
		retailerWindow.setSize(1024,1024);
		retailerWindow.setTitle("Retailer");
		retailerWindow.setVisible(true);
	}

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new RetailerGui();
	//}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exit)
		{
			retailerWindow.dispose();
		}
		else if(e.getSource()==b)
		{
			String m_name=t1.getText();
			String model=t2.getText();
			String type=t3.getText();
			String manu=t4.getText();
			r.addMaterialDetails(m_name, model, type, manu);
			JFrame frame= new JFrame("Message");
			JOptionPane.showMessageDialog(frame, "Updated Successfully!");
			
		}
	}

}

class registerRetailer implements ActionListener{
	String userid = null;
	JButton exitC = null;
	JButton register = null;
	JPanel CPane = null;
	JFrame CRegis = null;
	JLabel retailerDetails = null;
	JLabel noteC = null;
	
	JLabel streetName = null;
	JTextField streetNameR = null;
	JLabel city = null;
	JTextField cityR = null;
	JLabel state = null;
	JTextField stateR = null;
	JLabel zipCode = null;
	JTextField zipCodeR = null;
	
	JLabel fname = null;
	JTextField fnameR = null;
	JLabel passcode = null;
	JPasswordField passcodeR = null;
	
	JLabel email = null;
	JTextField emailR = null;
	JLabel msg = null; 
	
	public registerRetailer(){
		CRegis = new JFrame("Retailer Registration");
		ImageIcon img = new ImageIcon("src/Construction.jpg");
		JLabel background = new JLabel("",img,JLabel.CENTER);
		
		CPane = new JPanel();
		CPane.setBounds(80,40,545,410);
		CPane.setBackground(new Color(102, 179, 255));
		CRegis.add(CPane);
		
		JLabel header = new JLabel("Retailer Registration");
		header.setBounds(25,9,270,25);
		header.setForeground(Color.red);
		header.setFont(new Font("Times New Roman", Font.BOLD, 25));
		CRegis.add(header);
		
		retailerDetails = new JLabel("Retailer Details");
		retailerDetails.setBounds(210,10,200,25);
		retailerDetails.setForeground(Color.DARK_GRAY);
		retailerDetails.setFont(new Font("Times New Roman", Font.BOLD, 25));
		CPane.add(retailerDetails);
		
		streetName = new JLabel("Street name:");
		streetName.setBounds(75,45,200,25);
		streetName.setForeground(Color.GRAY);
		streetName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(streetName);
		
		streetNameR = new JTextField("");
		streetNameR.setBounds(275,47,200,20);
		streetNameR.setForeground(Color.GRAY);
		streetNameR.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(streetNameR);
		
		city = new JLabel("City:");
		city.setBounds(75,80,200,25);
		city.setForeground(Color.GRAY);
		city.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(city);
		
		cityR = new JTextField("");
		cityR.setBounds(275,82,200,20);
		cityR.setForeground(Color.GRAY);
		cityR.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(cityR);
		
		state = new JLabel("State:");
		state.setBounds(75,120,200,25);
		state.setForeground(Color.GRAY);
		state.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(state);
		
		stateR = new JTextField("");
		stateR.setBounds(275,122,200,20);
		stateR.setForeground(Color.GRAY);
		stateR.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(stateR);
		
		zipCode = new JLabel("Zip code:");
		zipCode.setBounds(75,150,200,25);
		zipCode.setForeground(Color.GRAY);
		zipCode.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(zipCode);
		
		zipCodeR = new JTextField("");
		zipCodeR.setBounds(275,152,200,20);
		zipCodeR.setForeground(Color.GRAY);
		zipCodeR.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(zipCodeR);
		
		fname = new JLabel("First name:");
		fname.setBounds(75,180,200,25);
		fname.setForeground(Color.GRAY);
		fname.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(fname);
		
		fnameR = new JTextField("");
		fnameR.setBounds(275,182,200,20);
		fnameR.setForeground(Color.GRAY);
		fnameR.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(fnameR);
		
		
		passcode = new JLabel("Set password:");
		passcode.setBounds(75,260,200,25);
		passcode.setForeground(Color.GRAY);
		passcode.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(passcode);
		
		passcodeR = new JPasswordField("");
		passcodeR.setBounds(275,262,200,20);
		passcodeR.setForeground(Color.GRAY);
		passcodeR.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(passcodeR);
		
		
		email = new JLabel("Email ID:");
		email.setBounds(75,220,200,25);
		email.setForeground(Color.GRAY);
		email.setFont(new Font("Times New Roman", Font.BOLD, 18));
		CPane.add(email);
		
		emailR = new JTextField("");
		emailR.setBounds(275,222,200,20);
		emailR.setForeground(Color.GRAY);
		emailR.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		CPane.add(emailR);
		
		register = new JButton("Register!");
		CPane.add(register);
		register.setBounds(210, 340, 130, 35);
		register.addActionListener(this);
		
		noteC = new JLabel("**RetailerID is generated as soon as you register.");
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
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(exitC)) {
			CRegis.dispose();
		}
		else if(e.getSource()==register) {
			Retailer r = new Retailer();
			String str= zipCodeR.getText();
			int z=Integer.parseInt(str);
			String s = r.retailerRegistration(fnameR.getText(), streetNameR.getText(), cityR.getText(), stateR.getText(), z, passcodeR.getText(), emailR.getText());
			JFrame frame= new JFrame("Message");
			JOptionPane.showMessageDialog(frame, s);
		}
	}
	
}

class isRetailerRegistered implements ActionListener{
	JFrame isRregistered = null;
	JButton rRegis = null;
	JButton rContinue = null;
	public isRetailerRegistered(){
		isRregistered = new JFrame("Have You Registered?");
		
		JLabel nRetailer = new JLabel("New Retailer?");
		nRetailer.setBounds(85,9,200,25);
		nRetailer.setForeground(Color.blue);
		nRetailer.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		isRregistered.add(nRetailer);
		
		rRegis = new JButton("Register!");
		rRegis.setBounds(80, 45, 120, 22);
		isRregistered.add(rRegis);
		
		JLabel RRetailer = new JLabel("Already Registered?");
		RRetailer.setBounds(55,85,200,25);
		RRetailer.setForeground(Color.blue);
		RRetailer.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		isRregistered.add(RRetailer);
		
		rContinue = new JButton("Continue");
		rContinue.setBounds(80, 120, 120, 22);
		isRregistered.add(rContinue);
		
		isRregistered.setSize(300,200);
		isRregistered.setLayout(null);
		isRregistered.setVisible(true);
		
		rContinue.addActionListener(this);
		rRegis.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(rContinue)) {
			isRregistered.dispose();
		}
		else {
			new registerRetailer();
			isRregistered.dispose();
		}
	}
}

