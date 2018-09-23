package com.cities.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cities.service.producer.async.CityAsyncProducer;
import com.cities.service.producer.sync.CitySyncProducer;

@RestController
@RequestMapping("/cities")
public class CityResource {

	private CityAsyncProducer cityAsyncProducer;
	private CitySyncProducer citySyncProducer;

	public CityResource(CityAsyncProducer cityAsync, CitySyncProducer citySyncProducer) {
		this.cityAsyncProducer = cityAsync;
		this.citySyncProducer = citySyncProducer;
	}
	
	@PostMapping("/sync")
	public ResponseEntity<CityDTO> sendSync(@RequestBody CityDTO citie) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(citySyncProducer.send(citie));
	}
	
	@PostMapping("/async")
	public ResponseEntity<CityDTO> sendAsync(@RequestBody CityDTO citie) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(cityAsyncProducer.send(citie));
	}
}
