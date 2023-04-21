package mx.com.ms.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.model.CarPostResponse;
import mx.com.ms.car.service.CarPostService;

@RestController
public class CarControllerImpl implements CarController {
	
	@Autowired
	private CarPostService car_post_service;

	@Override
	public ResponseEntity<CarPostResponse> insert_car(@Valid CarPostRequest car_post_request) {
		return car_post_service.post_service(car_post_request);
	}

}
