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
@Table(name = "tbl_field")
public class TblField implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long fieldId;
	private TblModule tblModule;
	private TblSubModule tblSubModule;
	private String fieldName;
	private int isActive;
	private String lang1;
	private String lang2;
	private String lang3;
	private String lang4;
	private String lang5;
	private String defaultValue;
	private String fieldLabel;
	private String fieldValue;
	private String fieldType;
	private int sortOrder;
	private int isCorrigendum;
	private int section_id;
	private int is_mandatory;
	
	
	@Column(name = "is_corrigendum")
	public int getIsCorrigendum() {
		return isCorrigendum;
	}

	@Column(name = "section_id")
	public int getSection_id() {
		return section_id;
	}

	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}
	
	@Column(name = "is_mandatory")
	public int getIs_mandatory() {
		return is_mandatory;
	}

	public void setIs_mandatory(int is_mandatory) {
		this.is_mandatory = is_mandatory;
	}

	public void setIsCorrigendum(int isCorrigendum) {
		this.isCorrigendum = isCorrigendum;
	}

	@Column(name = "sort_order")
	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @return the defaultValue
	 */
	@Column(name = "default_value")
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * @return the fieldLable
	 */
	@Column(name = "field_label")
	public String getFieldLabel() {
		return fieldLabel;
	}

	/**
	 * @param fieldLabel the fieldLabel to set
	 */
	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	/**
	 * @return the fieldValue
	 */
	@Column(name = "field_values")
	public String getFieldValue() {
		return fieldValue;
	}

	/**
	 * @param fieldValue the fieldValue to set
	 */
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	/**
	 * @return the fieldType
	 */
	@Column(name = "field_type")
	public String getFieldType() {
		return fieldType;
	}

	/**
	 * @param fieldType the fieldType to set
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public TblField() {
	}

	public TblField(TblModule tblModule, String fieldName, int isActive) {
		this.tblModule = tblModule;
		this.fieldName = fieldName;
		this.isActive = isActive;
	}

	

	public TblField(Long fieldId) {
		super();
		this.fieldId = fieldId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "field_id", unique = true, nullable = false)
	public Long getFieldId() {
		return this.fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id", nullable = false)
	public TblModule getTblModule() {
		return this.tblModule;
	}

	public void setTblModule(TblModule tblModule) {
		this.tblModule = tblModule;
	}

	/**
	 * @return the tblSubModule
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_module_id", nullable = false)
	public TblSubModule getTblSubModule() {
		return tblSubModule;
	}

	/**
	 * @param tblSubModule the tblSubModule to set
	 */
	public void setTblSubModule(TblSubModule tblSubModule) {
		this.tblSubModule = tblSubModule;
	}

	@Column(name = "field_name", nullable = false, length = 500)
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Column(name = "is_active", nullable = false)
	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Column(name = "lang1", length = 500)
	public String getLang1() {
		return this.lang1;
	}

	public void setLang1(String lang1) {
		this.lang1 = lang1;
	}

	@Column(name = "lang2", length = 500)
	public String getLang2() {
		return this.lang2;
	}

	public void setLang2(String lang2) {
		this.lang2 = lang2;
	}

	@Column(name = "lang3", length = 500)
	public String getLang3() {
		return this.lang3;
	}

	public void setLang3(String lang3) {
		this.lang3 = lang3;
	}

	@Column(name = "lang4", length = 500)
	public String getLang4() {
		return this.lang4;
	}

	public void setLang4(String lang4) {
		this.lang4 = lang4;
	}

	@Column(name = "lang5", length = 500)
	public String getLang5() {
		return this.lang5;
	}

	public void setLang5(String lang5) {
		this.lang5 = lang5;
	}

}
