package com.cities.service;

import java.util.Properties;

public class KafkaServerProperties {

	public static Properties getProducerProperties() {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		return properties;
	}
	
}
