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
@Table(name = "tbl_clientmodule")
public class TblClientmodule implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long clientModuleId;
	private TblClient tblClient;
	private TblModule tblModule;
	private TblSubModule tblSubModule;
	private int activeStatus;

	
	
	public TblClientmodule() {
	}

	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "client_module_id", unique = true, nullable = false)
	public Long getClientModuleId() {
		return this.clientModuleId;
	}

	public void setClientModuleId(Long clientModuleId) {
		this.clientModuleId = clientModuleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	public TblClient getTblClient() {
		return this.tblClient;
	}

	public void setTblClient(TblClient tblClient) {
		this.tblClient = tblClient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id", nullable = false)
	public TblModule getTblModule() {
		return this.tblModule;
	}

	public void setTblModule(TblModule tblModule) {
		this.tblModule = tblModule;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_module_id", nullable = false)
	public TblSubModule getTblSubModule() {
		return this.tblSubModule;
	}

	public void setTblSubModule(TblSubModule tblSubModule) {
		this.tblSubModule = tblSubModule;
	}

	/**
	 * @return the activeStatus
	 */
	@Column(name = "active_status", nullable = false)
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	
}
