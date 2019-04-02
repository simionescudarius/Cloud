package cloud.tema3.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DataSourceConfigurationD {
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
		dataSourceBuilder.url(
				"jdbc:mysql://google/cloudTema3?useSSL=false&cloudSqlInstance=complete-kite-236211:europe-north1:cloud-mysql-database&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=cloud-tema3-user&password=cloud-tema3-password");
		return dataSourceBuilder.build();
	}
}
