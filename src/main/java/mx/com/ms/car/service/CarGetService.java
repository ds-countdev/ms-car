package mx.com.ms.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.ms.car.model.Car;
import mx.com.ms.car.model.CarGetResponse;
import mx.com.ms.car.service.operation.callback.CarGetOperationCallBack;
import mx.com.ms.car.service.operation.response.CarGetOperationResponse;

@Service
public class CarGetService {
	
	@Autowired
	private CarGetOperationCallBack callback;
	
	@Autowired
	private CarGetOperationResponse response;

	public ResponseEntity<CarGetResponse> get_service(String car_id) {
		Car car = callback.operation_callback_handler(car_id);
		return response.operation_success_response(car);
	}

}
