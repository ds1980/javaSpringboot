package com.in.cafe.POJO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class AddBidderDTO extends AbstractAuditingDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long bidderId;
	private Long userId;
	private Long clientId;
	private Long companyId;
	private String emailId;
	private String companyName;
	private String state;
	private String mobileNo;
	private String cityName;
	private String country;
	private String category;
	private String remarks;
	private Date approvedOn;
	private Long approvedBy;
	private String otpNumber;
	private String clientURL;
	
	 public String getClientURL() {
			return clientURL;
		}

		public void setClientURL(String clientURL) {
			this.clientURL = clientURL;
		}

		public String getOtpNumber() {
			return otpNumber;
		}

		public void setOtpNumber(String otpNumber) {
			this.otpNumber = otpNumber;
		}

		private Long timeZoneId;

	    public void setBidderId(long bidderId) {
	        this.bidderId = bidderId;
	    }

	    public Long getTimeZoneId() {
	        return timeZoneId;
	    }

	    public void setTimeZoneId(Long timeZoneId) {
	        this.timeZoneId = timeZoneId;
	    }
	    public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}



		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		/**
		 * @return the bidderId
		 */
		public Long getBidderId() {
			return bidderId;
		}

		/**
		 * @param bidderId the bidderId to set
		 */
		public void setBidderId(Long bidderId) {
			this.bidderId = bidderId;
		}

		/**
		 * @return the userId
		 */
		public Long getUserId() {
			return userId;
		}

		/**
		 * @param userId the userId to set
		 */
		public void setUserId(Long userId) {
			this.userId = userId;
		}

		/**
		 * @return the clientId
		 */
		public Long getClientId() {
			return clientId;
		}

		/**
		 * @param clientId the clientId to set
		 */
		public void setClientId(Long clientId) {
			this.clientId = clientId;
		}

		/**
		 * @return the companyId
		 */
		public Long getCompanyId() {
			return companyId;
		}

		/**
		 * @param companyId the companyId to set
		 */
		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}

		/**
		 * @return the category
		 */
		public String getCategory() {
			return category;
		}

		/**
		 * @param category the category to set
		 */
		public void setCategory(String category) {
			this.category = category;
		}

		/**
		 * @return the remarks
		 */
		public String getRemarks() {
			return remarks;
		}

		/**
		 * @param remarks the remarks to set
		 */
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		/**
		 * @return the approvedOn
		 */
		public Date getApprovedOn() {
			return approvedOn;
		}

		/**
		 * @param approvedOn the approvedOn to set
		 */
		public void setApprovedOn(Date approvedOn) {
			this.approvedOn = approvedOn;
		}

		/**
		 * @return the approvedBy
		 */
		public Long getApprovedBy() {
			return approvedBy;
		}

		/**
		 * @param approvedBy the approvedBy to set
		 */
		public void setApprovedBy(Long approvedBy) {
			this.approvedBy = approvedBy;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof AddBidderDTO)) {
				return false;
			}
			AddBidderDTO other = (AddBidderDTO) obj;
			return Objects.equals(bidderId, other.bidderId) && Objects.equals(companyId, other.companyId)
					&& Objects.equals(category, other.category) && Objects.equals(clientId, other.clientId)
					&& Objects.equals(remarks, other.remarks) && Objects.equals(approvedOn, other.approvedOn)
					&& Objects.equals(approvedBy, other.approvedBy) && Objects.equals(userId, other.userId);

		}


		/**
		 *
		 */
		public AddBidderDTO() {
			super();
		}

		@Override
		public int hashCode() {
			return Objects.hash(bidderId, companyId, clientId, category, remarks, approvedOn,
					approvedBy,userId);
		}

	    public String getCityName() {
	        return cityName;
	    }

	    public void setCityName(String cityName) {
	        this.cityName = cityName;
	    }
	
}
