package cloud.tema3;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cloud.tema3.configuration.DatabaseConnection;

@SpringBootApplication
public class Tema3Application {

	public static void main(String[] args) {
		SpringApplication.run(Tema3Application.class, args);
		testDatabase();
	}
	
	public static void testDatabase() {
		String connectionName = "complete-kite-236211:europe-north1:cloud-mysql-database";
		String databaseName = "cloud-mysql-database";
		String username = "cloud-tema3-user";
		String password = "cloud-tema3-password";
		try {
			DatabaseConnection.getMySQLDatabaseConnection(connectionName, databaseName, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
