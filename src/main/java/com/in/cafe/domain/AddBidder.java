package com.in.cafe.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "add_bidder")
public class AddBidder implements Serializable {
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	    @Size(max = 100)
	    @Column(name = "company_name", length = 100, nullable = false, unique = true)
	    private String companyName;

	    @NotNull
	    @Size(max = 50)
	    @Column(name = "email_id", length = 50, nullable = false, unique = true)
	    private String emailId;

	    @NotNull
	    @Column(name = "country_code", nullable = false)
	    private Integer countryCode;

	    @NotNull
	    @Size(max = 20)
	    @Column(name = "mobile_no", length = 20, nullable = false)
	    private String mobileNo;

	    @NotNull
	    @Column(name = "company_type", nullable = false)
	    private Integer companyType;


	    @Column(name = "country")
	    private Integer country;

	    @NotNull
	    @Column(name = "state_or_province", nullable = false)
	    private Integer stateOrProvince;

	    @NotNull
	    @Column(name = "city_name", nullable = false)
	    private String cityName;

	    @NotNull
	    @Size(min = 6, max = 12)
	    @Column(name = "password", length = 12, nullable = false)
	    private String password;

	    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getCompanyName() {
	        return companyName;
	    }

	    public AddBidder companyName(String companyName) {
	        this.companyName = companyName;
	        return this;
	    }

	    public void setCompanyName(String companyName) {
	        this.companyName = companyName;
	    }

	    public String getEmailId() {
	        return emailId;
	    }

	    public AddBidder emailId(String emailId) {
	        this.emailId = emailId;
	        return this;
	    }

	    public void setEmailId(String emailId) {
	        this.emailId = emailId;
	    }

	    public Integer getCountryCode() {
	        return countryCode;
	    }

	    public AddBidder countryCode(Integer countryCode) {
	        this.countryCode = countryCode;
	        return this;
	    }

	    public void setCountryCode(Integer countryCode) {
	        this.countryCode = countryCode;
	    }

	    public String getMobileNo() {
	        return mobileNo;
	    }

	    public AddBidder mobileNo(String mobileNo) {
	        this.mobileNo = mobileNo;
	        return this;
	    }

	    public void setMobileNo(String mobileNo) {
	        this.mobileNo = mobileNo;
	    }

	    public Integer getCompanyType() {
	        return companyType;
	    }

	    public AddBidder companyType(Integer companyType) {
	        this.companyType = companyType;
	        return this;
	    }

	    public void setCompanyType(Integer companyType) {
	        this.companyType = companyType;
	    }


	    public Integer getCountry() {
	        return country;
	    }

	    public AddBidder country(Integer country) {
	        this.country = country;
	        return this;
	    }

	    public void setCountry(Integer country) {
	        this.country = country;
	    }

	    public Integer getStateOrProvince() {
	        return stateOrProvince;
	    }

	    public AddBidder stateOrProvince(Integer stateOrProvince) {
	        this.stateOrProvince = stateOrProvince;
	        return this;
	    }

	    public void setStateOrProvince(Integer stateOrProvince) {
	        this.stateOrProvince = stateOrProvince;
	    }




	    public String getPassword() {
	        return password;
	    }

	    public AddBidder password(String password) {
	        this.password = password;
	        return this;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        }
	        if (!(o instanceof AddBidder)) {
	            return false;
	        }
	        return id != null && id.equals(((AddBidder) o).id);
	    }

	    @Override
	    public int hashCode() {
	        return 31;
	    }

	    @Override
	    public String toString() {
	        return "AddBidder{" +
	            "id=" + getId() +
	            ", companyName='" + getCompanyName() + "'" +
	            ", emailId='" + getEmailId() + "'" +
	            ", countryCode=" + getCountryCode() +
	            ", mobileNo='" + getMobileNo() + "'" +
	            ", companyType=" + getCompanyType() +

	            ", country=" + getCountry() +
	            ", stateOrProvince=" + getStateOrProvince() +

	            ", password='" + getPassword() + "'" +
	            "}";
	    }
}
