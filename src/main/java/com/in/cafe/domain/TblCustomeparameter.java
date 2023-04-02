package com.in.cafe.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_customeparameter")
public class TblCustomeparameter extends AbstractAuditingEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long customeparameterId;
	private TblField tblField;
	private String labelName;
	private String defaultValue;
	private int isShow;
	private String fieldInfo;
	private int sortOrder;
	private TblClient tblClient;
	private TblModule tblModule;
	private TblSubModule tblSubModule;
	
	private String dropDown;
	private int isCorrigendum;
	
	
	
	public int getIsCorrigendum() {
		return isCorrigendum;
	}

	public void setIsCorrigendum(int isCorrigendum) {
		this.isCorrigendum = isCorrigendum;
	}

	/**
	 * @return the dropDown
	 */
	@Column(name = "drop_down")
	public String getDropDown() {
		return dropDown;
	}

	/**
	 * @param dropDown the dropDown to set
	 */
	public void setDropDown(String dropDown) {
		this.dropDown = dropDown;
	}

	/**
	 * @return the tblSubModule
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_module_id")
	public TblSubModule getTblSubModule() {
		return tblSubModule;
	}

	/**
	 * @param tblSubModule the tblSubModule to set
	 */
	public void setTblSubModule(TblSubModule tblSubModule) {
		this.tblSubModule = tblSubModule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id")
	public TblModule getTblModule() {
		return tblModule;
	}

	public void setTblModule(TblModule tblModule) {
		this.tblModule = tblModule;
	}

	public TblCustomeparameter() {
		super();
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "customeparameter_id", unique = true)
	public Long getCustomeparameterId() {
		return this.customeparameterId;
	}

	public void setCustomeparameterId(Long customeparameterId) {
		this.customeparameterId = customeparameterId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "field_id", nullable = false)
	public TblField getTblField() {
		return this.tblField;
	}

	public void setTblField(TblField tblField) {
		this.tblField = tblField;
	}

	@Column(name = "label_name", nullable = false, length = 500)
	public String getLabelName() {
		return this.labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	@Column(name = "default_value", nullable = false, length = 10000)
	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Column(name = "is_show", nullable = false)
	public int getIsShow() {
		return this.isShow;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}

	@Column(name = "field_info", nullable = false, length = 2000)
	public String getFieldInfo() {
		return this.fieldInfo;
	}

	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}

	@Column(name = "sort_order", nullable = false)
	public int getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @return the tblClient
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	public TblClient getTblClient() {
		return tblClient;
	}

	/**
	 * @param tblClient the tblClient to set
	 */
	public void setTblClient(TblClient tblClient) {
		this.tblClient = tblClient;
	}
}
