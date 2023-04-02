package com.in.cafe.dto;

import java.util.Objects;

import com.in.cafe.domain.TblModule;



public class TblSubModuleDto {
	private Integer subModuleId;
	private String subModuleName;
	private TblModule tblModule;
	private int activeStatus;
	private int moduleId;
	/**
	 * @return the subModuleId
	 */
	public Integer getSubModuleId() {
		return subModuleId;
	}
	/**
	 * @param subModuleId the subModuleId to set
	 */
	public void setSubModuleId(Integer subModuleId) {
		this.subModuleId = subModuleId;
	}
	/**
	 * @return the subModuleName
	 */
	public String getSubModuleName() {
		return subModuleName;
	}
	/**
	 * @param subModuleName the subModuleName to set
	 */
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	/**
	 * @return the tblModule
	 */
	public TblModule getTblModule() {
		return tblModule;
	}
	/**
	 * @param tblModule the tblModule to set
	 */
	public void setTblModule(TblModule tblModule) {
		this.tblModule = tblModule;
	}
	/**
	 * @return the activeStatus
	 */
	public int getActiveStatus() {
		return activeStatus;
	}
	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}
	/**
	 * @return the moduleId
	 */
	public int getModuleId() {
		return moduleId;
	}
	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, moduleId, subModuleId, subModuleName, tblModule);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TblSubModuleDto other = (TblSubModuleDto) obj;
		return activeStatus == other.activeStatus && moduleId == other.moduleId
				&& Objects.equals(subModuleId, other.subModuleId) && Objects.equals(subModuleName, other.subModuleName)
				&& Objects.equals(tblModule, other.tblModule);
	}
}
