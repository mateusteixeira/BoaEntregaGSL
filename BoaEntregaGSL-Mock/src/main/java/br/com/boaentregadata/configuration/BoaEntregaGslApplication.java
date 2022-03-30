package br.com.boaentregadata.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class BoaEntregaGslApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaEntregaGslApplication.class, args);
	}

}
