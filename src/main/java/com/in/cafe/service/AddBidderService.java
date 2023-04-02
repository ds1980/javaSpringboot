package com.in.cafe.service;

import com.in.cafe.POJO.AddBidderDTO;
import com.in.cafe.POJO.TblBidderRegistrationDTO;

public interface AddBidderService {
	AddBidderDTO save(AddBidderDTO addbidderDTO);
	TblBidderRegistrationDTO save(TblBidderRegistrationDTO tblBidderRegistrationDTO);
}
