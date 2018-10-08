package com.cities.service.consumer.async;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.cities.service.KafkaServerProperties;

public class CitiesConsumerAsyncCommit {

	public static void main(String[] args) {
		Properties properties = KafkaServerProperties.getConsumerProperties(false);
		
		try (KafkaConsumer<String, String> consumer = new KafkaConsumer<String,
				String>(properties)) {
			consumer.subscribe(Collections.singletonList("cities"));

			while(true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
				
				records.forEach(record -> {
					System.out.println(record.key() + " - " + record.value());
				});
				
				consumer.commitAsync((offsets, exception) -> {
					if(exception != null) {
						exception.printStackTrace();
					}					
				});
			}
		}
	}
}