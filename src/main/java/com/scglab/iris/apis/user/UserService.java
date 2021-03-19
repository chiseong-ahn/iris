package com.scglab.iris.apis.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scglab.iris.apis.common.PageDto;
import com.scglab.iris.apis.common.PageService;

@Service
public class UserService {

	@Autowired private UserRepository userRepository;
	@Autowired private PageService pageService;

	public List<UserEntity> findAll() {
		return this.userRepository.findAll();
	}
	
	public List<UserEntity> findAllWithPaging(PageDto pageDto) {
		return this.userRepository.findAll(this.pageService.getPageable(pageDto)).getContent();
	}

	public UserEntity findById(long id) {
		if(this.userRepository.existsById(id)) {
			return this.userRepository.findById(id).get();
		}
		return null;
	}

	public UserEntity save(UserEntity user) {
		return this.userRepository.save(user);
	}

	public UserEntity updateById(long id, UserEntity paramUser) {
		if (this.userRepository.existsById(id)) {
			UserEntity user = this.userRepository.findById(id).get();
			user.setEmail(paramUser.getEmail());
			user.setName(paramUser.getName());
			this.userRepository.save(user);
			return user;
		}
		return null;
	}

	public void deleteById(long id) {
		if (this.userRepository.existsById(id)) {
			this.userRepository.deleteById(id);
		}
	}
}
