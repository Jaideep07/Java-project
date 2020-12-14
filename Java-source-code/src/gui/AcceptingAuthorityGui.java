package gui;

import actorClasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AcceptingAuthorityGui implements ActionListener {
	JFrame authorityWindow =null;
	JButton exit=null;
	JPanel p1=null;
	JPanel p2=null;
	JTextField tf1=null;
	JTextField tf2=null;
	JTextField tf3=null;
	JTextField tf4=null;
	JTextField tf5=null;
	JTextField tf6=null;
	JButton b1= new JButton("Assigns");
	JButton b2= new JButton("Assigns");
	AcceptingAuthority a=new AcceptingAuthority();
	AcceptingAuthorityGui()
	{
		authorityWindow = new JFrame();
		ImageIcon img = new ImageIcon("src/Construction.jpg");
		JLabel background = new JLabel("",img,JLabel.CENTER);
		
		exit = new JButton("Exit");
        exit.setBounds(900,7,90,18);
        exit.setForeground(Color.red);
        exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
        authorityWindow.add(exit);
        exit.addActionListener(this);
        
        p1=new JPanel(new BorderLayout());
        p2=new JPanel(new BorderLayout());
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        JLabel l3=new JLabel("Retailer Rating");
        JLabel l4=new JLabel("Sub Contracts");
        l3.setBounds(30, 5, 80, 50);
        l4.setBounds(30, 5, 80, 50);
        l3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        l4.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        String data1[][]= a.getRetailers(); 		// add code part and return
        String column1[]= {"Id","Name","State","Service Rating"};      			// add code part and return
        String data2[][]= a.viewSubcontracts(); 		// add code part and return 
        String column2[]= {"Site Id","Material Model","Material Name"};    			   	// add code part and return
        
        JTable t1=new JTable(data1,column1);
        JTable t2=new JTable(data2,column2);
        t1.setBounds(5,70,20,50);
		JScrollPane sp1=new JScrollPane(t1);
		sp1.setBounds(375, 30, 5, 250);
		t1.setBounds(10,60,350,150);
		JScrollPane sp2=new JScrollPane(t2);
		sp2.setBounds(375, 30, 5, 250);
		sp2.getViewport().add(t2);
		p1.add(sp1,BorderLayout.CENTER);
		p2.add(sp2,BorderLayout.CENTER);
        
        p3.add(l3);
        p4.add(l4);
        p1.setBounds(30, 90, 420, 350);
		p1.setBackground(new Color(102,179,255));
		p2.setBounds(540, 90, 420, 350);
		p2.setBackground(new Color(102,179,255));
		p3.setBounds(30, 60, 420, 30);
		p3.setBackground(new Color(102,179,255));
		p4.setBounds(540, 60, 420, 30);
		p4.setBackground(new Color(102,179,255));
		
		JPanel p5=new JPanel();
		JPanel p6=new JPanel();
		
		
		JLabel lb1=new JLabel("Assigns");
		JLabel lb2=new JLabel("Retailer Id:");
		JLabel lb3=new JLabel("To");
		JLabel lb4=new JLabel("Site Id:");
		JLabel lb5=new JLabel("Assigns");
		JLabel lb6=new JLabel("Subcontract Id:");
		JLabel lb7=new JLabel("To");
		JLabel lb8=new JLabel("Project Id:");
		
		JLabel lb9=new JLabel("Material Model:");
		JLabel lb10=new JLabel("Material Name:");
		
		tf1=new JTextField("");
		tf2=new JTextField("");
        tf1.setBounds(220, 490, 100, 20);
        tf2.setBounds(220, 550, 100, 20);
        tf3=new JTextField("");
		tf4=new JTextField("");
		tf3.setBounds(730, 490, 100, 20);
        tf4.setBounds(730, 550, 100, 20);
        tf5=new JTextField("");
        tf6=new JTextField("");
        tf5.setBounds(220, 575, 100, 20);
        tf6.setBounds(220, 600, 100, 20);
        
        
		lb1.setBounds(80, 460, 100, 20);
		lb2.setBounds(80, 490, 100, 20);
		lb3.setBounds(80, 520, 100, 20);
		lb4.setBounds(80, 550, 100, 20);
		lb9.setBounds(80, 575, 120, 20);
		lb10.setBounds(80, 600, 120, 20);
		lb1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		lb5.setBounds(600, 460, 100, 20);
		lb6.setBounds(600, 490, 150, 20);
		lb7.setBounds(600, 520, 100, 20);
		lb8.setBounds(600, 550, 100, 20);
		lb5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		b1.setBounds(160, 625, 100, 30);
		b2.setBounds(700, 600, 100, 30);

		authorityWindow.add(lb1);
		authorityWindow.add(lb2);
		authorityWindow.add(lb3);
		authorityWindow.add(lb4);
		authorityWindow.add(lb9);
		authorityWindow.add(lb10);
		authorityWindow.add(tf1);
		authorityWindow.add(tf2);
		authorityWindow.add(tf5);
		authorityWindow.add(tf6);
		
		authorityWindow.add(lb5);
		authorityWindow.add(lb6);
		authorityWindow.add(lb7);
		authorityWindow.add(lb8);
		authorityWindow.add(tf3);
		authorityWindow.add(tf4);
		
		authorityWindow.add(b1);
		authorityWindow.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		p5.setBounds(30, 440, 420, 220);
		p5.setBackground(new Color(102,179,255));
		p6.setBounds(540, 440, 420, 220);
		p6.setBackground(new Color(102,179,255));
		
		authorityWindow.add(p1);
		authorityWindow.add(p2);
		authorityWindow.add(p3);
		authorityWindow.add(p4);
		
		authorityWindow.add(p5);
		authorityWindow.add(p6);
		
		authorityWindow.add(background);
		//authorityWindow.setLayout(null);
		authorityWindow.setSize(1024,1024);
		authorityWindow.setTitle("Accepting Authority");
		authorityWindow.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AcceptingAuthorityGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exit)
		{
			authorityWindow.dispose();
		}
		else if(e.getSource()==b1)
		{
			String rId=tf1.getText();
			String siteId=tf2.getText();
			String materialModel=tf5.getText();
			String materialName=tf6.getText();
			a.approveRawMaterial(rId, siteId, materialModel, materialName);
			JFrame frame= new JFrame("Message");
			JOptionPane.showMessageDialog(frame, "Assigned Successfully!");
		}
		else if(e.getSource()==b2)
		{
			String pId=tf4.getText();
			a.approveSubcontracts(pId);
			JFrame frame1= new JFrame("Message");
			JOptionPane.showMessageDialog(frame1, "Assigned Successfully!");
		}
		
	}

}
