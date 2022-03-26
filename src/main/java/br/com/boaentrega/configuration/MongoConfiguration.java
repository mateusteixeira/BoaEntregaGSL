package br.com.boaentrega.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

@Configuration
public class MongoConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(MongoConfiguration.class);

    public MongoConfiguration() {
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        ServerAddress address = new ServerAddress(this.marketplaceConfig.getMongo().getHost(), this.marketplaceConfig.getMongo().getPort());
        MongoClientOptions options = MongoClientOptions.builder().alwaysUseMBeans(true).build();
        LOG.info("Inicializando conexão com o Mongo DB no endereço: " + address);
        MongoClient client = new MongoClient(address, options);
        LOG.info("Configurando aplicação para utilizar a database " + this.marketplaceConfig.getMongo().getDatabase());
        return new SimpleMongoDbFactory(client, this.marketplaceConfig.getMongo().getDatabase());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(this.mongoDbFactory());
    }
}
