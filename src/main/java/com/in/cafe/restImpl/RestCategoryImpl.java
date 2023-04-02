package com.in.cafe.restImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.in.cafe.constants.CafeConstants;
import com.in.cafe.domain.Category;
import com.in.cafe.rest.RestCategory;
import com.in.cafe.service.CategoryService;
import com.in.cafe.utils.CafeUtils;

@RestController
public class RestCategoryImpl implements RestCategory {

	@Autowired
	CategoryService categoryService;
	
	@Override
	public ResponseEntity<List<Category>> geAllCategory(String filterValue) {
		// TODO Auto-generated method stub
		try {
			return categoryService.geAllCategory(filterValue);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			return categoryService.addNewCategory(requestMap);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updateCategory(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		
		try {
			return categoryService.updateCategory(requestMap);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
