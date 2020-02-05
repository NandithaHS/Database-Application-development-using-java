
import java.sql.*;
import java.util.Scanner;  
class MysqlCon{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/java","root","");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement(); 

Scanner k = new Scanner(System.in); 
System.out.println("enter ID"); 
int id = k.nextInt(); 
System.out.println("enter Name"); 
String name = k.next(); 
System.out.println("enter Age"); 
int age = k.nextInt(); 

//Inserting data using SQL query 
String sql = "insert into emp values("+id+",'"+name+"',"+age+")"; 

try
{ 
	
	//Reference to connection interface 
	Statement st = con.createStatement(); 
	int m = st.executeUpdate(sql); 
	if (m == 1) 
		System.out.println("inserted successfully : "+sql); 
	else
		System.out.println("insertion failed"); 
} 
catch(Exception ex) 
{ 
	System.err.println(ex); 
}

ResultSet rs=stmt.executeQuery("select * from emp");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}  



