
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public Main() {
		super();

		try {
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=password");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fName = request.getParameter("Fname");
		String lName = request.getParameter("Lname");

		if (!isValid(fName, lName)) {
			PrintWriter writer = response.getWriter();
			writer.println("Inputs cannot be empty!");
			return;
		}

		executeSQL("CREATE DATABASE IF NOT EXISTS mydatabase");
		executeSQL("USE mydatabase");
		executeSQL("CREATE TABLE IF NOT EXISTS simple( fname char(30), lname char(30) )");
		executeSQL(String.format("INSERT INTO simple VALUES('%s', '%s')", fName, lName));

		printTable(response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean isValid(String name, String password) {
		if (name == null || name == "") {
			return false;
		}

		if (password == null || password == "") {
			return false;
		}

		return true;
	}

	private final void executeSQL(String statement) {
		try {
			Statement stm = connection.createStatement();
			stm.execute(statement);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private final void printTable(HttpServletResponse response) {
		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM simple ORDER BY lname");
			
			PrintWriter writer = response.getWriter();
			while (rs.next()) {
				writer.println(String.format("%s %s", rs.getString(1), rs.getString(2)));
			}
			
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}