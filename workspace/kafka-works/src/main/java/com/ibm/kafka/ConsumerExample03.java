package com.ibm.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerExample03 {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerExample03.class.getName()); 

	public static void main(String[] args) {

		final String host = "localhost"; // 127.0.0.1 or ip address 
		final String port = "9092"; 
		
		
		Properties props = new Properties(); 
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, host +":"+port);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()); 
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()); 
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "first-application");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props); 
		consumer.subscribe(Arrays.asList("topic-with-partition1"));
		
		while(true) {
			logger.info("--------- Polling --------------");
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
			
			for(ConsumerRecord<String, String> record : records) {
				logger.info(
							" Key " + record.key() + 
							" Value " + record.value() + 
							" Partition " + record.partition() + 
							" Offset " + record.offset() + 
							" Value Size " + record.serializedValueSize()
						);
			}
		}
	}
}









