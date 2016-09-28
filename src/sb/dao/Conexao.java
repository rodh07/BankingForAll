package sb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	private static final String url_Banco = "jdbc:postgresql://localhost:5432/BankingForAll";
	// private static final String driver_Class = "org.postgresql.Driver";
	private static final String user = "postgres";
	private static final String pass = "rod123";

	public static ResultSet rs;
	public Statement stmt;
	public Connection con;

	public static Connection getConnection() {

		System.out.println("Conectando ao banco de dados");

		try {
			// Class.forName(driver_Class);
			return DriverManager.getConnection(url_Banco, user, pass);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public static void close(ResultSet set, Statement stmt, Connection conn) {
		try {
			if (set != null && !set.isClosed())
				set.close();
			if (stmt != null && !stmt.isClosed())
				stmt.close();
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
