package com.ibm.wiki;

import java.net.URI;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

public class WikiMediaChangesProducerExample {

	private static final Logger logger = LoggerFactory.getLogger(WikiMediaChangesProducerExample.class.getName());

	public static void main(String[] args) throws InterruptedException {
		final String URL = "https://stream.wikimedia.org/v2/stream/recentchange";
		final String topic = "mediawiki.recentchange";
		final String bootstrapServer = "localhost:9092";

		Properties prop = new Properties();
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		KafkaProducer<String, String> producer = new KafkaProducer<>(prop);
		
		// the even handler will help me to trigger when event occurs 
		// especially on onMessage 
		EventHandler eventHandler = new WikiMediaEventHandler(producer, topic); 
		
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(URL)); 
		// to create variable - Ctrl + 2 + l 
		EventSource eventSource = builder.build(); 
		
		eventSource.start(); 
		
		TimeUnit.MINUTES.sleep(10);
	}
}
