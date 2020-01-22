package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.InternalServerException;
import com.demo.model.ContinentEntity;
import com.demo.service.ContinentService;

@EnableAutoConfiguration
@RestController
public class ContinentController {
	@Autowired
	ContinentService service;
	
	// Needed to create the Continent API
	@RequestMapping(value = "/createContinent", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ContinentEntity> createContinent(@RequestBody ContinentEntity input)
			throws InternalServerException {

		try {
			ContinentEntity ContinentEntity = service.createContinent(input);
			return new ResponseEntity<ContinentEntity>(ContinentEntity, new HttpHeaders(), HttpStatus.CREATED);
		} catch (Exception ex) {
			throw new InternalServerException(ex.getMessage());
		}
	}
	
	// Not in use for now but adhoc functionality
	@RequestMapping(value = "/fetchContinentById", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ContinentEntity> fetchContinent(@RequestParam("id") Long id) throws InternalServerException {
		try {
			ContinentEntity listOfContinent = service.getContinentById(id);
			if (listOfContinent != null) {
				return new ResponseEntity<ContinentEntity>(listOfContinent, new HttpHeaders(), HttpStatus.OK);
			} else {
				return new ResponseEntity<ContinentEntity>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception ex) {
			throw new InternalServerException(ex.getMessage());
		}
	}
// Not in use for now but adhoc functionality
	@RequestMapping(value = "/fetchAllContinent", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ContinentEntity>> fetchContinent() throws InternalServerException {
		try {
			List<ContinentEntity> listOfContinent = service.getAllcontinents();
			if (listOfContinent != null && !listOfContinent.isEmpty()) {
				return new ResponseEntity<List<ContinentEntity>>(listOfContinent, new HttpHeaders(), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<ContinentEntity>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception ex) {
			throw new InternalServerException(ex.getMessage());
		}
	}

}