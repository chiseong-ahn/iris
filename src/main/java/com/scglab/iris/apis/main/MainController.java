package com.scglab.iris.apis.main;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MainController {
	
	@Value("${spring.devtools.restart.enabled}")
	private String devtools;
	
	@RequestMapping("/")
	public String index() {
		System.out.println("devtools : " + this.devtools);
		return "Hello iris";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
}
