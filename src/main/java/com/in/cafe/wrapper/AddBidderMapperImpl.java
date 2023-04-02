package com.in.cafe.wrapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.cafe.POJO.AddBidderDTO;
import com.in.cafe.POJO.TblUserLogin;
import com.in.cafe.constants.CafeConstants;
import com.in.cafe.domain.TblBidder;
import com.in.cafe.domain.TblCompany;

@Service
@Transactional
public class AddBidderMapperImpl implements AddBidderMapper {

	@Override
	public TblBidder toEntity(AddBidderDTO dto) {
		// TODO Auto-generated method stub
		 TblBidder  addBidder = new TblBidder();
		 addBidder.setBidderId((long) Integer.parseInt(dto.getBidderId().toString()));
		 addBidder.setTblCompany(new TblCompany(dto.getCompanyId()));
		 addBidder.setCategory(dto.getCategory());
	     addBidder.setRemarks(dto.getRemarks());
	     addBidder.setApprovedOn(dto.getApprovedOn());
	     if(dto.getApprovedBy() != null) {
	            addBidder.setApprovedBy(Integer.parseInt(dto.getApprovedBy().toString()));
	        }
	     // addBidder.setClientId(SecurityUtils.getClientId());
	        addBidder.setActiveStatus(CafeConstants.IN_ACTIVE_STATUS);
	        addBidder.setTblUserlogins(new TblUserLogin(dto.getUserId()));
	        addBidder.setCreatedOn(dto.getCreatedOn());
	        addBidder.setCreatedBy(dto.getCreatedBy());
	        addBidder.setTimeZoneId(dto.getTimeZoneId());
			return addBidder;
	}
	
	 
	  
	 
	@Override
	public AddBidderDTO toDto(TblBidder entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
