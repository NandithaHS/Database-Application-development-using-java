
import java.sql.*;
import java.util.Scanner;  
class MysqlConj{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/company","root","");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement(); 

Scanner k = new Scanner(System.in); 
System.out.println("Enter SSN"); 
String SSN = k.next(); 
System.out.println("Enter Name"); 
String Name = k.next(); 
System.out.println("Enter Address"); 
String Address = k.next(); 
System.out.println("Enter Sex"); 
String Sex = k.next(); 
System.out.println("Enter Salary"); 
int Salary = k.nextInt(); 
System.out.println("Enter Superssn"); 
String Superssn = k.next(); 
System.out.println("Enter Dno"); 
int Dno = k.nextInt(); 

//Inserting data using SQL query 
String sql = "insert into employee values('"+SSN+"','"+Name+"','"+Address+"','"+Sex+"',"+Salary+",'"+Superssn+"',"+Dno+")"; 

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

ResultSet rs=stmt.executeQuery("select *,Salary+Salary*0.1 as RSalary from employee where Dno=101");  
while(rs.next())  
System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5)+"  "+rs.getString(6)+"  "+rs.getInt(7)+" "+rs.getInt(8));  
con.close();  
}
catch(Exception e)
{
	System.out.println(e);
}  
}  
}  



