package com.in.cafe.serviceImpl;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.cafe.POJO.AddBidderDTO;
import com.in.cafe.POJO.TblBidderRegistrationDTO;
import com.in.cafe.POJO.TblCompanyDTO;
import com.in.cafe.domain.TblUserdetail;
import com.in.cafe.repository.AddBidderRepository;
import com.in.cafe.repository.CompanyRepository;
import com.in.cafe.service.AddBidderService;
import com.in.cafe.service.BidderUserService;
import com.in.cafe.service.mapper.TblUserMapper;
import com.in.cafe.wrapper.AddBidderMapper;
import com.in.cafe.wrapper.TblCompanyMapper;
import com.in.cafe.repository.TblUserdetailRepository;




@Service
public class AddBidderServiceImpl implements AddBidderService {
	
	  private final Logger log = LoggerFactory.getLogger(AddBidderServiceImpl.class);
	   private final AddBidderRepository addBidderRepository;
	   private final AddBidderMapper addBidderMapper;

	  
	  TblCompanyMapper tblCompanyMapper;
	  
	  @Autowired
		private TblUserdetailRepository tblUserdetailRepository;
	  
	  @Autowired
	  private final CompanyRepository companyRepository;
	  
	  
	  @Autowired
	  private final TblUserMapper tblUserMapper;
	  
	  @Autowired
	  private BidderUserService bidderUserService;
	@Override
	public AddBidderDTO save(AddBidderDTO addbidderDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	public AddBidderServiceImpl(TblUserMapper tblUserMapper, CompanyRepository companyRepository, AddBidderMapper addBidderMapper, AddBidderRepository addBidderRepository) {
		this.tblUserMapper = tblUserMapper;
		this.companyRepository = companyRepository;
		 this.addBidderRepository = addBidderRepository;
		 this.addBidderMapper = addBidderMapper;
	}
	
	@Override
	public TblBidderRegistrationDTO save(TblBidderRegistrationDTO tblBidderRegistrationDTO) {
		// TODO Auto-generated method stub
		log.info("Service request to save TblBidder : {}", tblBidderRegistrationDTO);
		TblBidderRegistrationDTO returnDto = new TblBidderRegistrationDTO();
		// this.tblUserMapper.userToUserDTO(tblUserEntity);
		returnDto.setTblUserLoginDto(this.tblUserMapper.userToUserDTO(this.bidderUserService.createUser(tblBidderRegistrationDTO.getTblUserLoginDto())));
		
		
		// save company detail
		
		TblCompanyDTO tblCompanyDTO = tblBidderRegistrationDTO.getTblCompanyDTO();
		tblCompanyDTO.setUserId(returnDto.getTblUserLoginDto().getId());
		returnDto.setTblCompanyDTO(tblCompanyMapper.toDto(this.companyRepository.save(tblCompanyMapper.toEntity(tblCompanyDTO))));
		
		AddBidderDTO addBidderDTO = tblBidderRegistrationDTO.getAddBidderDTO();
		addBidderDTO.setUserId(returnDto.getTblUserLoginDto().getId());
		addBidderDTO.setCompanyId(returnDto.getTblCompanyDTO().getCompanyId());
		returnDto.setAddBidderDTO(addBidderMapper.toDto(addBidderRepository.save(this.addBidderMapper.toEntity(addBidderDTO))));
		TblUserdetail tblDetail = new TblUserdetail();
		tblDetail.setUsername(tblBidderRegistrationDTO.getTblCompanyDTO().getCompanyName());
		tblDetail.setCompanyname(tblBidderRegistrationDTO.getTblCompanyDTO().getCompanyName());
		// tblDetail.setCreatedBy(SecurityUtils.getCurrentUserId());
		tblDetail.setCreatedOn(Instant.now());
		tblDetail.setUserId(returnDto.getAddBidderDTO().getUserId());

		tblUserdetailRepository.save(tblDetail);
		//addBidderDTO.setClientURL(SecurityUtils.getClientinfo().getDomainName());
		
		//mailUtility.sendRegistrationConfirmation(addBidderDTO);

		return returnDto;
	}

}
