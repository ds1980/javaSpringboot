package com.in.cafe.restImpl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.in.cafe.POJO.TblBidderRegistrationDTO;
import com.in.cafe.rest.AddBidderRest;
import com.in.cafe.service.AddBidderService;

@RestController
public class AddBidderRestImpl implements AddBidderRest {
	  private final Logger log = LoggerFactory.getLogger(AddBidderRest.class);
	  
	  @Autowired
	  private AddBidderService addBidderService;
	  
	@Override
	public ResponseEntity<TblBidderRegistrationDTO> createBidder(TblBidderRegistrationDTO tblBidderRegistrationDTO) {
		// TODO Auto-generated method stub
		try {
			log.info("REST request to save TblBidder : {}", tblBidderRegistrationDTO);
			TblBidderRegistrationDTO result = this.addBidderService.save(tblBidderRegistrationDTO);
			return ResponseEntity.created(new URI("/api/add-bidders/" + result.getTblUserLoginDto())).body(result);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<TblBidderRegistrationDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	


	

}
