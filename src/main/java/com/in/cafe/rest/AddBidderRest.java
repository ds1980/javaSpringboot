package com.in.cafe.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.in.cafe.POJO.TblBidderRegistrationDTO;

@RequestMapping(path="/bidder")
public interface AddBidderRest {
	 @PostMapping(path="/add")
	 public ResponseEntity<TblBidderRegistrationDTO> createBidder(@RequestBody TblBidderRegistrationDTO tblBidderRegistrationDTO);
	 
}
