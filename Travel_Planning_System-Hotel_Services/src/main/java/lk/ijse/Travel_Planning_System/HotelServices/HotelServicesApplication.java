package lk.ijse.Travel_Planning_System.HotelServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HotelServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServicesApplication.class, args);
	}

}
