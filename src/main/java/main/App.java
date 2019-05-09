package main;


//import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.PropertySource;

//@PropertySource(value= {"classpath:application.properties"})

@SpringBootApplication
public class App {

//		public static final Logger logger = Logger.getLogger(App.class.getName());
		
		public static void main(String[] args) {
			
//			logger.info("Starting Application...");
			SpringApplication.run(App.class, args);
			
		}
	
}
