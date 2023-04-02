package com.in.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.cafe.POJO.Bill;
@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	 List<Bill>getAllBills();
	 List<Bill> getBillByUserName(@Param("username") String username);
}