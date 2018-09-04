package com.cities.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cities.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityResource {

	private CityService cityService;

	public CityResource(CityService cityService) {
		this.cityService = cityService;
	}
	
	@PostMapping("/sync")
	public ResponseEntity<CityDTO> createSync(@RequestBody CityDTO citie) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cityService.createSync(citie));
	}
	
	@PostMapping("/async")
	public ResponseEntity<CityDTO> createAsync(@RequestBody CityDTO citie) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cityService.createAsync(citie));
	}
}
