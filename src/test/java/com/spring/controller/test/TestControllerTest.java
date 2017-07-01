package com.spring.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.spring.controller.test.controller.TestController;
import com.spring.controller.test.controller.domain.ControllerRequest;



@RunWith(MockitoJUnitRunner.class)
public class TestControllerTest {
	
	private MockMvc mockMvc;
	private TestController underTest;
	private ControllerRequest request;
	private String requestJson;
	
	@Before
	public void init(){
		underTest = new TestController();
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
		
		request = new ControllerRequest();
		request.setName("name");
		request.setEmail("user@server.com");
		
		Gson gson = new Gson();
		requestJson = gson.toJson(request);
	}
	
	@Test
	public void controllerTest_WithRightParam_ShouldReturnOk() throws Exception{
		mockMvc.perform(post("/test")
				.contentType(MediaType.APPLICATION_JSON).content(requestJson))
	            .andExpect(status().isOk());
	}
}
