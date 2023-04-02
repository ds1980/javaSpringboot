package com.in.cafe.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_section")
public class TblSection implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy = IDENTITY)
	    @Column(name = "section_id", unique = true, nullable = false)
	    private long sectionId;

	    @Column(name = "section_name")
	    private String sectionName;


	    @Column(name = "sub_module_id")
	    private long submoduleId;

	    @Column(name = "active_status")
	    private int activeStatus;

	    public long getSectionId() {
	        return sectionId;
	    }

	    public void setSectionId(long sectionId) {
	        this.sectionId = sectionId;
	    }

	    public String getSectionName() {
	        return sectionName;
	    }

	    public void setSectionName(String sectionName) {
	        this.sectionName = sectionName;
	    }

	    public long getSubmoduleId() {
	        return submoduleId;
	    }

	    public void setSubmoduleId(long submoduleId) {
	        this.submoduleId = submoduleId;
	    }

	    public int getActiveStatus() {
	        return activeStatus;
	    }

	    public void setActiveStatus(int activeStatus) {
	        this.activeStatus = activeStatus;
	    }

}
