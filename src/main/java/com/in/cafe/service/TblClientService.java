package com.in.cafe.service;

import java.util.List;

import com.in.cafe.dto.TblSubModuleDto;

public interface TblClientService {
	List<TblSubModuleDto> getSubmoduleList(Integer id);
}
