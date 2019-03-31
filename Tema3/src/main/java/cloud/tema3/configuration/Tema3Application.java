package cloud.tema3.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cloud.tema3")
@SpringBootApplication
public class Tema3Application {

	public static void main(String[] args) {
		SpringApplication.run(Tema3Application.class, args);
	}
}
