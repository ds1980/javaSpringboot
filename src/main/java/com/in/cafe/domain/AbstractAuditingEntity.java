package com.in.cafe.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "created_by",  updatable = false)
	@JsonIgnore
	private Long createdBy;

	@Column(name = "created_on", updatable = false)
	@JsonIgnore
	private Instant createdOn;

	@Column(name = "updated_by")
	@JsonIgnore
	private Long updatedBy;

	@Column(name = "updated_on")
	@JsonIgnore
	private Instant updatedOn;

	@Column(name = "active_status")
	private Integer activeStatus = 0;

	public Long getCreatedBy() {
		return createdBy;
	}

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

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Instant getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Instant updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	public AbstractAuditingEntity() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, createdBy, createdOn, updatedBy, updatedOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AbstractAuditingEntity)) {
			return false;
		}
		AbstractAuditingEntity other = (AbstractAuditingEntity) obj;
		return Objects.equals(activeStatus, other.activeStatus) && Objects.equals(createdBy, other.createdBy)
				&& Objects.equals(createdOn, other.createdOn) && Objects.equals(updatedBy, other.updatedBy)
				&& Objects.equals(updatedOn, other.updatedOn);
	}

	@Override
	public String toString() {
		return String.format(
				"AbstractAuditingEntity [createdBy=%s, createdOn=%s, updatedBy=%s, updatedOn=%s, activeStatus=%s]",
				createdBy, createdOn, updatedBy, updatedOn, activeStatus);
	}

}
