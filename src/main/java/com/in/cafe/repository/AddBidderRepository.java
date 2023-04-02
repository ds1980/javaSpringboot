package com.in.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.cafe.domain.TblBidder;

@SuppressWarnings("unused")
@Repository
public interface AddBidderRepository extends JpaRepository<TblBidder, Long> {
	List<TblBidder> findAllByClientIdAndActiveStatus(Long clientId, int activeStatus);


	@Modifying
	@Query(value = "update TblBidder t set t.activeStatus=?1  where t.bidderId=?2")
	int updateStatus(int status, long id);


	List<TblBidder> findAllByClientId(Long clientId);


	@Query(value = "select ul.email,cc.companyName,ul.firstName,ul.lastName "
			+ "from TblUserLogin ul join TblCompany cc on cc.userId = ul.id where ul.id "
			+ "= :userId ")
	List<Object[]> getBidderdetailByUserId(@Param("userId") Long userId);

	TblBidder findByTblUserloginsIdAndClientIdAndActiveStatus(long userId, long clientId, int activeStatus);


    TblBidder findByBidderIdAndClientId(long id, Long clientId);
    
    
    TblBidder findByTblUserloginsIdAndClientId(long userId, Long clientId);
}
