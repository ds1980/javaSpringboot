package com.in.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.cafe.domain.TblSection;
@Repository
public interface TblSectionRepository extends JpaRepository<TblSection, Long> {
	List<TblSection> findBySubmoduleIdAndActiveStatus(Long submoduleId, int activeStatus);
}
