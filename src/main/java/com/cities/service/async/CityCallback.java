package com.cities.service.async;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class CityCallback implements Callback {

	@Override
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		if (exception != null) {
			exception.printStackTrace();
		}
		
		System.out.println("Topic: " + metadata.topic() + " - Partition " +  metadata.partition());
	}

}
