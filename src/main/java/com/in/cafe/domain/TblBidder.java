package com.in.cafe.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.in.cafe.POJO.TblUserLogin;



@Entity
@Table(name = "tbl_bidder")
public class TblBidder extends AbstractAuditingEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long bidderId;
	private TblCompany tblCompany;
	private TblUserLogin tblUserlogins;
	private Long clientId;
	private String category;
	private Date startDate;
	private Date endDate;
	private String remarks;
	private Date approvedOn;
	private Integer approvedBy;
   private Long timeZoneId;



   @Column(name = "time_zone_id")
   public Long getTimeZoneId() {
       return timeZoneId;
   }

   public void setTimeZoneId(Long timeZoneId) {
       this.timeZoneId = timeZoneId;
   }

   public TblBidder() {
       super();
   }
   public TblBidder(Long bidderId) {
       super();
       this.bidderId= bidderId;
   }
   @Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bidder_id", unique = true, nullable = false)
	public Long getBidderId() {
		return this.bidderId;
	}

	public void setBidderId(Long bidderId) {
		this.bidderId = bidderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", nullable = false)
	public TblCompany getTblCompany() {
		return this.tblCompany;
	}

	public void setTblCompany(TblCompany tblCompany) {
		this.tblCompany = tblCompany;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public TblUserLogin getTblUserlogins() {
		return this.tblUserlogins;
	}

	public void setTblUserlogins(TblUserLogin tblUserlogins) {
		this.tblUserlogins = tblUserlogins;
	}

	@Column(name = "client_id", nullable = false)
	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@Column(name = "category", nullable = false, length = 250)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "remarks", length = 250)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "approved_on", length = 19)
	public Date getApprovedOn() {
		return this.approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	@Column(name = "approved_by")
	public Integer getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

}
