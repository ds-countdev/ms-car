package mx.com.ms.car.service.operation.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import mx.com.ms.car.config.ServiceMessages;
import mx.com.ms.car.model.CarPostResponse;
import mx.com.ms.car.model.CarPostResponseData;
import mx.com.ms.car.model.Status;

@Component
public class CarPostOperationResponse {
	
	@Autowired
	private ServiceMessages service_messages;
	
	public ResponseEntity<CarPostResponse> operation_response(Long car_id){
		
		Status status = Status.builder()
				.status_code(HttpStatus.OK.value())
				.description(service_messages.getMessage_insert())
				.build();
		
		CarPostResponseData car_post_response_data = CarPostResponseData.builder()
				.car_id(car_id)
				.build();
		
		CarPostResponse car_post_response = CarPostResponse.builder()
				.data(car_post_response_data)
				.status(status)
				.build();
				
		return ResponseEntity.ok(car_post_response);
	}

}
