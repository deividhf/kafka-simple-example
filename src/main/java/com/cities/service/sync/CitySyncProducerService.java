package com.cities.service.sync;

import static com.cities.service.KafkaServerProperties.getProperties;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import com.cities.resource.CityDTO;

@Service
public class CitySyncProducerService {

	public void send(CityDTO city) {
		Properties properties = getProperties();
		
		try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
			ProducerRecord<String, String> record = new ProducerRecord<>("cities", city.getState(), city.getName());
			
			producer.send(record).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
