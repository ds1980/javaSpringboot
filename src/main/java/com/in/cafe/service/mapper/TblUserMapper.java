package com.in.cafe.service.mapper;

import org.springframework.stereotype.Service;

import com.in.cafe.POJO.TblUserLoginDto;
import com.in.cafe.POJO.TblUserLogin;

@Service
public class TblUserMapper {
	public TblUserLoginDto userToUserDTO(TblUserLogin tblUserEntity) {
		return new TblUserLoginDto(tblUserEntity);
	}
}
