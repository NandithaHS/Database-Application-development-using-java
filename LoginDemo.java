import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;


public class LoginDemo implements ActionListener
{
	JFrame f;
	JPanel p;
	JLabel lab1,lab2,lab3,lab4,lab5,lab6,lab7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2;
	
	public LoginDemo() 
	{
		f = new JFrame("Login Form");
		p = new JPanel();
		p.setLayout(null);
		
		lab1 = new JLabel("SSN");
		lab1.setBounds(50, 60, 80, 20);
		
		lab2 = new JLabel("Name");
		lab2.setBounds(50, 100, 80, 20);

		lab3 = new JLabel("Address");
		lab3.setBounds(50, 140, 80, 20);
		
		lab4 = new JLabel("Sex");
		lab4.setBounds(50, 180, 80, 20);

		lab5 = new JLabel("Salary");
		lab5.setBounds(50, 220, 80, 20);
		
		lab6 = new JLabel("Superssn");
		lab6.setBounds(50, 260, 80, 20);

		lab7 = new JLabel("Dno");
		lab7.setBounds(50, 300, 80, 20);
				
		
		t1 = new JTextField();
		t1.setBounds(130, 60, 80, 20);
		
		t2 = new JTextField();
		t2.setBounds(130, 100, 80, 20);
		
		t3 = new JTextField();
		t3.setBounds(130, 140, 80, 20);

		t4 = new JTextField();
		t4.setBounds(130, 180, 80, 20);
		
		t5 = new JTextField();
		t5.setBounds(130, 220, 80, 20);
		
		t6 = new JTextField();
		t6.setBounds(130, 260, 80, 20);
		
		t7 = new JTextField();
		t7.setBounds(130, 300, 80, 20);
	
		b1 = new JButton("Submit");
		b1.setBounds(90,350, 150, 25);
		b2 = new JButton("Reset");
		b2.setBounds(180, 380, 150, 25);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		p.add(lab1);
		p.add(lab2);
		p.add(lab3);
		p.add(lab4);
		p.add(lab5);
		p.add(lab6);
		p.add(lab7);
		p.add(t1);
		p.add(t2);
		p.add(t3);
		p.add(t4);
		p.add(t5);
		p.add(t6);
		p.add(t7);
		p.add(b1);
		p.add(b2);
		
		f.add(p);
		f.setSize(400, 500);
		f.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		new LoginDemo();
	}


	
	public void actionPerformed(ActionEvent e) 
	{
		
		String SSN= t1.getText();
		String Name= t2.getText();
		String Address= t3.getText();
		String Sex= t4.getText();
		String Salary= t5.getText();
		String Superssn= t6.getText();
		String Dno= t7.getText();
		
		
		if(e.getSource()==b1)
		{
		

			try{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Company","root",""); 
			
			 
			System.out.println("connected");
			String sql = "insert into employee values('"+SSN+"','"+Name+"','"+Address+"','"+Sex+"','"+Salary+"','"+Superssn+"','"+Dno+"')";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null, "Login is Successfull!!!");
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		if(e.getSource()==b2)
		{
			
			
		}
	}


	
}





