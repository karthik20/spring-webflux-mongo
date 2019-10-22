package com.karthik.spring.spring4me.configuration;

import java.util.Collection;
import java.util.Collections;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

@Configuration
public class ApplicationDbConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singletonList("com.karthik.spring.spring4me.model");
    }

}