
import java.sql.*;
import java.io.*;

public class CallableStatementDemo1 {
	Connection con;
	CallableStatement clmt;

	public CallableStatementDemo1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/test?user=root&password=root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This method use proc1 procedure
	// proc1 display average salary of employee from EMP table
	public void callProcedure1() {
		try {
			clmt = con.prepareCall("{call proc1}");
			ResultSet res = clmt.executeQuery();
			if (res.next()) {
				System.out.println(res.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This method use proc2 procedure
	// It displays the whole records from Emp table
	public void callProcedure2() {
		try {
			clmt = con.prepareCall("{call proc2}");
			ResultSet res = clmt.executeQuery();
			while (res.next()) {
				System.out.println(res.getString(1) + "\t" + res.getString(2)
						+ "\t" + res.getString(3) + "\t" + res.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// call procedure proc3 with two IN parameters and store in emp table
	public void callProcedure3(String code, String name) {
		try {
			clmt = con.prepareCall("{call proc3(?,?)}");
			clmt.setString(1, code);
			clmt.setString(2, name);
			int i = clmt.executeUpdate();
			if (i != 0)
				System.out.println("Inserted successfully");
			else
				System.out.println("Not Inserted");
		} catch (Exception e) {
		}
	}

	// procedure with one in and one out parameter
	// It takes emp code as parameter and return emp name as output parameter
	public void callProcedure4(String code) {
		try {
			clmt = con.prepareCall("{call proc4(?,?)}");
			clmt.setString(1, code);
			clmt.registerOutParameter(2, Types.VARCHAR);
			clmt.execute();
			System.out.println(clmt.getString(2));
		} catch (Exception e) {
		}
	}

	// proc5 procedure takes one IN parameter and return value in OUT parameter
	// It uses single INOUT parameter for both purpose
	public void callProcedure5(String var1) {
		try {
			clmt = con.prepareCall("{call proc5(?)}");
			clmt.registerOutParameter(1, Types.VARCHAR);
			clmt.setString(1, var1);
			clmt.execute();
			System.out.println(clmt.getString(1));
		} catch (Exception e) {
		}
	}

	public void displayMenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		try {
			while (true) {
				System.out
						.println("========== Stored Procedure Example in Java ==========\n"
								+ "1. Stored procedure without any parameter\n"
								+ "2. Stored procedure that return records from table \n"
								+ "3. Stored procedure with two IN parameter\n"
								+ "4. Stored procedure with one IN and OUT parameter \n"
								+ "5. Stored procedure with INOUT parameter\n"
								+ "6. EXit \n" + "Enter Choice");
				choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1: {
					callProcedure1();
					break;
				}
				case 2: {
					callProcedure2();
					break;
				}
				case 3: {
					System.out.println("Enter employee code ");
					String code = br.readLine();
					System.out.println("Enter employee name ");
					String name = br.readLine();
					callProcedure3(code, name);
					break;
				}
				case 4: {
					System.out.println("Enter employee code to get name");
					String code = br.readLine();
					callProcedure4(code);
					break;
				}
				case 5: {
					System.out.println("Enter employee code to get name");
					String code = br.readLine();
					callProcedure5(code);
					break;
				}
				default: {
					System.out.println("Invalid choice");
				}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
// main method
	public static void main(String args[]) {
		CallableStatementDemo1 obj = new CallableStatementDemo1();
		obj.displayMenu();
		}
}