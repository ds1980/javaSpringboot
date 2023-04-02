package com.in.cafe.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.cafe.domain.TblUserdetail;

@Repository
@Transactional
public interface TblUserdetailRepository extends JpaRepository<TblUserdetail, Long> {
	@Query(value="select MAX(ud.userdetailId) from TblUserdetail ud where ud.userId = :userid")
	Long getUSerDetailIdByuserId(@Param("userid") Long userid);
}
