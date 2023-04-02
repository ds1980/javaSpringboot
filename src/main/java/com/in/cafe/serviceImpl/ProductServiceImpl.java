package com.in.cafe.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.in.cafe.JWT.JwtFilter;
import com.in.cafe.POJO.Product;
import com.in.cafe.constants.CafeConstants;
import com.in.cafe.dao.ProductDao;
import com.in.cafe.domain.Category;
import com.in.cafe.service.ProductService;
import com.in.cafe.utils.CafeUtils;
import com.in.cafe.wrapper.ProductWrapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	JwtFilter jwtFilter;
	@Override
	public ResponseEntity<String> addProduct(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			if(jwtFilter.isAdmin()) {
				if(validateProductMap(requestMap, false)) {
					productDao.save(getProductFromMap(requestMap, false));
					return CafeUtils.getresponseEntity("Product added successfully", HttpStatus.OK);
				} else {
					return CafeUtils.getresponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
				}
			} else {
				return CafeUtils.getresponseEntity(CafeConstants.UNAUTHRIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.BAD_REQUEST);
		
		
	}
	 // get validation 
	private boolean validateProductMap(Map<String, String> requestMap, boolean isValidId) {
		if(requestMap.containsKey("name") && requestMap.containsKey("price")
			&& requestMap.containsKey("price") && requestMap.containsKey("description")
		) {
			if(requestMap.containsKey("id") && isValidId) {
				return true;
			} else if(!isValidId) {
				return true;
			}
		}
		return false;
	}
	
	// add and get product from Map
	
	public Product getProductFromMap(Map<String, String> requestMap, boolean isUpdate) {
		Product product = new Product();
		Category category = new Category();
		// category.setCategoryId(Integer.parseInt(requestMap.get("categoryId")));
		category.setId(Integer.parseInt(requestMap.get("categoryId")));
		if(isUpdate) {
			product.setId(Integer.parseInt(requestMap.get("id")));
			product.setStatus(requestMap.get("status"));
		} else {
			product.setStatus("true");
		}
		System.out.println(requestMap);
		product.setName(requestMap.get("name"));
		product.setDescription(requestMap.get("description"));
		product.setPrice(Integer.parseInt(requestMap.get("price")));
		product.setCategory(category);
		return product;
	}

	@Override
	public ResponseEntity<List<ProductWrapper>> GetAllProducts() {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<List<ProductWrapper>>(productDao.getAllProduct(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<ProductWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// update products
	@Override
	public ResponseEntity<String> updateProduct(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			if(jwtFilter.isAdmin()) {
				if(validateProductMap(requestMap, true)) {
					Optional<Product> optional = productDao.findById(Integer.parseInt(requestMap.get("id")));
					if(!optional.isEmpty()) {
						Product product = getProductFromMap(requestMap, true);
						
						product.setStatus(optional.get().getStatus());
						productDao.save(product);
						return CafeUtils.getresponseEntity("Data successfully updated", HttpStatus.OK);
					} else {
						return CafeUtils.getresponseEntity("Product id does not exist", HttpStatus.OK);
					}
				} else {
					return CafeUtils.getresponseEntity("Product id does not exist", HttpStatus.BAD_REQUEST);
				}
			} else {
				return CafeUtils.getresponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<String> deleteProduct(int productId) {
		try {
			if(jwtFilter.isAdmin()) {
				Optional<Product> optinal = productDao.findById(productId);
				if(!optinal.isEmpty()) {
					productDao.deleteById(productId);
					return CafeUtils.getresponseEntity("Data successfully deleted", HttpStatus.OK);
				} else {
					return CafeUtils.getresponseEntity("Product id does not exist", HttpStatus.OK);
				}
			} else {
				return CafeUtils.getresponseEntity(CafeConstants.UNAUTHRIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<String> updateProdctStatus(Map<String, String> requestMap) {
		
		try {
			if(jwtFilter.isAdmin()) {
			 Optional<Product> optional = productDao.findById(Integer.parseInt(requestMap.get("id")));
			 if(!optional.isEmpty()) {
				 productDao.updateProductStatus(requestMap.get("status"), Integer.parseInt(requestMap.get("id")));
				 return CafeUtils.getresponseEntity("Status updated successfully", HttpStatus.OK);
			 } else {
				 return CafeUtils.getresponseEntity("Product id does not exist", HttpStatus.OK);
			 }
				
			} else {
				return CafeUtils.getresponseEntity(CafeConstants.UNAUTHRIZED_ACCESS, HttpStatus.UNAUTHORIZED);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<List<ProductWrapper>>getByCategory(int id) {
		try {
			if(jwtFilter.isAdmin()) {
				return new ResponseEntity<>(productDao.getProductByCategory(id), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<ProductWrapper>>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return new ResponseEntity<List<ProductWrapper>>(new ArrayList<ProductWrapper>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public ResponseEntity<ProductWrapper> getProductById(int id) {
		try {
			return new ResponseEntity<>(productDao.getProductById(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<ProductWrapper>(new ProductWrapper(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
}
