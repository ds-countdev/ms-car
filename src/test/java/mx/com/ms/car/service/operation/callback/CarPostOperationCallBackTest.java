package mx.com.ms.car.service.operation.callback;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static mx.com.ms.car.BuilderFactory.create_car_entity;
import static mx.com.ms.car.BuilderFactory.create_car_post_request;
import static mx.com.ms.car.BuilderFactory.create_car_type_entity;
import static mx.com.ms.car.BuilderFactory.create_car_color_entity;
import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.repository.CarRepository;
import mx.com.ms.car.repository.entity.CarColorEntity;
import mx.com.ms.car.repository.entity.CarEntity;
import mx.com.ms.car.repository.entity.CarTypeEntity;
import mx.com.ms.car.service.mapper.CarPostServiceMapper;

@ExtendWith(MockitoExtension.class)
class CarPostOperationCallBackTest {
	
	@InjectMocks
	private CarPostOperationCallBack car_post_operation_callback;
	
	@Mock
	private CarPostServiceMapper car_post_service_mapper;
	
	@Mock
	private CarRepository car_repository;

	@Test
	@DisplayName("operation_callback_1")
	void test_for_operation_callback_when_insert() throws InterruptedException, ExecutionException {
		CarEntity car_entity = create_car_entity();
		CarTypeEntity car_type_entity = create_car_type_entity();
		CarColorEntity car_color_entity = create_car_color_entity();
		CarPostRequest car_post_request = create_car_post_request();
		
		when(car_repository.find_car_type(car_post_request.getData().getCar_form().getType()))
		.thenReturn(Optional.ofNullable(car_type_entity));
		
		when(car_repository.find_car_color(car_post_request.getData().getCar_form().getColor()))
		.thenReturn(Optional.ofNullable(car_color_entity));
		
		when(car_post_service_mapper.car_model_to_car_entity(car_post_request, car_type_entity, car_color_entity))
		.thenReturn(car_entity);
		
		when(car_repository.save(car_entity)).thenReturn(car_entity);
		
		CarEntity car_entity_response = car_post_operation_callback.operation_callback_handler(car_post_request);
		
		assertAll(
				()-> assertNotNull(car_entity_response),
				()-> assertEquals(4,car_entity_response.getId())
				);
	}
	


}
