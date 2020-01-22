package com.demo.controller;

import java.util.List;
import java.util.Set;

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
import com.demo.model.CountryEntity;
import com.demo.service.CountryService;

@EnableAutoConfiguration
@RestController
public class CountryController {
	@Autowired
	CountryService service;

	@RequestMapping(value = "/createCountry", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<CountryEntity> createCountry(@RequestBody Set<CountryEntity> CntryEntityList)
			throws InternalServerException {
		CountryEntity CountryEntity = null;
		try {
			if(CntryEntityList != null && CntryEntityList.size() > 0) {
				for(CountryEntity country : CntryEntityList) {
					 CountryEntity = service.createCountry(country);
				}
			}
			
			return new ResponseEntity<CountryEntity>(CountryEntity, new HttpHeaders(), HttpStatus.CREATED);
		} catch (Exception ex) {
			throw new InternalServerException(ex.getMessage());
		}
	}

	@RequestMapping(value = "/fetchCountryById", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CountryEntity>> fetchCountryDetails(@RequestParam("id") String id) throws InternalServerException {
		try {
			List<CountryEntity>  listOfCountry = service.getCountryById(id);
			if (listOfCountry != null) {
				return new ResponseEntity<List<CountryEntity>>(listOfCountry, new HttpHeaders(), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<CountryEntity>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception ex) {
			throw new InternalServerException(ex.getMessage());
		}
	}
	
	@RequestMapping(value = "/fetchCountryFlagByName", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CountryEntity> fetchCountryFlag(@RequestParam("id") String id) throws InternalServerException {
		try {
			CountryEntity  countryDetails = service.getFlagByCountryNm(id);
			if (countryDetails != null) {
				return new ResponseEntity<CountryEntity>(countryDetails, new HttpHeaders(), HttpStatus.OK);
			} else {
				return new ResponseEntity<CountryEntity>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception ex) {
			throw new InternalServerException(ex.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/fetchAllCountry", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CountryEntity>> fetchCountry() throws InternalServerException {
		try {
			List<CountryEntity> listOfCountry = service.getAllCountries();
			if (listOfCountry != null && !listOfCountry.isEmpty()) {
				return new ResponseEntity<List<CountryEntity>>(listOfCountry, new HttpHeaders(), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<CountryEntity>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception ex) {
			throw new InternalServerException(ex.getMessage());
		}
	}

}