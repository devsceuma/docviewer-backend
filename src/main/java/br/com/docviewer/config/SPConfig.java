package br.com.docviewer.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages={"br.com.docviewer"})
public class SPConfig {

	public @Bean Mongo mongo(){
		return new MongoClient("127.0.0.1",27017);
	}
	
	public @Bean MongoTemplate mongoTemplate() throws Exception{
		return new MongoTemplate(mongo(),"local");
	}
}
