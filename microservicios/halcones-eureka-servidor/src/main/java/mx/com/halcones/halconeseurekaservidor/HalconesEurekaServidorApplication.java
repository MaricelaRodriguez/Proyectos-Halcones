package mx.com.halcones.halconeseurekaservidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HalconesEurekaServidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HalconesEurekaServidorApplication.class, args);
	}
}
