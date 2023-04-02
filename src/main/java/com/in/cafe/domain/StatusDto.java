package com.in.cafe.domain;

import java.io.Serializable;
import java.util.List;

import com.in.cafe.mapper.NativeQueryResultColumn;
import com.in.cafe.mapper.NativeQueryResultEntity;


@NativeQueryResultEntity
public class StatusDto implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@NativeQueryResultColumn(index = 2)
	private String statusName;
	@NativeQueryResultColumn(index = 1)
	private int statusId;
	@NativeQueryResultColumn(index = 3)
	private String iconName;
	@NativeQueryResultColumn(index = 0)
	private String keyStatus;

	@NativeQueryResultColumn(index = 4)
	private int defaultSelect;

   private Long tenderId;

	private String remarks;
	private List<Integer> ids;

	private byte commiteeType;

	private int isAllBidder;

   public int getIsAllBidder() {
       return isAllBidder;
   }

   public void setIsAllBidder(int isAllBidder) {
       this.isAllBidder = isAllBidder;
   }

   public byte getCommiteeType() {
       return commiteeType;
   }

   public void setCommiteeType(byte commiteeType) {
       this.commiteeType = commiteeType;
   }

   public String getRemarks() {
       return remarks;
   }

   public void setRemarks(String remarks) {
       this.remarks = remarks;
   }

   public Long getTenderId() {
       return tenderId;
   }

   public void setTenderId(Long tenderId) {
       this.tenderId = tenderId;
   }



   public List<Integer> getIds() {
       return ids;
   }

   public void setIds(List<Integer> ids) {
       this.ids = ids;
   }

   public int getDefaultSelect() {
		return defaultSelect;
	}

	public void setDefaultSelect(int defaultSelect) {
		this.defaultSelect = defaultSelect;
	}

	public StatusDto(String keyStatus, int statusId, String statusName) {
		this.statusName = statusName;
		this.statusId = statusId;
		this.keyStatus = keyStatus;
	}

	public String getKeyStatus() {
		return keyStatus;
	}

	public void setKeyStatus(String keyStatus) {
		this.keyStatus = keyStatus;
	}

	public String getIconName() {
       return iconName;
   }

   public void setIconName(String iconName) {
       this.iconName = iconName;
   }

   public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public StatusDto() {
		super();
	}
	public StatusDto(String statusName, int statusId) {
		super();
		this.statusName = statusName;
		this.statusId = statusId;
	}

}
