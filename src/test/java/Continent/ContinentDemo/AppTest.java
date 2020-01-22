package Continent.ContinentDemo;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.demo.model.ContinentEntity;
import com.demo.model.CountryEntity;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;


public class AppTest {
	final String uri = "http://localhost:8080";

	@Test
	public void CreateCountryData() {
		
		
		// continent record 1:
		ContinentEntity continent = new ContinentEntity();
		continent.setContinentName("Africa");

		Response response = RestAssured.given().baseUri(uri + "/createContinent")
							.contentType("application/json").body(continent).then().post();
		String body = response.asString();
		System.out.println(body); 
		
		
		// Save country Data: 
		CountryEntity country1 = new CountryEntity();
		//country1.setCountryId(1l);
		country1.setContinent(continent);
		country1.setCountryName("Nigeria");
		country1.setCountryFlag("NG");

		CountryEntity country2 = new CountryEntity();
		//country2.setCountryId(2l);
		country2.setContinent(continent);
		country2.setCountryName("Ethiopia");
		country2.setCountryFlag("ET");

		Set<CountryEntity> cntryEntitySet = new HashSet<>();
		cntryEntitySet.add(country1);
		cntryEntitySet.add(country2);
		

		Response response1 = RestAssured.given().baseUri(uri + "/createCountry")
							.contentType("application/json").body(cntryEntitySet).then().post();
		String body1 = response1.asString();
		System.out.println(body1);

	}

	@Test
	public void fetchAllCountry() {
		Response response = RestAssured.given().baseUri(uri + "/fetchAllCountry")
							.contentType("application/json").then().get();
		String body = response.asString();
		System.out.println(body);

	}
	
	@Test
	public void findCountryByContinentNm() {
		Response response = RestAssured.given().baseUri(uri + "/fetchCountryById?id=Africa")
							.contentType("application/json").then().get();
		String body = response.asString();
		System.out.println(body);

	}
	
	@Test
	public void fetchCountryFlagByName() {
		Response response = RestAssured.given().baseUri(uri + "/fetchCountryFlagByName?id=Nigeria")
							.contentType("application/json").then().get();
		String body = response.asString();
		System.out.println(body);

	}
	
	

}
