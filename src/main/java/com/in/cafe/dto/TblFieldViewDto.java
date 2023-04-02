package com.in.cafe.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import com.in.cafe.mapper.NativeQueryResultColumn;
import com.in.cafe.mapper.NativeQueryResultEntity;



@NativeQueryResultEntity
public class TblFieldViewDto implements Serializable {
	 private static final long serialVersionUID = -1613374741336996463L;
	    @NativeQueryResultColumn(index =  0)
	    private String lableName;

	    @NativeQueryResultColumn(index = 1)
	    private String defaultValue;

	    @NativeQueryResultColumn(index = 2)
	    private String description;

	    @NativeQueryResultColumn(index = 3)
	    private Integer isShow;

	    @NativeQueryResultColumn(index = 4)
	    private String jsonForList;

	    @NativeQueryResultColumn(index = 5)
	    private Integer isCorrigendum;

	    @NativeQueryResultColumn(index = 6)
	    private String fieldKey;

	    @NativeQueryResultColumn(index = 7)
	    private String fieldType;

	    @NativeQueryResultColumn(index = 8)
	    private String sectionName;

	    @NativeQueryResultColumn(index = 9)
	    private String sectionId;

	    @NativeQueryResultColumn(index = 10)
	    private Integer isMandatory;

	    public Integer getIsMandatory() {
	        return isMandatory;
	    }

	    public Integer getIsShow() {
	        return isShow;
	    }

	    public void setIsShow(Integer isShow) {
	        this.isShow = isShow;
	    }

	    public String getSectionId() {
	        return sectionId;
	    }

	    public void setSectionId(String sectionId) {
	        this.sectionId = sectionId;
	    }

	    public void setIsMandatory(Integer isMandatory) {
	        this.isMandatory = isMandatory;
	    }

	    public String getLableName() {
	        return lableName;
	    }

	    public void setLableName(String lableName) {
	        this.lableName = lableName;
	    }

	    public String getDefaultValue() {
	        return defaultValue;
	    }

	    public void setDefaultValue(String defaultValue) {
	        this.defaultValue = defaultValue;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public Integer isShow() {


	        return isShow;
	    }

	    public void setShow(Integer show) {
	        isShow = show;
	    }

	    public String getJsonForList() {
	        return jsonForList;
	    }

	    public void setJsonForList(String jsonForList) {
	        this.jsonForList = jsonForList;
	    }

	    public Integer getIsCorrigendum() {
	        return isCorrigendum;
	    }

	    public void setIsCorrigendum(Integer isCorrigendum) {
	        this.isCorrigendum = isCorrigendum;
	    }

	    public String getFieldKey() {
	        return fieldKey;
	    }

	    public void setFieldKey(String fieldKey) {
	        this.fieldKey = fieldKey;
	    }

	    public String getFieldType() {
	        return fieldType;
	    }

	    public void setFieldType(String fieldType) {
	        this.fieldType = fieldType;
	    }

	    public String getSectionName() {
	        return sectionName;
	    }

	    public void setSectionName(String sectionName) {
	        this.sectionName = sectionName;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        TblFieldViewDto that = (TblFieldViewDto) o;
	        return isShow == that.isShow &&
	            Objects.equals(lableName, that.lableName) &&
	            Objects.equals(defaultValue, that.defaultValue) &&
	            Objects.equals(description, that.description) &&
	            Objects.equals(jsonForList, that.jsonForList) &&
	            Objects.equals(isCorrigendum, that.isCorrigendum) &&
	            Objects.equals(fieldKey, that.fieldKey) &&
	            Objects.equals(fieldType, that.fieldType) &&
	            Objects.equals(sectionName, that.sectionName);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(lableName, defaultValue, description, isShow, jsonForList, isCorrigendum, fieldKey, fieldType, sectionName);
	    }

	    @Override
	    public String toString() {
	        return new StringJoiner(", ", TblFieldViewDto.class.getSimpleName() + "[", "]")
	            .add("lableName='" + lableName + "'")
	            .add("defaultValue='" + defaultValue + "'")
	            .add("description='" + description + "'")
	            .add("isShow=" + isShow)
	            .add("jsonForList='" + jsonForList + "'")
	            .add("isCorrigendum=" + isCorrigendum)
	            .add("fieldKey='" + fieldKey + "'")
	            .add("fieldType='" + fieldType + "'")
	            .add("sectionName='" + sectionName + "'")
	            .toString();
	    }
	   
	   
}
