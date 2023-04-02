package com.in.cafe.restImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.in.cafe.POJO.Bill;
import com.in.cafe.constants.CafeConstants;
import com.in.cafe.rest.BillRest;
import com.in.cafe.service.BillService;
import com.in.cafe.utils.CafeUtils;

@Controller
public class BillRestImpl implements BillRest {
	
	@Autowired
	BillService billService;
	@Override
	public ResponseEntity<String> generateReport(Map<String, Object> requestMap) {
		try {
			return billService.getGenerateReport(requestMap);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@Override
	public ResponseEntity<List<Bill>> getBills() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ResponseEntity<byte[]> getPdf(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		try {
			return billService.getpdf(requestMap);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
