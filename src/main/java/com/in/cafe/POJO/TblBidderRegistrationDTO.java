package com.in.cafe.POJO;

import java.util.Objects;


public class TblBidderRegistrationDTO {

	private TblUserLoginDto tblUserLoginDto;
	private TblCompanyDTO tblCompanyDTO;
	private AddBidderDTO addBidderDTO;
	
	
	public TblUserLoginDto getTblUserLoginDto() {
		return tblUserLoginDto;
	}
	public void setTblUserLoginDto(TblUserLoginDto tblUserLoginDto) {
		this.tblUserLoginDto = tblUserLoginDto;
	}
	public TblCompanyDTO getTblCompanyDTO() {
		return tblCompanyDTO;
	}
	public void setTblCompanyDTO(TblCompanyDTO tblCompanyDTO) {
		this.tblCompanyDTO = tblCompanyDTO;
	}
	public AddBidderDTO getAddBidderDTO() {
		return addBidderDTO;
	}
	public void setAddBidderDTO(AddBidderDTO addBidderDTO) {
		this.addBidderDTO = addBidderDTO;
	}
	
	public TblBidderRegistrationDTO() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(tblUserLoginDto, addBidderDTO,tblCompanyDTO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TblBidderRegistrationDTO)) {
			return false;
		}
		TblBidderRegistrationDTO other = (TblBidderRegistrationDTO) obj;
		return Objects.equals(addBidderDTO, other.addBidderDTO)
				&& Objects.equals(tblCompanyDTO, other.tblCompanyDTO)
				&& Objects.equals(tblUserLoginDto, other.tblUserLoginDto);
	}

}
