package com.in.cafe.dto;

import java.util.List;

public class CommonViewField {
	 private List<TblFieldViewDto> tblFieldViewDto;
	    private TblSectionDto tblSectionDto;

	    public List<TblFieldViewDto> getTblFieldViewDto() {
	        return tblFieldViewDto;
	    }

	    public void setTblFieldViewDto(List<TblFieldViewDto> tblFieldViewDto) {
	        this.tblFieldViewDto = tblFieldViewDto;
	    }

	    public TblSectionDto getTblSectionDto() {
	        return tblSectionDto;
	    }

	    public void setTblSectionDto(TblSectionDto tblSectionDto) {
	        this.tblSectionDto = tblSectionDto;
	    }
}
