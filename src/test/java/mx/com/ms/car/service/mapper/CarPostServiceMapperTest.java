package mx.com.ms.car.service.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static mx.com.ms.car.BuilderFactory.create_car_post_request;
import static mx.com.ms.car.BuilderFactory.create_car_type_entity;
import static mx.com.ms.car.BuilderFactory.create_car_color_entity;
import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.repository.entity.CarColorEntity;
import mx.com.ms.car.repository.entity.CarEntity;
import mx.com.ms.car.repository.entity.CarTypeEntity;

@ExtendWith(MockitoExtension.class)
class CarPostServiceMapperTest {
	
	@InjectMocks
	private CarPostServiceMapper car_post_service_mapper;
	

	@Test
	void test_for_car_model_to_car_entity() {
		CarPostRequest car_post_request = create_car_post_request();
		CarTypeEntity car_type_entity = create_car_type_entity();
		CarColorEntity car_color_entity = create_car_color_entity();
		
		
		CarEntity car_entity = car_post_service_mapper
				.car_model_to_car_entity(car_post_request,car_type_entity, car_color_entity);
		
		assertAll(
				()-> assertNotNull(car_entity),
				()-> assertNotNull(car_type_entity),
				()-> assertEquals("F33",car_entity.getCar_model()),
				()-> assertEquals("1993-11-23",car_entity.getCreated_date().toString()),
				()-> assertEquals("BLUE", car_entity.getCar_color().getName().toString()),
				()-> assertEquals("200.34", car_entity.getCar_velocity().toString()),
				()-> assertEquals("SPORT", car_entity.getCar_type().getName().toString())
				);
	}

}
