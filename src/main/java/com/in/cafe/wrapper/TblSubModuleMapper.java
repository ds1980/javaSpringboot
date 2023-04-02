package com.in.cafe.wrapper;

import org.mapstruct.Mapper;

import com.in.cafe.domain.TblSubModule;
import com.in.cafe.dto.TblSubModuleDto;
import com.in.cafe.wrapper.EntityMapper;

/**
 * Mapper for the entity {@link SubModule} and its DTO {@link SubModuleDTO}.
// */
@Mapper(componentModel = "spring", uses = {})
public interface TblSubModuleMapper extends EntityMapper<TblSubModuleDto, TblSubModule> {
	
	default TblSubModule fromId(int id) {
		TblSubModule SubModule = new TblSubModule();
		SubModule.setSubModuleId(id);
		return SubModule;
	}
}
