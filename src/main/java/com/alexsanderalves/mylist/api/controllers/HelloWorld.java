package com.alexsanderalves.mylist.api.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorld {

	@GetMapping("/helloworld")
	public String hello(@RequestHeader HttpHeaders headers) {
		System.out.println(headers);
		return "Olá mundo!";
	}
	
}
