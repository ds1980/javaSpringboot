package com.in.cafe.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.in.cafe.JWT.JwtFilter;
import com.in.cafe.constants.CafeConstants;
import com.in.cafe.dao.CategoryDao;
import com.in.cafe.domain.Category;
import com.in.cafe.service.CategoryService;
import com.in.cafe.utils.CafeUtils;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	JwtFilter jwtFilter;

	@Override
	public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			if (jwtFilter.isAdmin()) {
				if (validateCategoryMap(requestMap, false)) {
					categoryDao.save(getCategoryFromMap(requestMap, false));
					return CafeUtils.getresponseEntity("Record Added Successfully", HttpStatus.OK);
				}

			} else {
				return CafeUtils.getresponseEntity(CafeConstants.UNAUTHRIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean validateCategoryMap(Map<String, String> requestMap, boolean validateId) {
		if (requestMap.containsKey("name")) {
			if (requestMap.containsKey("id") && validateId) {
				return true;
			} else if (!validateId) {
				return true;
			}
		}
		return false;
		// TODO Auto-generated method stub
	}

	private Category getCategoryFromMap(Map<String, String> requestMap, Boolean isAdd) {
		Category category = new Category();
//		if (isAdd) {
//			category1(Integer.parseInt(requestMap.get("id")));
//		}
//		
//		category.setCategoryTitle(requestMap.get("name"));
//		return category;
		return category;
	}

	@Override
	public ResponseEntity<List<Category>> geAllCategory(String filterValue) {
		// TODO Auto-generated method stub
		try {
			if (!Strings.isNullOrEmpty(filterValue) && filterValue.equalsIgnoreCase("true")) {
			//	return new ResponseEntity<List<Category>>(categoryDao.getAllCategories(), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Category>>(categoryDao.findAll(), HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Category>>(new ArrayList<Category>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updateCategory(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			System.out.println(jwtFilter.isAdmin());
			if (jwtFilter.isAdmin()) {
				if(validateCategoryMap(requestMap, true)) {
				Optional<Category> optional = categoryDao.findById(Integer.parseInt(requestMap.get("id")));
				if (!optional.isEmpty()) {
					categoryDao.save(getCategoryFromMap(requestMap, true));
					return CafeUtils.getresponseEntity("Category updated successfully", HttpStatus.OK);
				} else {
					return CafeUtils.getresponseEntity(CafeConstants.DATA_DOES_NOT_EXIST, HttpStatus.OK);
				}
			} else {
				return CafeUtils.getresponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
			} else {
				return CafeUtils.getresponseEntity(CafeConstants.UNAUTHRIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
