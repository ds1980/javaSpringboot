package com.in.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.cafe.dao.GenericDao;
import com.in.cafe.domain.TblCustomeparameter;
@Repository
public interface TblCustomeparameterRepository extends JpaRepository<TblCustomeparameter, Long>, GenericDao {

}
