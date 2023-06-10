package mx.com.ms.car.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import mx.com.ms.car.BuilderFactory;
import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.model.CarPostResponse;
import mx.com.ms.car.repository.entity.CarEntity;
import mx.com.ms.car.service.operation.callback.CarPostOperationCallBack;
import mx.com.ms.car.service.operation.response.CarPostOperationResponse;

@ExtendWith(MockitoExtension.class)
class CarPostServiceTest {

	@InjectMocks
	private CarPostService service;
	
	@Mock
	private CarPostOperationCallBack callback;
	
	@Mock
	private CarPostOperationResponse response;
	
	@Test
	void test_for_car_service_when_insert_car() throws InterruptedException, ExecutionException {
		Long car_id = 4L;
		CarEntity car_entity = BuilderFactory.create_car_entity();
		CarPostRequest car_request = BuilderFactory.create_car_post_request();
		ResponseEntity<CarPostResponse> car_response = BuilderFactory.create_response_entity_car_post_response();
		
		when(callback.operation_callback_handler(car_request)).thenReturn(car_entity);
		when(response.operation_response(car_id)).thenReturn(car_response);
		
		ResponseEntity<CarPostResponse> response = service.post_service(car_request);
		
		assertAll(
				()-> assertEquals(HttpStatus.OK.value(), response.getStatusCode().value()),
				()-> assertEquals("Success Insert", response.getBody().getStatus().getDescription()));
	}

}
