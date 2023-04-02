package com.in.cafe.restImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.cafe.POJO.ApiResponse;
import com.in.cafe.dto.IntDto;
import com.in.cafe.service.TblClientService;
import com.in.cafe.service.TblCountryService;
import com.in.cafe.utils.ResponseUtil;

@RestController
public class CommonController {

	@Autowired
	TblCountryService tblCountryService;
	
	@Autowired
	TblClientService tblClientService;
	
	@GetMapping("api/country")
	public ResponseEntity<ApiResponse> getCountryList() {
		return ResponseUtil.getResponse(HttpStatus.OK, "Country List",
		this.tblCountryService.getCountryList());
	}
	
	@GetMapping("api/country/{id}")
	public ResponseEntity<ApiResponse> getCountryById(@PathVariable Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, "Country",
		this.tblCountryService.findOne(id));
	}
	
	@PostMapping("/api/getsubmodulebyclient")
	public ResponseEntity<ApiResponse> getSubModuleByClient(@RequestBody IntDto intDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, "Fetch SubModule List", tblClientService.getSubmoduleList(intDto.getId()));	
	}
}
