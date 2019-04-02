package cloud.tema3.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static Connection getMySQLDatabaseConnection(String connectionName, String databaseName, String username,
			String password) throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.GoogleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String jdbcUrl = String.format("jdbc:mysql://google/%s?cloudSqlInstance=%s&"
				+ "socketFactory=com.google.cloud.sql.mysql.SocketFactory", databaseName, connectionName);

		Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
		return connection;
	}
}
