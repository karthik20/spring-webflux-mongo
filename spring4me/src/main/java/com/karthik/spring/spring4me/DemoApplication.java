package com.karthik.spring.spring4me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// MongoClient mongoClient = com.mongodb.client.MongoClients.create();
		// MongoOperations mongoOps = new MongoTemplate(mongoClient, "test");
		// var items = mongoOps.getCollection("employees").find(eq("name", "Karthik"));
		// log.info("{}", items.first());
	}

}
