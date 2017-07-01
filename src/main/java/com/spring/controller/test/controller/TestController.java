package com.spring.controller.test.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		validate(request);
		ControllerResponse response = new ControllerResponse();
		response.setName(request.getName());
		response.setEmail(request.getEmail());
		
		System.out.println(response);
		
		return response;
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Empty name or email!")
	@ExceptionHandler(IllegalArgumentException.class)
	public void handleRequestValidationError(){
	}
	
	private void validate(ControllerRequest request) throws IllegalArgumentException{
		if (StringUtils.isBlank(request.getEmail()) || StringUtils.isBlank(request.getName())){
				throw new IllegalArgumentException();
		}
	}
}