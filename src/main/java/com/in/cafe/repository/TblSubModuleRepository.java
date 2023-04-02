package com.in.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.cafe.domain.TblSubModule;

@Repository
public interface TblSubModuleRepository extends JpaRepository<TblSubModule, Integer> {
	
}
