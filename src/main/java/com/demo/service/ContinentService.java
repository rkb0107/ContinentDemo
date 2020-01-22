package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.InternalServerException;
import com.demo.model.ContinentEntity;
import com.demo.repository.ContinentRepository;

/**
 * This service is used to create/search Continent service.
 */
@Service
public class ContinentService {

	@Autowired
	ContinentRepository repository;

	public List<ContinentEntity> getAllcontinents() {
		List<ContinentEntity> continentList = repository.findAll();

		if (continentList != null && continentList.size() > 0) {
			return continentList;
		} else {
			return new ArrayList<ContinentEntity>();
		}
	}

	public ContinentEntity getContinentById(Long id) throws InternalServerException {
		Optional<ContinentEntity> continent = repository.findById(id);
		 if(continent.isPresent()) {
	            return continent.get();
	        }
		 
		return null;
	}

	public ContinentEntity createContinent(ContinentEntity entity) throws InternalServerException {
		entity = repository.save(entity);

		return entity;
	}

}