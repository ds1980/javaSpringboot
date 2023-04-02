package com.in.cafe.POJO;

import java.io.Serializable;
import java.time.Instant;

public class AbstractAuditingDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long createdBy;

	private Instant createdOn;

	private Long updatedBy;

	private Instant updatedOn;

	private Integer activeStatus;

	/**
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Instant getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the updatedBy
	 */
	public Long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedOn
	 */
	public Instant getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Instant updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the activeStatus
	 */
	public Integer getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * 
	 */
	public AbstractAuditingDto() {
		super();
	}
}
