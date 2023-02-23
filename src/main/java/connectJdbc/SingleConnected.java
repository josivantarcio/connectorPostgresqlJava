package connectJdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnected {

	private static String urlDb = "jdbc:postgresql://localhost:5432/db_execTestJdbc"; // conexao ao banco postgresql
	private static Connection connection = null;

	private static String user = "postgres";
	private static String password = "admin";

	static {
		connect();
	}

	public SingleConnected() {
		connect();
	}

	private static void connect() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(urlDb, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conexao Realizada com Sucesso!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
