package mx.com.ms.car.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.model.CarPostResponse;

public interface CarController {

	@PostMapping(value = "/car")
	public ResponseEntity<CarPostResponse> insert_car(@Valid @RequestBody CarPostRequest car_post_request);

}
