package com.in.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.cafe.domain.TblCountry;


@Repository
public interface TblCountryRepository extends JpaRepository<TblCountry, Long> {

}