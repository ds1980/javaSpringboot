package com.in.cafe.restImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.in.cafe.constants.CafeConstants;
import com.in.cafe.rest.ProductRest;
import com.in.cafe.service.ProductService;
import com.in.cafe.utils.CafeUtils;
import com.in.cafe.wrapper.ProductWrapper;

@Controller
public class ProductRestImpl implements ProductRest {

	@Autowired
	ProductService productService;
	@Override
	public ResponseEntity<String> addProduct(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			return productService.addProduct(requestMap);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@Override
	public ResponseEntity<List<ProductWrapper>> getAllProduct() {
		try {
			 return productService.GetAllProducts();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return new ResponseEntity<List<ProductWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<String> updateproduct(Map<String, String> requestMap) {
		try {
			return productService.updateProduct(requestMap);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<String> deleteProduct(int productId) {
		try {
			 return productService.deleteProduct(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<String> updateStatus(Map<String, String> requestMap) {
		try {
			return productService.updateProdctStatus(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<List<ProductWrapper>> getByCategory(int id) {
		// TODO Auto-generated method stub
		try {
			return productService.getByCategory(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<List<ProductWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<ProductWrapper> getProductById(int id) {
		// TODO Auto-generated method stub
		try {
			return productService.getProductById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<ProductWrapper>(new ProductWrapper(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
