package com.spring.controller.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.controller.test.controller.domain.ControllerRequest;
import com.spring.controller.test.controller.domain.ControllerResponse;

@RestController
public class TestController {
	
	@RequestMapping("/test")
	@ResponseStatus(HttpStatus.OK)
	public ControllerResponse controllerTest(@RequestBody ControllerRequest request){
		ControllerResponse response = new ControllerResponse();
		response.setName(request.getName());
		response.setEmail(request.getEmail());
		
		System.out.println(response);
		
		return response;
	}
}