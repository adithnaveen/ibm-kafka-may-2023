package com.ibm.springkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerService {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class); 
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate; 
	
	public void sendMessage (String message, String topic) {
		logger.info("Sending payload of {}, to topic {}", message, topic) ;
		kafkaTemplate.send(topic, message); 
	}
	
}
