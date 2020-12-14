package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import actorClasses.*;

public class SupervisorGui implements ActionListener{
	JFrame SupWindow = null;
	JButton exit = null;
	JTextField site = null;
	JTextField matName = null;
	JTextField matModel = null;
	JTextField builderID= null;
	JTextField projectID = null;
	JTextField pno = null;
	JTextField contractName = null;
	JTextField companyName  = null;
	JTextField contactno  = null;
	
	JButton allocateSubCon = null;
	JButton showProjectStat = null;
	JButton trackBuilder = null;
	JButton getRawMat = null;
	JButton allocateRawMat = null;

	String sid = null;
	Supervisor s1 = new Supervisor(sid);
		public SupervisorGui(String username){
			SupWindow = new JFrame("Supervisor");
			ImageIcon img = new ImageIcon("src/Construction.jpg");
			JLabel background = new JLabel("",img,JLabel.CENTER);
			sid = username;
			
			JLabel user = new JLabel("Welcome! "+ s1.name);
			user.setBounds(15,7,250,12);
			user.setForeground(Color.red);
			user.setFont(new Font("Times New Roman", Font.BOLD, 18));
			SupWindow.add(user);
			
			JLabel userType = new JLabel("Supervisor");
			userType.setBounds(365,5,200,20);
			userType.setForeground(Color.DARK_GRAY);
			userType.setFont(new Font("Times New Roman", Font.BOLD, 18));
			SupWindow.add(userType);
			
			exit = new JButton("Exit");
			exit.setBounds(690,7,90,18);
			exit.setForeground(Color.red);
			exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
			SupWindow.add(exit);
			
			JPanel p1 = new JPanel();
			p1.setBounds(10,30,380,270);
			p1.setBackground(new Color(102, 179, 255));
			SupWindow.add(p1);
			
			JLabel AllocateRaw = new JLabel("Allocate Raw Materials");
			AllocateRaw.setBounds(100,5,200,20);
			AllocateRaw.setForeground(Color.DARK_GRAY);
			AllocateRaw.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			p1.add(AllocateRaw);
			
			JLabel sitel = new JLabel("Site ID");
			sitel.setBounds(15,40,200,20);
			sitel.setForeground(Color.DARK_GRAY);
			sitel.setFont(new Font("Times New Roman", Font.BOLD, 18));
			p1.add(sitel);
			
			site = new JTextField("");
			site.setBounds(200,40,100,20);
			site.setForeground(Color.GRAY);
			site.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			p1.add(site);
			
			JLabel mName = new JLabel("Material name");
			mName.setBounds(15,80,200,20);
			mName.setForeground(Color.DARK_GRAY);
			mName.setFont(new Font("Times New Roman", Font.BOLD, 18));
			p1.add(mName);
			
			matName = new JTextField("");
			matName.setBounds(200,80,100,20);
			matName.setForeground(Color.GRAY);
			matName.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			p1.add(matName);
			
			JLabel mModel = new JLabel("Material model");
			mModel.setBounds(15,120,200,20);
			mModel.setForeground(Color.DARK_GRAY);
			mModel.setFont(new Font("Times New Roman", Font.BOLD, 18));
			p1.add(mModel);
			
			matModel = new JTextField("");
			matModel.setBounds(200,120,100,20);
			matModel.setForeground(Color.GRAY);
			matModel.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			p1.add(matModel);
			
			allocateRawMat = new JButton("Allocate");
			allocateRawMat.setBounds(85, 230, 200, 22);
			p1.add(allocateRawMat);
			
			JPanel p2 = new JPanel();
			p2.setBounds(410,30,380,270);
			p2.setBackground(new Color(102, 179, 255));
			SupWindow.add(p2);
			
			JLabel allocateSub = new JLabel("Allocate Sub-Contracts");
			allocateSub.setBounds(100,5,200,20);
			allocateSub.setForeground(Color.DARK_GRAY);
			allocateSub.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			p2.add(allocateSub);
			
			JLabel pnum = new JLabel("Project ID");
			pnum.setBounds(15,40,200,20);
			pnum.setForeground(Color.DARK_GRAY);
			pnum.setFont(new Font("Times New Roman", Font.BOLD, 18));
			p2.add(pnum);
			
			pno = new JTextField("");
			pno.setBounds(200,40,100,20);
			pno.setForeground(Color.GRAY);
			pno.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			p2.add(pno);
			
			JLabel conName = new JLabel("Contract name");
			conName.setBounds(15,80,200,20);
			conName.setForeground(Color.DARK_GRAY);
			conName.setFont(new Font("Times New Roman", Font.BOLD, 18));
			p2.add(conName);
			
			contractName = new JTextField("");
			contractName.setBounds(200,80,100,20);
			contractName.setForeground(Color.GRAY);
			contractName.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			p2.add(contractName);
			
			JLabel comName = new JLabel("Company name");
			comName.setBounds(15,120,200,20);
			comName.setForeground(Color.DARK_GRAY);
			comName.setFont(new Font("Times New Roman", Font.BOLD, 18));
			p2.add(comName);
			
			companyName = new JTextField("");
			companyName.setBounds(200,120,100,20);
			companyName.setForeground(Color.GRAY);
			companyName.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			p2.add(companyName);
			
			JLabel comCon = new JLabel("Company number");
			comCon.setBounds(15,160,200,20);
			comCon.setForeground(Color.DARK_GRAY);
			comCon.setFont(new Font("Times New Roman", Font.BOLD, 18));
			p2.add(comCon);
			
			contactno = new JTextField("");
			contactno.setBounds(200,160,100,20);
			contactno.setForeground(Color.GRAY);
			contactno.setFont(new Font("Times New Roman", Font.ITALIC, 16));
			p2.add(contactno);
			
			allocateSubCon = new JButton("Allocate");
			allocateSubCon.setBounds(85, 230, 200, 22);
			p2.add(allocateSubCon);
			
			getRawMat = new JButton("Get raw materials");
			getRawMat.setBounds(40,320,300,20);
			SupWindow.add(getRawMat);
			
			showProjectStat = new JButton("Get projects status");
			showProjectStat.setBounds(450,320,300,20);
			SupWindow.add(showProjectStat);
			
			trackBuilder = new JButton("Track builder status");
			trackBuilder.setBounds(260,350,300,20);
			SupWindow.add(trackBuilder);
			
			background.setBounds(0,0,820,460);
			SupWindow.add(background);
			SupWindow.setSize(820,460);
			p1.setLayout(null);
			p2.setLayout(null);
			SupWindow.setLayout(null);
			SupWindow.setVisible(true);
			
			exit.addActionListener(this);
			allocateRawMat.addActionListener(this);
			allocateSubCon.addActionListener(this);
			showProjectStat.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(exit)) {
				SupWindow.dispose();
			}
			else if(e.getSource().equals(allocateRawMat)) {
				//s1.allocateRawMaterials(site.getText(), matName.getText(), matModel.getText());
			}
			else if(e.getSource().equals(allocateSubCon)) {
				s1.allocateSubcontracts(pno.getText(), contractName.getText(), companyName.getText(), Long.parseLong(contactno.getText()));
			}
			else if(e.getSource().equals(showProjectStat)) {
				JFrame frame= new JFrame("Projects Status");
				String[] columns = {"builder_id", "project_no", "completion_status" };
				JTable table = new JTable(s1.projectStatus(pno.getText()),columns);
				JScrollPane scroll = new JScrollPane(table);
				scroll.setSize(300,100);
				frame.add(scroll);
				frame.setSize(500,300);
				frame.setVisible(true);
			}
			
		}
}
