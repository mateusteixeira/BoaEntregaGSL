package br.com.boaentregadata.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("br.com.boaentregadata")
@PropertySource("classpath:application.properties")
public class BoaEntregaGslDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaEntregaGslDataApplication.class, args);
	}

}
