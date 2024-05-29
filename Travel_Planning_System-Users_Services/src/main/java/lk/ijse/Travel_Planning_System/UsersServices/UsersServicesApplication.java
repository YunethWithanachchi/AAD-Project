package lk.ijse.Travel_Planning_System.UsersServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class UsersServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersServicesApplication.class, args);
	}

}
