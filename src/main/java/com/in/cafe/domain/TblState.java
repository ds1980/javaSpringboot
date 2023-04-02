package com.in.cafe.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_state")
public class TblState implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long stateId;
	private String stateName;
	private Long countryId;
	private String lang1;
	private String lang2;
	private String lang3;
	private String lang4;
	private String lang5;
	private String lang6;
	private String lang7;
	
	
	
	public TblState() {
		
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "state_id", unique = true, nullable = false)
	public Long getStateId() {
		return stateId;
	}
	
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	@Column(name = "state_name", nullable = false, length = 30)
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Column(name = "country_id", nullable = false)
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	@Column(name = "lang1", length = 100)
	public String getLang1() {
		return lang1;
	}
	public void setLang1(String lang1) {
		this.lang1 = lang1;
	}
	@Column(name = "lang2", length = 100)
	public String getLang2() {
		return lang2;
	}
	public void setLang2(String lang2) {
		this.lang2 = lang2;
	}
	@Column(name = "lang3", length = 100)
	public String getLang3() {
		return lang3;
	}
	public void setLang3(String lang3) {
		this.lang3 = lang3;
	}
	@Column(name = "lang4", length = 100)
	public String getLang4() {
		return lang4;
	}
	public void setLang4(String lang4) {
		this.lang4 = lang4;
	}
	@Column(name = "lang5", length = 100)
	public String getLang5() {
		return lang5;
	}
	public void setLang5(String lang5) {
		this.lang5 = lang5;
	}
	@Column(name = "lang6", length = 100)
	public String getLang6() {
		return lang6;
	}
	public void setLang6(String lang6) {
		this.lang6 = lang6;
	}
	@Column(name = "lang7", length = 100)
	public String getLang7() {
		return lang7;
	}
	public void setLang7(String lang7) {
		this.lang7 = lang7;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
