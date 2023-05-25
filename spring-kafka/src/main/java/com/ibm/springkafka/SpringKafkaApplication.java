package com.ibm.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class SpringKafkaApplication {

	@Autowired
	private KafkaProducerService kps;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}
	
	@GetMapping("/")
	public String hi() {
		return "Hi from spring boot"; 
	}
	
	// http://localhost:8080/message/testing 
	@GetMapping("/message/{message}")
	public String postMessageToKafka( 
			@PathVariable String message) {
		// you to call kafka producer with message to send 
		kps.sendMessage(message, "first-topic");
		return "message send " + message; 
	}

}
