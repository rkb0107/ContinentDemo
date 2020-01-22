package com.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="continent")
public class ContinentEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id", unique = true, nullable = false)
	@JsonIgnoreProperties("continentId")
    private Long continentId;
    
    @Column(name="continent_name", nullable=false)
    @JsonIgnoreProperties("continentName")
    private String continentName;
    
    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL)
    //@JsonManagedReference
    private Set<CountryEntity> country;
    
    public ContinentEntity() {
    }
    
	public Long getContinentId() {
		return continentId;
	}

	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	@JsonIgnore  // uncomment when need to create data
	public Set<CountryEntity> getCountry() {
		return country;
	}

	public void setCountry(Set<CountryEntity> country) {
		this.country = country;
	}

	@Override
    public String toString() {
        return "ContinentEntity [continentId=" + continentId + ", continentName=" + continentName + "]";
    }
}