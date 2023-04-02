package com.in.cafe.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.in.cafe.dao.CategoryDao;
import com.in.cafe.dao.ProductDao;
import com.in.cafe.service.DashboardService;
@Service
public class DashaboardServiceImpl implements DashboardService {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao ProductDao;
	
	@Override
	public ResponseEntity<Map<String, Object>> getCount() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("category", categoryDao.count());
		map.put("product", ProductDao.count());
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}

}
