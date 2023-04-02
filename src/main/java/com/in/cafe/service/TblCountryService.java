package com.in.cafe.service;

import java.util.List;
import java.util.Optional;

import com.in.cafe.POJO.TblCountryDto;
import com.in.cafe.domain.TblCountry;

public interface TblCountryService {
	
	TblCountryDto save(TblCountryDto countryDTO);
	
	List<TblCountry> getCountryList();
	Optional<TblCountry> findOne(Long id);
}
