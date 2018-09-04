package com.cities.service;

import org.springframework.stereotype.Service;

import com.cities.resource.CityDTO;
import com.cities.service.async.CityAsyncProducerService;
import com.cities.service.sync.CitySyncProducerService;

@Service
public class CityService {

	private CitySyncProducerService syncProducerService;
	private CityAsyncProducerService asyncProducerService;

	public CityService(CitySyncProducerService producerService, CityAsyncProducerService asyncProducerService) {
		this.syncProducerService = producerService;
		this.asyncProducerService = asyncProducerService;
	}
	
	public CityDTO createSync(CityDTO city) {
		syncProducerService.send(city);
		return city;			
	}
	
	public CityDTO createAsync(CityDTO city) {
		asyncProducerService.send(city);
		return city;			
	}

}
