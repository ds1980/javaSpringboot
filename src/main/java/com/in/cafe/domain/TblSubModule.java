package com.in.cafe.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_sub_module")
public class TblSubModule implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer subModuleId;
	private String subModuleName;
	private TblModule tblModule;
	private int activeStatus;

	public TblSubModule() {
		super();
	}

	public TblSubModule(Integer subModuleId) {
		super();
		this.subModuleId = subModuleId;
	}

	public TblSubModule(Integer subModuleId, String subModuleName, TblModule tblModule, int activeStatus) {
		super();
		this.subModuleId = subModuleId;
		this.subModuleName = subModuleName;
		this.tblModule = tblModule;
		this.activeStatus = activeStatus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sub_module_id", unique = true, nullable = false)
	public Integer getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(Integer subModuleId) {
		this.subModuleId = subModuleId;
	}

	@Column(name = "sub_module_name", nullable = false, length = 500)
	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id")
	public TblModule getTblModule() {
		return tblModule;
	}

	public void setTblModule(TblModule tblModule) {
		this.tblModule = tblModule;
	}

	@Column(name = "active_status")
	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, subModuleId, subModuleName, tblModule);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TblSubModule other = (TblSubModule) obj;
		return activeStatus == other.activeStatus && Objects.equals(subModuleId, other.subModuleId)
				&& Objects.equals(subModuleName, other.subModuleName) && Objects.equals(tblModule, other.tblModule);
	}

}
