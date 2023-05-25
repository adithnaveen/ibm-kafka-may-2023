package com.ibm.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaProducer1 {

	private String topic ="first-topic"; 
	
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class.getName());
	
	public String postMessage(String message) {
		//post it to kafka 
		
		final String host = "localhost"; // 127.0.0.1 or ip address 
		final String port = "9092"; 
		
		// set all properties needed 
		Properties prop = new Properties(); 
		// or your key can be -> "bootstrap.servers"
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, host +":" + port); 
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); 
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); 
		
		// creating a producer 
		KafkaProducer<String, String> producer = new KafkaProducer<>(prop);
		
		// creating a producer record 
		ProducerRecord<String, String> producerRecord = 
				new ProducerRecord<String, String>(topic, message); 
		
		producer.send(producerRecord);
		logger.info("Data posted to kafka Successfully : {}", message);
		
		producer.flush();
		producer.close(); 
		return message; 
	}
	
}
