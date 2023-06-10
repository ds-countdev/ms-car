package mx.com.ms.car.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.com.ms.car.service.operation.callback.CarGetOperationCallBack;
import mx.com.ms.car.service.operation.response.CarGetOperationResponse;

@ExtendWith(MockitoExtension.class)
class CarGetServiceTest {
	
	@InjectMocks
	private CarGetService car_get_service;
	
	@Mock
	private CarGetOperationCallBack car_call_back;
	
	@Mock
	private CarGetOperationResponse car_response;

	@Test
	void test_for_get_car_when_car_exist() {
		
	}

}
