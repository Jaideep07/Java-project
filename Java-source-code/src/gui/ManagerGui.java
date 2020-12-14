package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import actorClasses.*;
import threads.*;

public class ManagerGui implements ActionListener{
	JFrame ManagerWindow = null;
	JButton exit = null;
	JTextField project1 = null;
	JTextField project2 = null;
	JTextField project3 = null;
	JTextField builder1 = null;
	JTextField builder2 = null;
	JTextField status = null;
	JTextField siteid = null;
	JTextField salary  = null;
	
	JButton assign = null;
	JButton update = null;
	JButton allocate = null;
	JButton pay = null;
	
	JButton showBuilder1 = null;
	JButton showBuilder2 = null;
	JButton showSite =null;
	JButton showProjects = null;
	Manager m = null;
	String mid = null;
	
	String[][] unallocatedSites = null;
	String[][] projectsForAssigning = null;
	String[][] builderPerformance = null;
	
	public ManagerGui(String username){
		ManagerWindow = new JFrame("Manager");
		ImageIcon img = new ImageIcon("src/Construction.jpg");
		JLabel background = new JLabel("",img,JLabel.CENTER);
		mid = username;
		m = new Manager(mid);
		
		SelectUnallocatedSites t1 = new SelectUnallocatedSites();
		ViewProjectsForAssigning t2 = new ViewProjectsForAssigning(mid);
		BuilderPerformanceTracking t3 = new BuilderPerformanceTracking(mid);
		t1.run();
		t2.run();
		t3.run();
		
		try {
			
			t1.join();
			t2.join();
			t3.join();
		}
		
		catch(InterruptedException e)
		{
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		
		unallocatedSites = t1.unallocatedSites;
		projectsForAssigning = t2.projectsForAssigning;
		builderPerformance = t3.builderPerformance;
		
		JLabel user = new JLabel("Welcome! "+ m.name);
		user.setBounds(15,7,250,12);
		user.setForeground(Color.red);
		user.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ManagerWindow.add(user);
		
		JLabel userType = new JLabel("Manager");
		userType.setBounds(365,5,200,20);
		userType.setForeground(Color.DARK_GRAY);
		userType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ManagerWindow.add(userType);
		
		exit = new JButton("Exit");
		exit.setBounds(690,7,90,18);
		exit.setForeground(Color.red);
		exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		ManagerWindow.add(exit);
		
		JPanel p1 = new JPanel();
		p1.setBounds(10,30,380,270);
		p1.setBackground(new Color(102, 179, 255));
		ManagerWindow.add(p1);
		
		project1 = new JTextField("");
		project1.setBounds(20,52,200,20);
		project1.setForeground(Color.GRAY);
		project1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		p1.add(project1);
		
		JLabel projectid1 = new JLabel("Project ID");
		projectid1.setBounds(15,30,200,20);
		projectid1.setForeground(Color.DARK_GRAY);
		projectid1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		p1.add(projectid1);
		
		JLabel assignTo = new JLabel("Assign To");
		assignTo.setBounds(30,80,200,20);
		assignTo.setForeground(Color.DARK_GRAY);
		assignTo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		p1.add(assignTo);
		
		JLabel builderid2 = new JLabel("Builder ID");
		builderid2.setBounds(15,100,200,20);
		builderid2.setForeground(Color.DARK_GRAY);
		builderid2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		p1.add(builderid2);
		
		builder2 = new JTextField("");
		builder2.setBounds(20,120,200,20);
		builder2.setForeground(Color.GRAY);
		builder2.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		p1.add(builder2);
		
		assign = new JButton("Assign");
		assign.setBounds(120, 180, 120, 22);
		p1.add(assign);
		
		showBuilder2 = new JButton("Show all Builders");
		showBuilder2.setBounds(75, 230, 200, 22);
		p1.add(showBuilder2);
		
		JLabel assigneProject = new JLabel("Assign Project");
		assigneProject.setBounds(120,5,200,20);
		assigneProject.setForeground(Color.DARK_GRAY);
		assigneProject.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		p1.add(assigneProject);
		
		JPanel p2 = new JPanel();
		p2.setBounds(410,30,380,270);
		p2.setBackground(new Color(102, 179, 255));
		ManagerWindow.add(p2);
		
		project2 = new JTextField("");
		project2.setBounds(20,52,200,20);
		project2.setForeground(Color.GRAY);
		project2.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		p2.add(project2);
		
		JLabel projectid2 = new JLabel("Project ID");
		projectid2.setBounds(15,30,200,20);
		projectid2.setForeground(Color.DARK_GRAY);
		projectid2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		p2.add(projectid2);
		
		JLabel stat = new JLabel("Status");
		stat.setBounds(15,100,200,20);
		stat.setForeground(Color.DARK_GRAY);
		stat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		p2.add(stat);
		
		status = new JTextField("");
		status.setBounds(20,120,200,20);
		status.setForeground(Color.GRAY);
		status.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		p2.add(status);
		
		update = new JButton("Update");
		update.setBounds(120, 180, 120, 22);
		p2.add(update);
		
		showProjects = new JButton("Show all projects");
		showProjects.setBounds(75, 230, 200, 22);
		p2.add(showProjects);
		
		JLabel UpdateProject = new JLabel("Update Project Status");
		UpdateProject.setBounds(100,5,200,20);
		UpdateProject.setForeground(Color.DARK_GRAY);
		UpdateProject.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		p2.add(UpdateProject);
		
		JPanel p3 = new JPanel();
		p3.setBounds(410,310,380,270);
		p3.setBackground(new Color(102, 179, 255));
		ManagerWindow.add(p3);
		
		project3 = new JTextField("");
		project3.setBounds(20,52,200,20);
		project3.setForeground(Color.GRAY);
		project3.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		p3.add(project3);
		
		JLabel allocateTo = new JLabel("Allocate To");
		allocateTo.setBounds(30,80,200,20);
		allocateTo.setForeground(Color.DARK_GRAY);
		allocateTo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		p3.add(allocateTo);
		
		JLabel site = new JLabel("Site ID");
		site.setBounds(15,100,200,20);
		site.setForeground(Color.DARK_GRAY);
		site.setFont(new Font("Times New Roman", Font.BOLD, 18));
		p3.add(site);
		
		siteid = new JTextField("");
		siteid.setBounds(20,120,200,20);
		siteid.setForeground(Color.GRAY);
		siteid.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		p3.add(siteid);
		
		JLabel projectid3 = new JLabel("Project ID");
		projectid3.setBounds(15,30,200,20);
		projectid3.setForeground(Color.DARK_GRAY);
		projectid3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		p3.add(projectid3);
		
		allocate = new JButton("Allocate");
		allocate.setBounds(120, 180, 120, 22);
		p3.add(allocate);
		
		showSite = new JButton("Show all sites");
		showSite.setBounds(75, 230, 200, 22);
		p3.add(showSite);
		
		JLabel allocateProject = new JLabel("Allocate Project");
		allocateProject.setBounds(120,5,200,20);
		allocateProject.setForeground(Color.DARK_GRAY);
		allocateProject.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		p3.add(allocateProject);
		
		JPanel p4 = new JPanel();
		p4.setBounds(15,310,380,270);
		p4.setBackground(new Color(102, 179, 255));
		ManagerWindow.add(p4);
		
		builder1 = new JTextField("");
		builder1.setBounds(20,52,200,20);
		builder1.setForeground(Color.GRAY);
		builder1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		p4.add(builder1);
		
		JLabel builderid = new JLabel("Builder ID");
		builderid.setBounds(10,30,200,20);
		builderid.setForeground(Color.DARK_GRAY);
		builderid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		p4.add(builderid);
		
		JLabel sal = new JLabel("Salary Bonus");
		sal.setBounds(15,100,200,20);
		sal.setForeground(Color.DARK_GRAY);
		sal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		p4.add(sal);
		
		salary = new JTextField("");
		salary.setBounds(20,120,200,20);
		salary.setForeground(Color.GRAY);
		salary.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		p4.add(salary);
		
		pay = new JButton("Pay");
		pay.setBounds(130, 180, 80, 22);
		p4.add(pay);
		
		showBuilder1 = new JButton("Show all builders");
		showBuilder1.setBounds(75, 230, 200, 22);
		p4.add(showBuilder1);
		
		JLabel trackBuilder = new JLabel("Track Builder Performance");
		trackBuilder.setBounds(70,5,250,20);
		trackBuilder.setForeground(Color.DARK_GRAY);
		trackBuilder.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		p4.add(trackBuilder);
		
		background.setBounds(0,0,820,630);
		ManagerWindow.add(background);
		ManagerWindow.setSize(820,630);
		p1.setLayout(null);
		p2.setLayout(null);
		p3.setLayout(null);
		p4.setLayout(null);
		ManagerWindow.setLayout(null);
		ManagerWindow.setVisible(true);
		
		exit.addActionListener(this);
		
		assign.addActionListener(this);
		update.addActionListener(this);
		allocate.addActionListener(this);
		pay.addActionListener(this);
		
		showBuilder1.addActionListener(this);
		showBuilder2.addActionListener(this);
		showSite.addActionListener(this);
		showProjects.addActionListener(this);
	}
	

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(assign)) {
			m.assignProject(project1.getText(), builder2.getText());
			JFrame frame= new JFrame("Message");
			JOptionPane.showMessageDialog(frame, "Assigned Successfully!");
		}
		else if(e.getSource().equals(showBuilder2)) {
			JFrame frame= new JFrame("Builders");
			String[] columns = {"Pno","start_date","end_date","completion_status","city","state","Works_on"};
			JTable table = new JTable(projectsForAssigning,columns);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setSize(300,100);
			frame.add(scroll);
			frame.setSize(500,300);
			frame.setVisible(true);
		}
		else if(e.getSource().equals(showBuilder1)) {
			JFrame frame= new JFrame("Builders");
			String[] columns = {"Builder","project_no","total_hours"};
			JTable table = new JTable(builderPerformance,columns);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setSize(300,100);
			frame.add(scroll);
			frame.setSize(500,300);
			frame.setVisible(true);
		}
		else if(e.getSource().equals(showSite)) {
			JFrame frame= new JFrame("Sites");
			String[] columns = {"id","city","state","site_area_sqyards","site_terrain","soil_type"};
			JTable table = new JTable(unallocatedSites,columns);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setSize(300,100);
			frame.add(scroll);
			frame.setSize(500,300);
			frame.setVisible(true);
		}
		else if(e.getSource().equals(showProjects)) {
			JFrame frame= new JFrame("Projects");
			String[] columns = {"builder_id"," project_no","completion_status"};
			JTable table = new JTable(m.projectStatus(project2.getText()),columns);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setSize(300,100);
			frame.add(scroll);
			frame.setSize(500,300);
			frame.setVisible(true);
		}
		else if(e.getSource().equals(pay)) {
			m.giveSalaryBonus(builder1.getText(), Double.parseDouble(salary.getText()));
			JFrame frame= new JFrame("Message");
			JOptionPane.showMessageDialog(frame, "Paid Successfully!");
		}
		else if(e.getSource().equals(update)) {
			m.updateProjectStatus(project2.getText(),status.getText());
			JFrame frame= new JFrame("Message");
			JOptionPane.showMessageDialog(frame, "Updated Successfully!");
		}
		else if(e.getSource().equals(allocate)) {
			m.allocateProjects(project3.getText(), null, null, null, null, siteid.getText());
			JFrame frame= new JFrame("Message");
			JOptionPane.showMessageDialog(frame, "Allocated Successfully!");
		}
		else if(e.getSource().equals(exit)) {
			ManagerWindow.dispose();
		}
	}
}
