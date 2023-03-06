package com.healthcheck;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
class HealthCheckApplicationTests {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void healthCheckTest() throws Exception {
		
		mockMvc.perform(get("/api/health").param("format","short").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(jsonPath("$.status",is("OK")));
		
		
	}
	
	@Test
	void fullHealthCheckTest() throws Exception {
				
		mockMvc.perform(get("/api/health").param("format","full").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(jsonPath("$.currentdate").isNotEmpty());
		
		
	}

}
