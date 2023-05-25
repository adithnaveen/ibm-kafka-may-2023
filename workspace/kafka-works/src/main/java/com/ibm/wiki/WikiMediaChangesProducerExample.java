package com.ibm.wiki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WikiMediaChangesProducerExample {
	
	private static final Logger logger = LoggerFactory.getLogger(WikiMediaChangesProducerExample.class.getName());
	
	public static void main(String[] args) {
		final String  URL = "https://stream.wikimedia.org/v2/stream/recentchange"; 
		final String topic ="mediawiki.recentchange"; 
		final String bootstrapServer ="localhost:9092"; 
	}
}
