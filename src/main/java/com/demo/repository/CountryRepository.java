package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.CountryEntity;
 
@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
	@Query(value="SELECT * FROM COUNTRY b inner join continent a on a.continent_id = b.continent_id and a.continent_name=?1", nativeQuery = true)
	List<CountryEntity> findCountryByContinentNm(String continent_name);
	
	@Query(value="SELECT * FROM COUNTRY a where a.country_name=?1", nativeQuery = true)
	CountryEntity findFlagByCountryNm(String country_name);
}
