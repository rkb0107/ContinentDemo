package com.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="country")
public class CountryEntity implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="country_id", updatable = false, nullable = false)
	@JsonIgnoreProperties("countryId")
    private Long countryId;
    

    @Column(name="country_name", nullable=false)
    @JsonIgnoreProperties("countryName")
    private String countryName;
    
    @Column(name="country_flag", nullable=false)
    @JsonIgnoreProperties("country_flag")
    private String countryFlag;
    
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "continent_id", nullable = false)
    //@JsonBackReference
    private ContinentEntity continent;
    
    
    public CountryEntity() {}
    
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryFlag() {
		return countryFlag;
	}

	public void setCountryFlag(String countryFlag) {
		this.countryFlag = countryFlag;
	}
	@JsonIgnore // uncomment when need to create data
	public ContinentEntity getContinent() {
		return continent;
	}

	public void setContinent(ContinentEntity continent) {
		this.continent = continent;
	}

	@Override
    public String toString() {
        return "countryEntity [countryId=" + countryId + ", countryName=" + countryName + ", countryFlag=" + countryFlag + "]";
    }
}