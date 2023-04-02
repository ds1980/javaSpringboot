package com.in.cafe.service.mapper;

import org.mapstruct.Mapper;

import com.in.cafe.POJO.TblCountryDto;
import com.in.cafe.domain.TblCountry;
import com.in.cafe.wrapper.EntityMapper;

@Mapper(componentModel = "spring", uses = {})
public interface TblCountryMapper extends EntityMapper<TblCountryDto, TblCountry>{
	
	default TblCountry fromId(long id) {
		
		TblCountry Country = new TblCountry();
		Country.setCountryId(id);
		return Country;
	}
}
