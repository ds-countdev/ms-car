package mx.com.ms.car.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static mx.com.ms.car.BuilderFactory.create_car_post_request;
import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.service.CarPostService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CarControllerImpl.class)
class CarControllerImplTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper object_mapper;
	
	@MockBean
	private CarPostService car_post_service;

	@Test
	void test_for_car_post_when_bad_request() throws JsonProcessingException, Exception{
		//HttpHeaders request_headers = new HttpHeaders();
		CarPostRequest car_post_request = create_car_post_request();
		MvcResult mvc_result = mvc.perform(
				MockMvcRequestBuilders.post("/car")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(object_mapper.writeValueAsString(car_post_request)))
				.andExpect(status().isOk())
				.andReturn();
		
		int status_code = mvc_result.getResponse().getStatus();

		assertEquals(status_code, HttpStatus.OK.value());

		
	}

}
