package br.com.boaentrega.configuration;

import br.com.boaentrega.queues.Queues;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "br.com.boaentrega.domain")
@EnableJpaRepositories(basePackages = "br.com.boaentrega.domain")
@EnableMongoRepositories(basePackages = "br.com.boaentrega.domain.document")
@PropertySource("classpath:application.properties")
@ComponentScan("br.com.boaentrega")
public class BoaEntregaGslApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaEntregaGslApplication.class, args);
	}

	@Bean
	public Queue calculationQueue() {
		return new Queue(Queues.ESTIMATED_TIME_CALCULATION_IN_SGE_QUEUE, false);
	}

	@Bean
	public Queue registryQueue() {
		return new Queue(Queues.REGISTRY_WARE_HOUSE_IN_SGE_QUEUE, false);
	}
}
