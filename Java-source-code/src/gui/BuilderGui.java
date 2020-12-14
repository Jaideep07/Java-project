package gui;

import actorClasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BuilderGui implements ActionListener {
	JButton update=null;
	JFrame builderWindow =null;
	JButton exit=null;
	Builder c;
	JFrame f;
	String p ;
	String str;
	JTextField status=null;
	JTextField id=null;
	BuilderGui()
	{
		
	}

	public BuilderGui(String username)
	{
		c= new Builder(username);
		builderWindow = new JFrame();
		ImageIcon img = new ImageIcon("src/Construction.jpg");
		JLabel background = new JLabel("",img,JLabel.CENTER);
		
		JLabel user = new JLabel("Welcome! "+c.name);
	    user.setBounds(10,7,250,12);
	    user.setForeground(Color.red);
	    user.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    builderWindow.add(user);
	    
	    exit = new JButton("Exit");
        exit.setBounds(900,7,90,18);
        exit.setForeground(Color.red);
        exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
        builderWindow.add(exit);
        exit.addActionListener(this);
		
		JLabel head=new JLabel("Ongoing Projects",JLabel.CENTER);
		head.setFont(new Font("Times New Roman", Font.BOLD, 25));
		head.setBounds(380, 30, 300, 40);
		builderWindow.add(head);
		
		JPanel middle = new JPanel();
		
		String data[][]= c.getProjects();
		String column[]= {"PROJECT NO","PROJECT NAME","STREET","CITY","STATE","ZIP-CODE"};
		JTable t=new JTable(data,column);
		t.setBounds(30,30,200,300);
		JScrollPane sp=new JScrollPane(t);
		middle.add(sp);
		
		middle.setBounds(268, 80, 500, 460);
		middle.setBackground(new Color(102,179,255));
		builderWindow.add(middle);
		
		update=new JButton("Update Project Status");
		update.setBounds(410, 570, 225, 40);
		builderWindow.add(update);
		update.addActionListener(this);
		
		builderWindow.add(background);
		builderWindow.setSize(1024,1024);
		builderWindow.setTitle("Builder");
		builderWindow.setVisible(true);
	}
	
	@SuppressWarnings("null")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource()==update)
		{
			f=new JFrame("Update");
			
			JLabel projectID = new JLabel("Project ID: ");
			projectID.setBounds(70,50,100,20);
			projectID.setFont(new Font("Times New Roman", Font.BOLD, 15));
			f.add(projectID);
			
			id = new JTextField("");
		    id.setBounds(200, 50, 100, 20);
		    f.add(id);
		    
			JLabel s = new JLabel("Status: ");
			s.setBounds(70,100,100,20);
			s.setFont(new Font("Times New Roman", Font.BOLD, 15));
			f.add(s);
			
			status = new JTextField("");
			status.setBounds(200,100,100,20);
			f.add(status);
			
			JButton enter =new JButton("Enter");
			enter.setBounds(150, 200,100, 20);
			f.add(enter);
			enter.addActionListener(this);
			
			
			f.setLayout(null);
			f.setSize(500, 500);
			f.setVisible(true);
			
		}
		else if(e.getSource()==exit)
		{
			builderWindow.dispose();
		}
		else
		{
			//f.dispose();
			JFrame frame= new JFrame("Message");
			JOptionPane.showMessageDialog(frame, "Updated Successfully!");
			p=id.getText();
			str=status.getText();
			
			c.updateProjectStatus(p, str);
			
		}
	}
		

//public static void main(String[] args) {
	// TODO Auto-generated method stub
	//new BuilderGui("B1");
	//}
}
