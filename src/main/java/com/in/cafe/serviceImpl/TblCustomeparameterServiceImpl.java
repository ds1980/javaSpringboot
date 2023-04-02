package com.in.cafe.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.cafe.JWT.JwtFilter;
import com.in.cafe.constants.CafeConstants;
import com.in.cafe.domain.TblSection;
import com.in.cafe.dto.CommonViewField;
import com.in.cafe.dto.TblSectionDto;
import com.in.cafe.repository.TblCustomeparameterRepository;
import com.in.cafe.repository.TblSectionRepository;
import com.in.cafe.service.TblCustomeparameterService;
import com.in.cafe.utils.QueryConstant;


@Service
@Transactional
public class TblCustomeparameterServiceImpl implements TblCustomeparameterService {

	@Autowired
	TblSectionRepository tblSectionRepository;
	
	@Autowired
	 JwtFilter JwtFilter;
	
	@Autowired
	TblCustomeparameterRepository tblCustomeparameterRepository;
	@Override
	public List<CommonViewField> getFieldListBySuMobuleId(long id) {
		List<TblSection> tblSection = tblSectionRepository.findBySubmoduleIdAndActiveStatus(id, CafeConstants.ACTIVE_STATUS);
		List<CommonViewField> list = new ArrayList<>();
		Map<String, Object> map = new HashMap();
		map.put("clientId", JwtFilter.getUserId());
		map.put("subModuleId", id);
		tblSection.forEach((section) -> {
		TblSectionDto tblSectionDto = new TblSectionDto();
		CommonViewField commonViewField = new CommonViewField();
		tblSectionDto.setActiveStatus(section.getActiveStatus());
		tblSectionDto.setSectionId(section.getSectionId());
		tblSectionDto.setSectionName(section.getSectionName());
		tblSectionDto.setSubmoduleId(section.getSubmoduleId());
		commonViewField.setTblSectionDto(tblSectionDto);
		map.put("section_Id", section.getSectionId());
		 List<Object[]> objects = tblCustomeparameterRepository.createSQLQuery(QueryConstant.getFieldQueryBySubModuleId(), map);
		list.add(commonViewField);
		
	});
		return list;
	}
	
//	@Autowired
//	TblSectionRepository tblSectionRepository;
//	
//	@Autowired
//	 JwtFilter JwtFilter;
//	
//	@Autowired
//	// TblCustomeparameterRepository tblCustomeparameterRepository;
//	@Override
//	public List<CommonViewField> getFieldListBySuMobuleId(long id) {
//		List<TblSection> tblSection = tblSectionRepository.findBySubmoduleIdAndActiveStatus(id, CafeConstants.ACTIVE_STATUS);
//		List<CommonViewField> list = new ArrayList<>();
//		Map<String, Object> map = new HashMap();
//		map.put("clientId", JwtFilter.getUserId());
//		map.put("subModuleId", id);
//		tblSection.forEach((section) -> {
//			
//			TblSectionDto tblSectionDto = new TblSectionDto();
//			CommonViewField commonViewField = new CommonViewField();
//			tblSectionDto.setActiveStatus(section.getActiveStatus());
//			tblSectionDto.setSectionId(section.getSectionId());
//			tblSectionDto.setSectionName(section.getSectionName());
//			tblSectionDto.setSubmoduleId(section.getSubmoduleId());
//			commonViewField.setTblSectionDto(tblSectionDto);
//			map.put("section_Id", section.getSectionId());
//			// List<Object[]> objects = tblCustomeparameterRepository.createSQLQuery(QueryConstant.getFieldQueryBySubModuleId(), map);
//			//list.add(commonViewField);
//			
//		});
//		return list;
//	}

}
