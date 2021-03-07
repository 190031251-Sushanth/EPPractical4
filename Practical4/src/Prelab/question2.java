package Prelab;

import java.sql.*;

import java.util.Scanner;
public class question2 {

	public static void main(String[] args)  {
		Scanner s = new Scanner(System.in);
		  Statement stmt = null;
		//load Driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			190030061
			//Connection establishment
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"ep",
					"ep123");
			System.out.println("Connection success!");
			CallableStatement csmt = conn.prepareCall("{call stu_pro(?,?,?)}");
			stmt = conn.createStatement();
			System.out.println("Enter Number of records to be inserted: ");
			 int n = s.nextInt();
			 for(int i=0; i<n; i++) {
				 System.out.println("Enter id,name,age to inserted into database");
				 long id = s.nextLong();
				 String name = s.next();
				 int age = s.nextInt();
				 csmt.setLong(1, id);
				 csmt.setString(2, name);
				 csmt.setInt(3, age);
				 csmt.execute();
				 System.out.println("Values inserted !");
			 }//			190030061
			 System.out.println("\n");
			 System.out.println("Query to student , age < 21");
			String sql = "SELECT * FROM student" + " WHERE age < 21 ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String name = rs.getString("name");
//					190030061
		         System.out.print("ID: " + id);
		         System.out.print(", Name: " + name);
		         System.out.print(", Age: " + age);
		         System.out.println("\n");
		      }
		      rs.close();
			 System.out.println("Execution completed!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//			190030061

}
