package com.in.cafe.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tender")
public class TblTender extends AbstractAuditingEntity implements java.io.Serializable {


    private static final long serialVersionUID = -2901382125468122297L;
    private Long tenderId;
	private TblDepartment tblDepartment;
	private TblOfficer tblOfficer;
	private String tenderNo;
	private String tenderBrief;
	private String tenderDescription;
	private int subdepartmentId;
	private String unspscCatgory;
	private int eventrequestType;
	private byte evaluationType;
	private byte biddingType;
	private int currency;
	private byte evaluationProcess;
	private byte biddingAccess;
	private byte biddingVarient;
	private byte contractType;
	private byte bidWithdrawal;
	private Date submissionStartdate;
	private Date submissionEnddate;
	private Date openingDate;
	private byte prebidMeeting;
	private Date prebidStartdate;
	private Date prebidEnddate;
	private long projectDuration;
	private long eventValue;
	private byte workflowRequired;
	private int eventStatus;
	private Long assignUserId;
	private int subModuleId;
	private Date publishedOn;
	private Long publishedBy;
	private TblClient tblClient;
	private Integer mapBidderType;
	private int isDelegated;
	private byte itemSelectionRequired;
	private Date cancelledOn;
	private Long cancelledBy;
	private String cancelledRemarks;

    @Column(name = "is_delegated")
    public int getIsDelegated() {
        return isDelegated;
    }

    public void setIsDelegated(int isDelegated) {
        this.isDelegated = isDelegated;
    }

    @Column(name = "map_bidder_type")
    public Integer getMapBidderType() {
        return mapBidderType;
    }

    public void setMapBidderType(Integer mapBidderType) {
        this.mapBidderType = mapBidderType;
    }

    public TblTender() {
	    super();
	}

	public TblTender(Long tenderId) {
		super();
		this.tenderId = tenderId;
	}

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "tender_id", unique = true, nullable = false)
    public Long getTenderId() {
        return this.tenderId;
    }

    public void setTenderId(Long tenderId) {
        this.tenderId = tenderId;
    }

    @Column(name = "sub_module_id")
    public int getSubModuleId() {
        return subModuleId;
    }
    public void setSubModuleId(int subModuleId) {
        this.subModuleId = subModuleId;
    }


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	public TblDepartment getTblDepartment() {
		return this.tblDepartment;
	}

	public void setTblDepartment(TblDepartment tblDepartment) {
		this.tblDepartment = tblDepartment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "officerId", nullable = false)
	public TblOfficer getTblOfficer() {
		return this.tblOfficer;
	}

	public void setTblOfficer(TblOfficer tblOfficer) {
		this.tblOfficer = tblOfficer;
	}

	@Column(name = "tender_no", nullable = false, length = 2000)
	public String getTenderNo() {
		return this.tenderNo;
	}

	public void setTenderNo(String tenderNo) {
		this.tenderNo = tenderNo;
	}

	@Column(name = "tender_brief", nullable = false, length = 2000)
	public String getTenderBrief() {
		return this.tenderBrief;
	}

	public void setTenderBrief(String tenderBrief) {
		this.tenderBrief = tenderBrief;
	}

	@Column(name = "tender_description", nullable = false, length = 2000)
	public String getTenderDescription() {
		return this.tenderDescription;
	}

	public void setTenderDescription(String tenderDescription) {
		this.tenderDescription = tenderDescription;
	}

	@Column(name = "subdepartment_id", nullable = false)
	public int getSubdepartmentId() {
		return this.subdepartmentId;
	}

	public void setSubdepartmentId(int subdepartmentId) {
		this.subdepartmentId = subdepartmentId;
	}

	@Column(name = "unspsc_catgory", nullable = false)
	public String getUnspscCatgory() {
		return this.unspscCatgory;
	}

	public void setUnspscCatgory(String unspscCatgory) {
		this.unspscCatgory = unspscCatgory;
	}

	@Column(name = "eventrequest_type", nullable = false)
	public int getEventrequestType() {
		return this.eventrequestType;
	}

	public void setEventrequestType(int eventrequestType) {
		this.eventrequestType = eventrequestType;
	}

	@Column(name = "evaluation_type", nullable = false)
	public byte getEvaluationType() {
		return this.evaluationType;
	}

	public void setEvaluationType(byte evaluationType) {
		this.evaluationType = evaluationType;
	}

	@Column(name = "bidding_type", nullable = false)
	public byte getBiddingType() {
		return this.biddingType;
	}

	public void setBiddingType(byte biddingType) {
		this.biddingType = biddingType;
	}

	@Column(name = "currency", nullable = false)
	public int getCurrency() {
		return this.currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	@Column(name = "evaluation_process", nullable = false)
	public byte getEvaluationProcess() {
		return this.evaluationProcess;
	}

	public void setEvaluationProcess(byte evaluationProcess) {
		this.evaluationProcess = evaluationProcess;
	}

	@Column(name = "bidding_access", nullable = false)
	public byte getBiddingAccess() {
		return this.biddingAccess;
	}

	public void setBiddingAccess(byte biddingAccess) {
		this.biddingAccess = biddingAccess;
	}

	@Column(name = "bidding_varient", nullable = false)
	public byte getBiddingVarient() {
		return this.biddingVarient;
	}

	public void setBiddingVarient(byte biddingVarient) {
		this.biddingVarient = biddingVarient;
	}

	@Column(name = "contract_type", nullable = false)
	public byte getContractType() {
		return this.contractType;
	}

	public void setContractType(byte contractType) {
		this.contractType = contractType;
	}

	@Column(name = "bid_withdrawal", nullable = false)
	public byte getBidWithdrawal() {
		return this.bidWithdrawal;
	}

	public void setBidWithdrawal(byte bidWithdrawal) {
		this.bidWithdrawal = bidWithdrawal;
	}

	@Column(name = "submission_startdate", length = 19)
	public Date getSubmissionStartdate() {
		return this.submissionStartdate;
	}

	public void setSubmissionStartdate(Date submissionStartdate) {
		this.submissionStartdate = submissionStartdate;
	}


	@Column(name = "submission_enddate", length = 19)
	public Date getSubmissionEnddate() {
		return this.submissionEnddate;
	}

	public void setSubmissionEnddate(Date submissionEnddate) {
		this.submissionEnddate = submissionEnddate;
	}

	@Column(name = "opening_date", length = 19)
	public Date getOpeningDate() {
		return this.openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	@Column(name = "prebid_meeting", nullable = false)
	public byte getPrebidMeeting() {
		return this.prebidMeeting;
	}

	public void setPrebidMeeting(byte prebidMeeting) {
		this.prebidMeeting = prebidMeeting;
	}

	@Column(name = "prebid_startdate", length = 19)
	public Date getPrebidStartdate() {
		return this.prebidStartdate;
	}

	public void setPrebidStartdate(Date prebidStartdate) {
		this.prebidStartdate = prebidStartdate;
	}

	@Column(name = "prebid_enddate", length = 19)
	public Date getPrebidEnddate() {
		return this.prebidEnddate;
	}

	public void setPrebidEnddate(Date prebidEnddate) {
		this.prebidEnddate = prebidEnddate;
	}

	@Column(name = "project_duration", nullable = false)
	public long getProjectDuration() {
		return this.projectDuration;
	}

	public void setProjectDuration(long projectDuration) {
		this.projectDuration = projectDuration;
	}

	@Column(name = "event_value", nullable = false)
	public long getEventValue() {
		return this.eventValue;
	}

	public void setEventValue(long eventValue) {
		this.eventValue = eventValue;
	}

	@Column(name = "workflow_required", nullable = false)
	public byte getWorkflowRequired() {
		return this.workflowRequired;
	}

	public void setWorkflowRequired(byte workflowRequired) {
		this.workflowRequired = workflowRequired;
	}

	@Column(name = "item_selection_required", nullable = false)
	public byte getItemSelectionRequired() {
		return this.itemSelectionRequired;
	}

	public void setItemSelectionRequired(byte itemSelectionRequired) {
		this.itemSelectionRequired = itemSelectionRequired;
	}

	@Column(name = "event_status", nullable = false)
	public int getEventStatus() {
		return this.eventStatus;
	}

	public void setEventStatus(int eventStatus) {
		this.eventStatus = eventStatus;
	}

	@Column(name = "assignuser_id", nullable = false)
	public Long getAssignUserId() {
		return assignUserId;
	}

	public void setAssignUserId(Long assignUserId) {
		this.assignUserId = assignUserId;
	}

	@Column(name = "published_on", length = 19)
	public Date getPublishedOn() {
		return this.publishedOn;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

	@Column(name = "published_by")
	public Long getPublishedBy() {
		return this.publishedBy;
	}

	public void setPublishedBy(Long publishedBy) {
		this.publishedBy = publishedBy;
	}

	
	@Column(name = "cancelled_on", length = 19)
	public Date getCancelledOn() {
		return this.cancelledOn;
	}

	public void setCancelledOn(Date cancelledOn) {
		this.cancelledOn = cancelledOn;
	}

	@Column(name = "cancelled_by")
	public Long getCancelledBy() {
		return this.cancelledBy;
	}

	public void setCancelledBy(Long cancelledBy) {
		this.cancelledBy = cancelledBy;
	}
	
	@Column(name = "cancelled_remarks")
	public String getCancelledRemarks() {
		return this.cancelledRemarks;
		}

	public void setCancelledRemarks(String cancelledRemarks) {
		this.cancelledRemarks = cancelledRemarks;
	}
	
	


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	public TblClient getTblClient() {
		return this.tblClient;
	}

	public void setTblClient(TblClient tblClient) {
		this.tblClient = tblClient;
	}

    @Override
    public String toString() {
        return new StringJoiner(", ", TblTender.class.getSimpleName() + "[", "]")
            .add("tenderId=" + tenderId)
            .add("tblDepartment=" + tblDepartment)
            .add("tblOfficer=" + tblOfficer)
            .add("tenderNo='" + tenderNo + "'")
            .add("tenderBrief='" + tenderBrief + "'")
            .add("tenderDescription='" + tenderDescription + "'")
            .add("subdepartmentId=" + subdepartmentId)
            .add("unspscCatgory=" + unspscCatgory)
            .add("eventrequestType=" + eventrequestType)
            .add("evaluationType=" + evaluationType)
            .add("biddingType=" + biddingType)
            .add("currency=" + currency)
            .add("evaluationProcess=" + evaluationProcess)
            .add("biddingAccess=" + biddingAccess)
            .add("biddingVarient=" + biddingVarient)
            .add("contractType=" + contractType)
            .add("bidWithdrawal=" + bidWithdrawal)
            .add("submissionStartdate=" + submissionStartdate)
            .add("submissionEnddate=" + submissionEnddate)
            .add("openingDate=" + openingDate)
            .add("prebidMeeting=" + prebidMeeting)
            .add("prebidStartdate=" + prebidStartdate)
            .add("prebidEnddate=" + prebidEnddate)
            .add("projectDuration=" + projectDuration)
            .add("eventValue=" + eventValue)
            .add("workflowRequired=" + workflowRequired)
            .add("eventStatus=" + eventStatus)
            .add("assignUserId=" + assignUserId)
            .add("subModuleId=" + subModuleId)
            .add("publishedOn=" + publishedOn)
            .add("publishedBy=" + publishedBy)
            .add("tblClient=" + tblClient)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TblTender tblTender = (TblTender) o;
        return subdepartmentId == tblTender.subdepartmentId &&
            unspscCatgory == tblTender.unspscCatgory &&
            eventrequestType == tblTender.eventrequestType &&
            evaluationType == tblTender.evaluationType &&
            biddingType == tblTender.biddingType &&
            currency == tblTender.currency &&
            evaluationProcess == tblTender.evaluationProcess &&
            biddingAccess == tblTender.biddingAccess &&
            biddingVarient == tblTender.biddingVarient &&
            contractType == tblTender.contractType &&
            bidWithdrawal == tblTender.bidWithdrawal &&
            prebidMeeting == tblTender.prebidMeeting &&
            projectDuration == tblTender.projectDuration &&
            eventValue == tblTender.eventValue &&
            workflowRequired == tblTender.workflowRequired &&
            eventStatus == tblTender.eventStatus &&
            subModuleId == tblTender.subModuleId &&
            Objects.equals(tenderId, tblTender.tenderId) &&
            Objects.equals(tblDepartment, tblTender.tblDepartment) &&
            Objects.equals(tblOfficer, tblTender.tblOfficer) &&
            Objects.equals(tenderNo, tblTender.tenderNo) &&
            Objects.equals(tenderBrief, tblTender.tenderBrief) &&
            Objects.equals(tenderDescription, tblTender.tenderDescription) &&
            Objects.equals(submissionStartdate, tblTender.submissionStartdate) &&
            Objects.equals(submissionEnddate, tblTender.submissionEnddate) &&
            Objects.equals(openingDate, tblTender.openingDate) &&
            Objects.equals(prebidStartdate, tblTender.prebidStartdate) &&
            Objects.equals(prebidEnddate, tblTender.prebidEnddate) &&
            Objects.equals(assignUserId, tblTender.assignUserId) &&
            Objects.equals(publishedOn, tblTender.publishedOn) &&
            Objects.equals(publishedBy, tblTender.publishedBy) &&
            Objects.equals(tblClient, tblTender.tblClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tenderId, tblDepartment, tblOfficer, tenderNo, tenderBrief, tenderDescription, subdepartmentId, unspscCatgory, eventrequestType, evaluationType, biddingType, currency, evaluationProcess, biddingAccess, biddingVarient, contractType, bidWithdrawal, submissionStartdate, submissionEnddate, openingDate, prebidMeeting, prebidStartdate, prebidEnddate, projectDuration, eventValue, workflowRequired, eventStatus, assignUserId, subModuleId, publishedOn, publishedBy, tblClient);
    }
}

