package com.in.cafe.domain;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_status_value")
public class TblStatusValue {
	   private long statusValuesId;
	    private int statusId;
	    private String statusName;
	    private String statusIcon;
	    private int isDefault;

	    private  TblStatus tblStatus;

	    @Id
	    @Column(name = "status_values_id")
	    public long getStatusValuesId() {
	        return statusValuesId;
	    }

	    public void setStatusValuesId(long statusValuesId) {
	        this.statusValuesId = statusValuesId;
	    }

	    @Basic
	    @Column(name = "status_id")
	    public int getStatusId() {
	        return statusId;
	    }

	    public void setStatusId(int statusId) {
	        this.statusId = statusId;
	    }

	    @Basic
	    @Column(name = "status_name")
	    public String getStatusName() {
	        return statusName;
	    }

	    public void setStatusName(String statusName) {
	        this.statusName = statusName;
	    }

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "status")
	    public TblStatus getTblStatus() {
	        return tblStatus;
	    }

	    public void setTblStatus(TblStatus tblStatus) {
	        this.tblStatus = tblStatus;
	    }

	    @Basic
	    @Column(name = "status_icon")
	    public String getStatusIcon() {
	        return statusIcon;
	    }

	    public void setStatusIcon(String statusIcon) {
	        this.statusIcon = statusIcon;
	    }

	    @Basic
	    @Column(name = "is_default")
	    public int getIsDefault() {
	        return isDefault;
	    }

	    public void setIsDefault(int isDefault) {
	        this.isDefault = isDefault;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        TblStatusValue that = (TblStatusValue) o;
	        return statusValuesId == that.statusValuesId &&
	            statusId == that.statusId &&
	            isDefault == that.isDefault &&
	            Objects.equals(statusName, that.statusName) &&
	            Objects.equals(statusIcon, that.statusIcon);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(statusValuesId, statusId, statusName, statusIcon, isDefault);
	    }
}
