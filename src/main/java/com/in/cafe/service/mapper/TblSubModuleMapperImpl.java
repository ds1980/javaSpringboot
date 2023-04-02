package com.in.cafe.service.mapper;



import javax.annotation.Generated;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.cafe.domain.TblModule;
import com.in.cafe.domain.TblSubModule;
import com.in.cafe.dto.TblSubModuleDto;

@Component
public class TblSubModuleMapperImpl implements TblSubModuleMapper {

	@Override
	public TblSubModule toEntity(TblSubModuleDto dto) {
		// TODO Auto-generated method stub
		if (dto == null) {
			return null;
		}
		TblSubModule tblSubModule = new TblSubModule();
		BeanUtils.copyProperties(dto, tblSubModule);
		tblSubModule.setTblModule(new TblModule(dto.getModuleId()));
		return tblSubModule;
	}

	@Override
	public TblSubModuleDto toDto(TblSubModule entity) {
		if (entity == null) {
			return null;
		}
		TblSubModuleDto tblSubModuleDto = new TblSubModuleDto();
		// BeanUtils.copyProperties(entity, tblSubModuleDto);
		tblSubModuleDto.setActiveStatus(entity.getActiveStatus());
		tblSubModuleDto.setSubModuleId(entity.getSubModuleId());
		tblSubModuleDto.setModuleId(entity.getTblModule().getModuleId());
		tblSubModuleDto.setSubModuleName(entity.getSubModuleName());
		return tblSubModuleDto;
	}

}
