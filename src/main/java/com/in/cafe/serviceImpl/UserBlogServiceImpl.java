package com.in.cafe.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.in.cafe.domain.BlogUser;
import com.in.cafe.dto.BlogUserDto;
import com.in.cafe.exceptions.ResourceNotFoundException;
import com.in.cafe.service.UserBlogService;
import com.in.cafe.repository.UserBlogRepository;

@Service
public class UserBlogServiceImpl implements UserBlogService {
	
	@Autowired
	UserBlogRepository  userBlogRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public BlogUserDto createUser(BlogUserDto userDto) {
		
		BlogUser blogUser =  this.dtoTouser(userDto);
		BlogUser savedBlogUser = this.userBlogRepository.save(blogUser);
		BlogUserDto savedBlogUserDto = this.userToDto(savedBlogUser);
		
	 return savedBlogUserDto;	
		
	}

	@Override
	public BlogUserDto updateUser(BlogUserDto userDto, Integer userId) {
		BlogUser user = userBlogRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", " id ", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		BlogUser saveduser = userBlogRepository.save(user);
		return this.userToDto(saveduser);
	}

	@Override
	public BlogUserDto getUserById(Integer userId) {
		BlogUser getuser = userBlogRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", " id ", userId));
		return this.userToDto(getuser);
	}

	@Override
	public List<BlogUserDto> getAllUser() {
		List<BlogUser> blogUsers = userBlogRepository.findAll();
		List<BlogUserDto> usersDto = blogUsers.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return usersDto;
	}

	@Override
	public void deleteUser(Integer userid) {
		BlogUser blogUser = userBlogRepository.findById(userid).orElseThrow(() -> new ResourceNotFoundException("user", "id", userid));
		this.userBlogRepository.delete(blogUser);
		// TODO Auto-generated method stub
		
	}
	
	public BlogUser dtoTouser(BlogUserDto userDto) {
		BlogUser bloguser = this.modelmapper.map(userDto, BlogUser.class);
		
//		bloguser.setId(userDto.getId());
//		bloguser.setName(userDto.getName());
//		bloguser.setEmail(userDto.getEmail());
//		bloguser.setAbout(userDto.getAbout());
//		bloguser.setPassword(userDto.getPassword());
		return bloguser;
	}
	
	public BlogUserDto userToDto(BlogUser bloguser) {
		BlogUserDto blogUserDto = this.modelmapper.map(bloguser, BlogUserDto.class);
//		BlogUserDto blogUserDto = new BlogUserDto();
//		blogUserDto.setId(bloguser.getId());
//		blogUserDto.setName(bloguser.getName());
//		blogUserDto.setPassword(bloguser.getPassword());
//		blogUserDto.setEmail(bloguser.getEmail());
//		blogUserDto.setAbout(bloguser.getAbout());
		return blogUserDto;
	}

}
