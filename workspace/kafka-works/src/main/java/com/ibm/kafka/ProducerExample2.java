package com.ibm.kafka;

import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerExample2 {
	
	private static final Logger logger = LoggerFactory.getLogger(ProducerExample2.class.getName());
	
	public static void main(String[] args) {
		logger.info("Hi I'm from slf4j");
		
		
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
				new ProducerRecord<String, String>("topic-with-partition1", "Message From Java"); 
		
		// you are attaching the producer record to producer 
		producer.send(producerRecord, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				if(exception == null) {
					
					logger.info("Message Sent" );
					
					logger.info(
							" Topic "+ metadata.topic() +
							" Partition " + metadata.partition() + 
							" Time Stamp "+ new Date(metadata.timestamp())
						); 
					
					
				}else {
					logger.error("Message delevery failed, {}", exception);
				}
			}
		});
		
//		tell the producer to send all data and block until done - synchronous 
		producer.flush(); 
		
		// close the connection 
		producer.close(); 
	 
	}
}







