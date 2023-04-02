package com.in.cafe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.cafe.POJO.TblCountryDto;
import com.in.cafe.domain.TblCountry;
import com.in.cafe.repository.TblCountryRepository;
import com.in.cafe.service.TblCountryService;
import com.in.cafe.service.mapper.TblCountryMapper;

@Service
@Transactional
public class TblCountryServiceImpl implements TblCountryService {
	private final Logger log = LoggerFactory.getLogger(TblCountryServiceImpl.class);
	private final TblCountryMapper tblCountryMapper;
	private final TblCountryRepository tblCountryRepository;
	
	public TblCountryServiceImpl(TblCountryMapper tblCountryMapper, TblCountryRepository tblCountryRepository ) {
		this.tblCountryRepository = tblCountryRepository;
		this.tblCountryMapper = tblCountryMapper;
	}
	@Override
	public TblCountryDto save(TblCountryDto countryDTO) {
		// TODO Auto-generated method stub
		log.debug("Request to save Country : {}", countryDTO);
		TblCountry country = this.tblCountryMapper.toEntity(countryDTO);
		country = this.tblCountryRepository.save(country);
	    return this.tblCountryMapper.toDto(country);
	}

	@Override
	public List<TblCountry> getCountryList() {
		return tblCountryRepository.findAll();
	}
	@Override
	public Optional<TblCountry> findOne(Long id) {
		return tblCountryRepository.findById(id);
	
	}

}
