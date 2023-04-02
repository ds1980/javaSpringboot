package com.in.cafe.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.cafe.constants.CafeConstants;
import com.in.cafe.domain.TblSubModule;
import com.in.cafe.dto.TblSubModuleDto;
import com.in.cafe.repository.TblClientModuleRepository;
import com.in.cafe.repository.TblSubModuleRepository;
import com.in.cafe.service.TblClientService;
import com.in.cafe.service.mapper.TblSubModuleMapper;
import com.in.cafe.JWT.JwtFilter;

@Service
@Transactional
public class TblClientServiceImpl implements TblClientService {
	private final TblSubModuleMapper tblSubModuleMapper;
	@Autowired 
	TblClientModuleRepository tblClientModuleRepository;
	
	 @Autowired
	 TblSubModuleRepository tblSubModuleRepository;
	
	@Autowired
	 JwtFilter JwtFilter;
	
	 TblClientServiceImpl(TblSubModuleMapper tblSubModuleMapper) {
		 this.tblSubModuleMapper = tblSubModuleMapper;
	 }
	@Override
	public List<TblSubModuleDto> getSubmoduleList(Integer id) {
		System.out.println(id+ " " + JwtFilter.getUserId() + " "+CafeConstants.ACTIVE_STATUS);
		List<Integer> tblsubModule = tblClientModuleRepository.getSubModuleId(id, (long)JwtFilter.getUserId(), CafeConstants.ACTIVE_STATUS);
		List<TblSubModule> tblSubModules = tblSubModuleRepository.findAllById(tblsubModule);
		return this.tblSubModuleMapper.toDto(tblSubModules);
		// return null;
	}

}
