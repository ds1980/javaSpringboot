package com.in.cafe.service.mapper;

import org.springframework.stereotype.Component;

import com.in.cafe.POJO.TblCountryDto;
import com.in.cafe.domain.TblCountry;

@Component
public class TblCountryMapperImpl implements TblCountryMapper {

	@Override
	public TblCountry toEntity(TblCountryDto dto) {
		if(dto == null) {
			return null;
		}
		// TODO Auto-generated method stub
		TblCountry tblCountry = new TblCountry();
		tblCountry.setCountryId(dto.getCountryId());
		tblCountry.setSortname(dto.getSortname());
		tblCountry.setCountryName(dto.getCountryName());
		tblCountry.setLang1(dto.getLang1());
		tblCountry.setLang2(dto.getLang2());
		tblCountry.setLang3(dto.getLang3());
		tblCountry.setLang4(dto.getLang4());
		tblCountry.setLang5(dto.getLang5());
		tblCountry.setLang6(dto.getLang6());
		tblCountry.setLang7(dto.getLang7());
		return tblCountry;
	}

	@Override
	public TblCountryDto toDto(TblCountry entity) {
		if(entity == null) {
			return null;
		}
		TblCountryDto tblCountryDto = new TblCountryDto();
		tblCountryDto.setCountryId(tblCountryDto.getCountryId());
		tblCountryDto.setCountryName(entity.getCountryName());
		tblCountryDto.setLang1(entity.getLang1());
		tblCountryDto.setLang2(entity.getLang2());
		tblCountryDto.setLang3(entity.getLang3());
		tblCountryDto.setLang4(entity.getLang4());
		tblCountryDto.setLang5(entity.getLang5());
		tblCountryDto.setLang6(entity.getLang6());
		tblCountryDto.setLang7(entity.getLang7());
		// TODO Auto-generated method stub
		return tblCountryDto;
	}

}
