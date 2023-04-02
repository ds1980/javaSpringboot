package com.in.cafe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in.cafe.POJO.TblUserLogin;
@Repository
@Transactional
public interface TblUserRepository extends JpaRepository<TblUserLogin, Long>{

}
