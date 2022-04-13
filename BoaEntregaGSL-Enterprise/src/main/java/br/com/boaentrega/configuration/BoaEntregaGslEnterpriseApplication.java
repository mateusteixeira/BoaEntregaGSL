package br.com.boaentrega.configuration;

import br.com.boaentrega.queues.Queues;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "br.com.boaentrega.domain")
@EnableJpaRepositories(basePackages = "br.com.boaentrega.repository")
@EnableMongoRepositories(basePackages = "br.com.boaentrega.repository")
@PropertySource("classpath:application.properties")
@ComponentScan("br.com.boaentrega")
public class BoaEntregaGslEnterpriseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaEntregaGslEnterpriseApplication.class, args);
	}

	@Bean
	public Queue calculationQueue() {
		return new Queue(Queues.ESTIMATED_TIME_CALCULATION_IN_SGE_QUEUE, false);
	}

	@Bean
	public Queue registryQueue() {
		return new Queue(Queues.REGISTRY_WARE_HOUSE_IN_SGE_QUEUE, false);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
