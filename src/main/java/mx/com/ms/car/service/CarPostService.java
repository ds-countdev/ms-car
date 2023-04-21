	package mx.com.ms.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.model.CarPostResponse;
import mx.com.ms.car.repository.entity.CarEntity;
import mx.com.ms.car.service.operation.callback.CarPostOperationCallBack;
import mx.com.ms.car.service.operation.response.CarPostOperationResponse;

@Service
public class CarPostService {

	@Autowired
	private CarPostOperationCallBack call_back;
	
	@Autowired
	private CarPostOperationResponse response;
	
	public ResponseEntity<CarPostResponse> post_service(CarPostRequest car_post_request){
		
		CarEntity car_entity = call_back.operation_callback_handler(car_post_request);
		return response.operation_response(car_entity.getId());
	}
}
