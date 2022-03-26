package br.com.boaentrega.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

@Configuration(proxyBeanMethods=false)
@ConditionalOnClass(value={com.mongodb.client.MongoClient.class,org.springframework.data.mongodb.core.MongoTemplate.class})
@EnableConfigurationProperties(value= MongoProperties.class)
@AutoConfigureAfter(value= MongoAutoConfiguration.class)
public class MongoConfiguration {

//    private static final Logger LOG = LoggerFactory.getLogger(MongoConfiguration.class);
//
//    private final Environment environment;
//
//    public MongoConfiguration(Environment environment) {
//        this.environment = environment;
//    }
//
//
//    @Bean
//    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
//        String mongoHost = environment.getProperty("boaentrega.mongodb.host");
//        String mongoPort = environment.getProperty("boaentrega.mongodb.port");
//        String mongoDatabase = environment.getProperty("boaentrega.mongodb.database");
//        ServerAddress address = new ServerAddress(mongoHost, Integer.parseInt(mongoPort));
//        MongoClientOptions options = MongoClientOptions.builder().alwaysUseMBeans(true).build();
//        LOG.info("Inicializando conexão com o Mongo DB no endereço: " + address);
//        MongoClient client = new MongoClient(address, options);
//        LOG.info("Configurando aplicação para utilizar a database " + mongoDatabase);
//        return new SimpleMongoDbFactory(client, mongoDatabase);
//    }
//
//    public MongoFactoryBean mongo() {
//        MongoFactoryBean mongo = new MongoFactoryBean();
//        mongo.setHost(env.getProperty("db.host"));
//        mongo.setPort(env.getProperty("db.port",Integer.class,27017));
//        return mongo;
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws UnknownHostException {
//        return new MongoTemplate(this.mongoDbFactory());
//    }
}
