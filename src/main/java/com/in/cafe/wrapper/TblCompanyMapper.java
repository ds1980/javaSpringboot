package com.in.cafe.wrapper;

import org.mapstruct.Mapper;

import com.in.cafe.POJO.TblCompanyDTO;
import com.in.cafe.domain.TblCompany;
/**
*
*w
*/
/**
* Mapper for the entity {@link TblCompany} and its DTO {@link TblCompanyDTO}.
*/
@Mapper(componentModel = "spring", uses = {})
public interface TblCompanyMapper extends EntityMapper<TblCompanyDTO, TblCompany> {
	
	default TblCompany fromId(Long id) {
		if (id == 0) {
			return null;
		}
		TblCompany tblCompany = new TblCompany();
		tblCompany.setCompanyId(id);
		return tblCompany;
	}
}
