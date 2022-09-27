package academy.digitallab.com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServicieApplication {


	public static void main(String[] args) {
		SpringApplication.run(ConfigServicieApplication.class, args);
	}

}
