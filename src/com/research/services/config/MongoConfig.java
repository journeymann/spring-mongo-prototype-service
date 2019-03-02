package com.research.services.config;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.MongoClient;

@EnableMongoRepositories(basePackages="com.research.services.locator.repositories")
public class MongoConfig {
	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "mydata");
	}
	public @Bean MongoTemplate mongoTemplate() throws Exception {
	      return new MongoTemplate(mongoDbFactory());
	}
}