package com.scglab.iris.apis.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scglab.iris.apis.common.PageDto;
import com.scglab.iris.base.annotations.Authority;

@RestController
@RequestMapping("/apis/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Authority(role = Authority.Role.ADMIN)
	@GetMapping
	public ResponseEntity<List<UserEntity>> findAll(PageDto pageDto){
		return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
	}
	
	@Authority(role = Authority.Role.MEMBER)
	@GetMapping("/paging")
	public ResponseEntity<List<UserEntity>> findAllWithPaging(PageDto pageDto){
		return new ResponseEntity<>(this.userService.findAllWithPaging(pageDto), HttpStatus.OK);
	}
	
	@Authority(role = Authority.Role.MEMBER)
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> findById(@PathVariable long id){
		return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
	}
	
	@Authority(role = Authority.Role.MEMBER)
	@PostMapping
	public ResponseEntity<UserEntity> save(@RequestBody UserEntity user){
		return new ResponseEntity<>(this.userService.save(user), HttpStatus.CREATED);
	}
	
	@Authority(role = Authority.Role.MEMBER)
	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateById(@PathVariable long id, @RequestBody UserEntity user){
		return new ResponseEntity<>(this.userService.updateById(id, user), HttpStatus.OK);
	}
	
	@Authority(role = Authority.Role.MEMBER)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		this.userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
