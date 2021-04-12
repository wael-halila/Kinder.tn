package tn.esprit.spring;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import tn.esprit.spring.chaat.services.ChatbotUtilService;




@SpringBootApplication
@EnableAutoConfiguration
public class Kindergarten implements CommandLineRunner{
	@Autowired
	ChatbotUtilService chatbot;
	
	public static void main(String[] args) {
		SpringApplication.run(Kindergarten.class, args);
	
	
	}
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setLocation("./uploads");
		return factory.createMultipartConfig();
	}
	public void run(String... args) throws Exception {
		chatbot.getBotResponseforConsole();
	}


	
}
