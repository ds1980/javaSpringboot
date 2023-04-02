package com.in.cafe.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.cafe.dao.GenericDao;
import com.in.cafe.domain.TblClientmodule;

@Repository
public interface TblClientModuleRepository extends JpaRepository <TblClientmodule, Long>, GenericDao{
	@Query(value = "select distinct  e.tblSubModule.subModuleId from TblClientmodule e where e.tblClient.clientId=:clientId and e.tblModule.moduleId =:moduleId and e.activeStatus=:activeStatus ")
	List<Integer> getSubModuleId(@Param("moduleId") Integer moduleId, @Param("clientId") Long clientId,
			@Param("activeStatus") int activeStatus);
}
