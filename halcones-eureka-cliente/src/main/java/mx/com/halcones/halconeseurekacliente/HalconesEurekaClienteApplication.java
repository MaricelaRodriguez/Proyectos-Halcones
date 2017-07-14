package mx.com.halcones.halconeseurekacliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HalconesEurekaClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(HalconesEurekaClienteApplication.class, args);
	}
}
