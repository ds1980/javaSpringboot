package com.in.cafe.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_company")
public class TblCompany {
	
	 private Long companyId;
	    private TblCompanytype tblCompanytype;
	    private String companyName;
	    private long clientId;
	    private long countryId;
	    private long stateId;
	    private String cityName;
	    private String phoneNo;
	    private String cinNo;
	    
	    private Long userId;
	    
	    public TblCompany() {
	    }
	    
	    public TblCompany(Long companyId) {
	        this.companyId = companyId;
	    }
	    
	    @Id
	    @GeneratedValue(strategy = IDENTITY)
	    @Column(name = "company_id", unique = true, nullable = false)
	    public Long getCompanyId() {
	        return this.companyId;
	    }

	    public void setCompanyId(Long companyId) {
	        this.companyId = companyId;
	    }

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "company_type_id", nullable = false)
	    public TblCompanytype getTblCompanytype() {
	        return this.tblCompanytype;
	    }

	    public void setTblCompanytype(TblCompanytype tblCompanytype) {
	        this.tblCompanytype = tblCompanytype;
	    }

	    @Column(name = "company_name", nullable = false, length = 250)
	    public String getCompanyName() {
	        return this.companyName;
	    }

	    public void setCompanyName(String companyName) {
	        this.companyName = companyName;
	    }

	    @Column(name = "client_id", nullable = false)
	    public long getClientId() {
	        return this.clientId;
	    }

	    public void setClientId(long clientId) {
	        this.clientId = clientId;
	    }

	    @Column(name = "country_id", nullable = false)
	    public long getCountryId() {
	        return this.countryId;
	    }

	    public void setCountryId(long countryId) {
	        this.countryId = countryId;
	    }

	    @Column(name = "state_id", nullable = false)
	    public long getStateId() {
	        return this.stateId;
	    }

	    public void setStateId(long stateId) {
	        this.stateId = stateId;
	    }

	    @Column(name = "city_name", nullable = false)
	    public String getCityName() {
	        return cityName;
	    }

	    public void setCityName(String cityName) {
	        this.cityName = cityName;
	    }



	    @Column(name = "phone_no", nullable = false, length = 45)
	    public String getPhoneNo() {
	        return this.phoneNo;
	    }

	    public void setPhoneNo(String phoneNo) {
	        this.phoneNo = phoneNo;
	    }

	    @Column(name = "cin_no", nullable = false, length = 100)
	    public String getCinNo() {
	        return this.cinNo;
	    }

	    public void setCinNo(String cinNo) {
	        this.cinNo = cinNo;
	    }

	    /**
	     * @return the userId
	     */
	    @Column(name = "user_id", nullable = false)
	    public Long getUserId() {
	        return userId;
	    }

	    /**
	     * @param userId the userId to set
	     */
	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

}
