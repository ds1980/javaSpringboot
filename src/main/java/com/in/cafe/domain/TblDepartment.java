package com.in.cafe.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_department")
public class TblDepartment extends AbstractAuditingEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long departmentId;
	private String departmentName;
	private long parentDeptId;
	private String addressLine1;
	private String addressLine2;
	private long stateId;
	private long countryId;
	private int pincodeNo;
	private TblClient tblClient;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id", unique = true, nullable = false)
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	@Column(name = "department_name", nullable = false, length = 1000)
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Column(name = "parent_dept_id", nullable = false)
	public long getParentDeptId() {
		return parentDeptId;
	}
	public void setParentDeptId(long parentDeptId) {
		this.parentDeptId = parentDeptId;
	}
	@Column(name = "address_line1", length = 1000)
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	@Column(name = "address_line2", length = 1000)
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	@Column(name = "state_id", nullable = false)
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	@Column(name = "country_id", nullable = false)
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	@Column(name = "pincode_no", nullable = false)
	public int getPincodeNo() {
		return pincodeNo;
	}
	public void setPincodeNo(int pincodeNo) {
		this.pincodeNo = pincodeNo;
	}
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="client_id", nullable=false)
	public TblClient getTblClient() {
		return tblClient;
	}
	public void setTblClient(TblClient tblClient) {
		this.tblClient = tblClient;
	}
	
	public TblDepartment(Long departmentId) {
		super();
		this.departmentId = departmentId;
	}
	
	public TblDepartment() {
		super();
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        if (!super.equals(o)) return false;
	        TblDepartment that = (TblDepartment) o;
	        return parentDeptId == that.parentDeptId &&
	            stateId == that.stateId &&
	            countryId == that.countryId &&
	            pincodeNo == that.pincodeNo &&
	            Objects.equals(departmentId, that.departmentId) &&
	            Objects.equals(departmentName, that.departmentName) &&
	            Objects.equals(addressLine1, that.addressLine1) &&
	            Objects.equals(addressLine2, that.addressLine2) &&
	            Objects.equals(tblClient, that.tblClient);
	    }
}
