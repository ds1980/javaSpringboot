package com.in.cafe.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.cafe.POJO.TblUserLogin;
import com.in.cafe.POJO.TblUserLoginDto;
import com.in.cafe.constants.CafeConstants;
import com.in.cafe.dao.TblUserRepository;
import com.in.cafe.utils.RandomUtil;



@Service
@Transactional
public class BidderUserService {
	private final Logger log = LoggerFactory.getLogger(BidderUserService.class);
	private final TblUserRepository tblUserRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public BidderUserService(PasswordEncoder passwordEncoder,  TblUserRepository tblUserRepository) {
		this.passwordEncoder = passwordEncoder;
		this.tblUserRepository = tblUserRepository;
	}
	public TblUserLogin createUser(TblUserLoginDto tblUserLoginDto) {
		TblUserLogin tbluserlogin = new TblUserLogin();
		tbluserlogin.setLogin(tblUserLoginDto.getLogin());
		tbluserlogin.setFirstName(tblUserLoginDto.getFirstName());
		tbluserlogin.setLastName(tblUserLoginDto.getLastName());
		tbluserlogin.setEmail(tblUserLoginDto.getEmail().toLowerCase());
		tbluserlogin.setImageUrl(tblUserLoginDto.getImageUrl());
		
		if(tblUserLoginDto.getLangKey() == null) {
			tbluserlogin.setLangKey(CafeConstants.DEFAULT_LANGUAGE);
		} else {
			tbluserlogin.setLangKey(tblUserLoginDto.getLangKey());
		}
		String encryptPassWord = this.passwordEncoder.encode(tblUserLoginDto.getPassword());
		tbluserlogin.setPassword(encryptPassWord);
		
		tbluserlogin.setActivated(false);
		String generateRandomKey = RandomUtil.generateActivationKey();
		tbluserlogin.setActivationKey(generateRandomKey);
		tbluserlogin.setResetKey(generateRandomKey);
		tbluserlogin.setIsFirstLogin(1);
		tbluserlogin.setFailedPassAttempts(0);
		tbluserlogin.setIsEmailVerify(0);
		tbluserlogin.setIsMobileNoVerify(0);
		tbluserlogin.setMobileNo(tblUserLoginDto.getMobileNo());
		tbluserlogin.setFailedPassAttempts(0);
		tblUserRepository.save(tbluserlogin);
		return tbluserlogin;
	}
}
