package com.in.cafe.dto;

public class TblSectionDto {
	 private long sectionId;

	    private String sectionName;



	    private long submoduleId;
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
