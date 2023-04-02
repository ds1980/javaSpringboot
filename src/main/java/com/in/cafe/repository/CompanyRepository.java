package com.in.cafe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.in.cafe.domain.TblCompany;

@Repository
public interface CompanyRepository extends JpaRepository<TblCompany, Integer>{
	TblCompany findByUserIdEquals(Long userId);
	TblCompany findByCompanyId(Long companyId);
}
