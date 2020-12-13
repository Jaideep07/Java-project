package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import actorClasses.Client;

public class ClientGui {
	
	public ClientGui(String username){
		JFrame clientWindow = new JFrame("Client");
		ImageIcon img = new ImageIcon("src/Construction.jpg");
		JLabel background = new JLabel("",img,JLabel.CENTER);
		
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
		
		JButton exit = new JButton("Exit");
		exit.setBounds(600,7,90,18);
		exit.setForeground(Color.red);
		exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		clientWindow.add(exit);
		
		JPanel pane = new JPanel();
		pane.setBounds(10,30,680,420);
		pane.setBackground(new Color(102, 179, 255));
		clientWindow.add(pane);
		
		JLabel projStat = new JLabel("Your Projects");
		projStat.setBounds(270,20,200,20);
		projStat.setForeground(Color.GRAY);
		projStat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pane.add(projStat);
		
		String[] columns = {"PID","Start_date","End_date","Status","City","State"};
		JTable table = new JTable(c.trackProjectStatus(),columns);
		JScrollPane scroll = new JScrollPane();
		scroll.add(table);
		pane.add(scroll);
		scroll.setBounds(75,65,525,205);
		
		JButton addSite = new JButton("Add Site");
		addSite.setText("Add Site");
		pane.add(addSite);
		addSite.setBounds(270, 350, 130, 35);
		
		background.setBounds(0,0,720,500);
		clientWindow.add(background);
		clientWindow.setSize(720,500);
		
		pane.setLayout(null);
		clientWindow.setLayout(null);
		clientWindow.setVisible(true);
	}

}