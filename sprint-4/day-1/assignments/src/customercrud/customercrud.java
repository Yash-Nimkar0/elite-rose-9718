package customercrud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class customercrud {
	static Connection getconn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		return DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
		
	}
	static void closeconn(Connection conn) throws SQLException {
		if(conn!=null) {
			conn.close();
		}
	}
	static void add(Scanner sc) {
		Connection conn= null;
		try {
			conn =getconn();
			
			
			
			String query="INSERT into customer (customerId,name,gender,wallet_balance,date_of_joining) values (?,?,?,?,?)";
			
			PreparedStatement ps =conn.prepareStatement(query);
			
			System.out.println("Enter id");
			String id=sc.next();
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter gender");
			String gender=sc.next();
			System.out.println("Enter balance");
			Double bal=sc.nextDouble();
			System.out.println("Enter date");
			LocalDate date=LocalDate.parse(sc.next());
			
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setDouble(4, bal);
			ps.setDate(5, Date.valueOf(date));
			
			if(ps.executeUpdate()>0) {
				System.out.println("sucess");
			}
			else {
				System.out.println("no");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("0 exit");
			System.out.println("1 add");
			System.out.println("2 view");
			System.out.println("3 update");
			System.out.println("4 del");
			System.out.println("5 search");
			System.out.print("Enter sel");
			
			choice =sc.nextInt();
			
			switch(choice) {
			case 1:
				add(sc);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				System.out.println("bye");
				break;
			default:
				System.out.println("Invalid");
				break;
			}
		}while(choice!=0);
		sc.close();
	}
	
	
	
}
