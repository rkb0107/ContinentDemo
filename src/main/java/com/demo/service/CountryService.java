package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.InternalServerException;
import com.demo.model.CountryEntity;
import com.demo.repository.CountryRepository;

/**
 * This service is used to create/search Country service.
 */
@Service
public class CountryService {


	@Autowired
	CountryRepository repository;

	public List<CountryEntity> getAllCountries() {
		List<CountryEntity> CountryList = repository.findAll();

		if (CountryList != null && CountryList.size() > 0) {
			return CountryList;
		} else {
			return new ArrayList<CountryEntity>();
		}
	}

	public List<CountryEntity> getCountryById(String id) throws InternalServerException {
		return repository.findCountryByContinentNm(id);
	}
	
	public CountryEntity getFlagByCountryNm(String name) throws InternalServerException {
		return repository.findFlagByCountryNm(name);
	}
	
	

	public CountryEntity createCountry(CountryEntity entity) throws InternalServerException {
		entity = repository.save(entity);

		return entity;
	}


	
	
}