package com.in.cafe.restImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.cafe.POJO.ApiResponse;
import com.in.cafe.dto.IntDto;
import com.in.cafe.service.TblCustomeparameterService;
import com.in.cafe.utils.ResponseUtil;

@RestController
@RequestMapping("/api")
public class TblFieldController {
	
	@Autowired
	TblCustomeparameterService tblCustomeparameterService;
	
    @PostMapping("/modulefield")
    ResponseEntity<ApiResponse> getFieldForForm(@RequestBody IntDto  idDto) {
    	System.out.println(idDto.getId());
    	 return  ResponseUtil.getResponse(HttpStatus.OK, "Field List", tblCustomeparameterService.getFieldListBySuMobuleId(idDto.getId()));
    }
}
