package com.in.cafe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.in.cafe.POJO.Product;
import com.in.cafe.wrapper.ProductWrapper;

public interface ProductDao extends JpaRepository<Product, Integer> {
	 List<ProductWrapper> getAllProduct();
	 @Modifying
	 @Transactional
	 int updateProductStatus(@Param("status") String status, @Param("id") int id);
	 List<ProductWrapper> getProductByCategory(@Param("id") int id);
	 ProductWrapper getProductById(@Param("id") int id);
}
