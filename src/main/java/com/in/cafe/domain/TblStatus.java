package com.in.cafe.domain;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_status")
public class TblStatus {
	 private long status;
	    private String statusName;

	    @Id
	    @Column(name = "status")
	    public long getStatus() {
	        return status;
	    }

	    public void setStatus(long status) {
	        this.status = status;
	    }

	    @Basic
	    @Column(name = "status_name")
	    public String getStatusName() {
	        return statusName;
	    }

	    public void setStatusName(String statusName) {
	        this.statusName = statusName;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        TblStatus tblStatus = (TblStatus) o;
	        return status == tblStatus.status &&
	            Objects.equals(statusName, tblStatus.statusName);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(status, statusName);
	    }
}
