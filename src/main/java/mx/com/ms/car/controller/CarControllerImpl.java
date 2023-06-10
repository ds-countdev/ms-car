package mx.com.ms.car.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mx.com.ms.car.model.CarGetResponse;
import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.model.CarPostResponse;
import mx.com.ms.car.service.CarGetService;
import mx.com.ms.car.service.CarPostService;

@RestController
public class CarControllerImpl implements CarController {
	
	@Autowired
	private CarPostService car_post_service;
	
	@Autowired
	private CarGetService car_get_service;

	@Override
	public ResponseEntity<CarPostResponse> insert_car(@Valid CarPostRequest car_post_request) throws InterruptedException, ExecutionException {
		return car_post_service.post_service(car_post_request);
	}

	@Override
	public ResponseEntity<CarGetResponse> get_car(String car_id) {
		return car_get_service.get_service(car_id);
	}

}
