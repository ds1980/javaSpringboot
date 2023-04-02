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

import com.in.cafe.POJO.TblUserLogin;


@Entity
@Table(name = "tbl_officer")
public class TblOfficer extends AbstractAuditingEntity implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long officerId;
	private TblDesignation designationId;
	private TblUserLogin userId;
	private String officerName;
	private String mobileNo;
	private String cityName;
	private long stateId;
	private Long countryId;
	private String addressLine1;
	private String addressLine2;
	private String officerEmailId;
	private TblClient clientId;

	public TblOfficer() {
		super();
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "officer_id", unique = true, nullable = false)
	public Long getOfficerId() {
		return this.officerId;
	}



	public TblOfficer(Long officerId) {
		super();
		this.officerId = officerId;
	}

	public void setOfficerId(Long officerId) {
		this.officerId = officerId;
	}

	/**
	 * @return the departmentId
	 */


	/**
	 * @return the designationId
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "designation_id", nullable = false)
	public TblDesignation getDesignationId() {
		return designationId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(TblDesignation designationId) {
		this.designationId = designationId;
	}

	@Column(name = "officer_name", nullable = false, length = 100)
	public String getOfficerName() {
		return this.officerName;
	}

	/**
	 * @return the userId
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
	public TblUserLogin getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(TblUserLogin userId) {
		this.userId = userId;
	}

	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}

	@Column(name = "mobile_no", nullable = false, length = 100)
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

    @Column(name = "city_name", nullable = false)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }




	@Column(name = "state_id", nullable = false)
	public long getStateId() {
		return this.stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	@Column(name = "country_id")
	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	@Column(name = "address_line1", length = 100)
	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "address_line2", length = 100)
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "officer_email_id", nullable = false, length = 100)
	public String getOfficerEmailId() {
		return this.officerEmailId;
	}

	public void setOfficerEmailId(String officerEmailId) {
		this.officerEmailId = officerEmailId;
	}

	/**
	 * @return the clientId
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "client_id", nullable = false)
	public TblClient getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(TblClient clientId) {
		this.clientId = clientId;
	}

}

