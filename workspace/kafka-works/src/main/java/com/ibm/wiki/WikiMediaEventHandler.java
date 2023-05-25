package com.ibm.wiki;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikiMediaEventHandler implements EventHandler{

	private KafkaProducer<String, String> producer; 
	private String topic; 
	
	private static final Logger logger = LoggerFactory.getLogger(WikiMediaEventHandler.class.getName()); 
	
	
	public WikiMediaEventHandler(KafkaProducer<String, String> producer, String topic) {
		super();
		this.producer = producer;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		producer.close(); 
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		logger.info(messageEvent.getData());
		producer.send(new ProducerRecord<String, String>(topic, messageEvent.getData()));
		
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		logger.error("Error while Streaming " , t);
	}

}
