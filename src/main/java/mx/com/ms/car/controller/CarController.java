package mx.com.ms.car.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import mx.com.ms.car.model.CarGetResponse;
import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.model.CarPostResponse;

public interface CarController {
	
	@GetMapping("/car/{car_id}")
	public ResponseEntity<CarGetResponse> get_car(@PathVariable("car_id") String car_id);
	

	@PostMapping(value = "/car")
	public ResponseEntity<CarPostResponse> insert_car(@Valid @RequestBody CarPostRequest car_post_request) throws InterruptedException, ExecutionException;

}
