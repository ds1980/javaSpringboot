package com.in.cafe.POJO;

import java.io.Serializable;

public class TblCompanyDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long companyId;
	private String companyName;
	private long clientId;
	private Long companyTypeId;
	private long countryId;
	private long stateId;

	private String phoneNo;
	private Long userId;
	private String cinNo;

	private String companyType;
	private String countryName;
	private String stateName;
	private String cityName;
	private String currencyId;
	private String currencySymbol;
	private String currencyName;
	
	
	public TblCompanyDTO(long companyId, String companyName, long clientId, Long companyTypeId, long countryId,
			long stateId, String phoneNo, Long userId, String cinNo, String companyType, String countryName,
			String stateName, String cityName, String currencyId, String currencySymbol, String currencyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.clientId = clientId;
		this.companyTypeId = companyTypeId;
		this.countryId = countryId;
		this.stateId = stateId;
		this.phoneNo = phoneNo;
		this.userId = userId;
		this.cinNo = cinNo;
		this.companyType = companyType;
		this.countryName = countryName;
		this.stateName = stateName;
		this.cityName = cityName;
		this.currencyId = currencyId;
		this.currencySymbol = currencySymbol;
		this.currencyName = currencyName;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	public TblCompanyDTO() {}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public Long getCompanyTypeId() {
		return companyTypeId;
	}
	public void setCompanyTypeId(Long companyTypeId) {
		this.companyTypeId = companyTypeId;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCinNo() {
		return cinNo;
	}
	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
