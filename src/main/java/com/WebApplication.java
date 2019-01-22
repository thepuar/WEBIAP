package com;

import com.rabbit.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@ComponentScan
@EnableJpaRepositories("com.repository")
public class WebApplication extends SpringBootServletInitializer{
    
  
    
     @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplication.class);
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(WebApplication.class, args);
                
	}
        

}

