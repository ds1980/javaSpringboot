package com.in.cafe.restImpl;


import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import com.in.cafe.rest.DashboardRest;
import com.in.cafe.service.DashboardService;

@Controller
public class DahsBoardRestImpl implements DashboardRest {

	@Autowired
	DashboardService dashboardService;
	@Override
	public ResponseEntity<Map<String, Object>> getCount() {
		try {
			return dashboardService.getCount();
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return new ResponseEntity<Map<String, Object>>(new HashMap<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
