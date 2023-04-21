package mx.com.ms.car.service.operation.response;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import mx.com.ms.car.config.ServiceMessages;
import mx.com.ms.car.model.CarPostResponse;

@ExtendWith(MockitoExtension.class)
class CarPostOperationResponseTest {

	@InjectMocks
	private CarPostOperationResponse car_post_operation_response;
	
	@Mock
	private ServiceMessages service_messages;
	
	@Test
	void test() {
		
		Long car_id = 4L;
		
		when(service_messages.getMessage_insert()).thenReturn("Success Insert");
		
		ResponseEntity<CarPostResponse> response = car_post_operation_response.operation_response(car_id);
		
		assertAll(
				()-> assertEquals(200, response.getBody().getStatus().getStatus_code()),
				()-> assertEquals("Success Insert", response.getBody().getStatus().getDescription()))
		;
	}

}
