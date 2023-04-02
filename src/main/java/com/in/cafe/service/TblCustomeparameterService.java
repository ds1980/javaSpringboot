package com.in.cafe.service;

import java.util.List;

import com.in.cafe.dto.CommonViewField;


public interface TblCustomeparameterService {
	List<CommonViewField> getFieldListBySuMobuleId(long id);
}
