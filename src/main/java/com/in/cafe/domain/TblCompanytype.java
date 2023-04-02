package com.in.cafe.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_companytype")
public class TblCompanytype implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long companyTypeId;
	private String companyType;
	private int clientId;
	private Date createdOn;
	private int createdBy;
	private Date updatedOn;
	private Integer updatedBy;
	private byte isActive;
	private Set<TblCompany> tblCompanies = new HashSet<TblCompany>(0);
	
	public TblCompanytype() {
	}
	
	public TblCompanytype(Long companyTypeId) {
		super();
		this.companyTypeId = companyTypeId;
	}
	public TblCompanytype(String companyType, int clientId, Date createdOn, int createdBy, byte isActive) {
		this.companyType = companyType;
		this.clientId = clientId;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.isActive = isActive;
	}

	public TblCompanytype(String companyType, int clientId, Date createdOn, int createdBy, Date updatedOn, Integer updatedBy, byte isActive, Set<TblCompany> tblCompanies) {
		this.companyType = companyType;
		this.clientId = clientId;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
		this.isActive = isActive;
		this.tblCompanies = tblCompanies;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "company_type_id", unique = true, nullable = false)
	public Long getCompanyTypeId() {
		return this.companyTypeId;
	}

	public void setCompanyTypeId(Long companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	@Column(name = "company_type", nullable = false, length = 500)
	public String getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	@Column(name = "client_id", nullable = false)
	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "created_by", nullable = false)
	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on", length = 19)
	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Column(name = "updated_by")
	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "is_active", nullable = false)
	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblCompanytype")
	public Set<TblCompany> getTblCompanies() {
		return this.tblCompanies;
	}

	public void setTblCompanies(Set<TblCompany> tblCompanies) {
		this.tblCompanies = tblCompanies;
	}
}
