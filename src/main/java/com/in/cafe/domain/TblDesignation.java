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
@Table(name = "tbl_designation")
public class TblDesignation extends AbstractAuditingEntity implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long designationId;
	private String designationName;
	private int designationParentId;
	private TblClient tblclient;

	public TblDesignation() {
		super();
	}

	/**
	 * @param designationId
	 */
	public TblDesignation(Long designationId) {
		super();
		this.designationId = designationId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "designation_id", unique = true, nullable = false)
	public Long getDesignationId() {
		return this.designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}


	@Column(name = "designation_name", nullable = false, length = 200)
	public String getDesignationName() {
		return this.designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	@Column(name = "designation_parent_id", nullable = false)
	public int getDesignationParentId() {
		return this.designationParentId;
	}

	public void setDesignationParentId(int designationParentId) {
		this.designationParentId = designationParentId;
	}

	/**
	 * @return the tblclient
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "client_id", nullable = false)
	public TblClient getTblclient() {
		return tblclient;
	}

	/**
	 * @param tblclient the tblclient to set
	 */
	public void setTblclient(TblClient tblclient) {
		this.tblclient = tblclient;
	}

}

