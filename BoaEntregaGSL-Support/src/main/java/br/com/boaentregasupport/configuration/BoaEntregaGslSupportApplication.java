package br.com.boaentregasupport.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "br.com.boaentregasupport.domain")
@EnableJpaRepositories(basePackages = "br.com.boaentregasupport.repository")
@PropertySource("classpath:application.properties")
@ComponentScan("br.com.boaentregasupport")
public class BoaEntregaGslSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaEntregaGslSupportApplication.class, args);
	}

}
