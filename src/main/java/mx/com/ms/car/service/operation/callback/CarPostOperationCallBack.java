package mx.com.ms.car.service.operation.callback;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.repository.CarRepository;
import mx.com.ms.car.repository.entity.CarEntity;
import mx.com.ms.car.repository.entity.CarTypeEntity;
import mx.com.ms.car.service.mapper.CarPostServiceMapper;

@Component
public class CarPostOperationCallBack {

	@Autowired
	private CarPostServiceMapper car_post_service_mapper;
	
	@Autowired
	private CarRepository car_repository;
	
	public CarEntity operation_callback_handler(CarPostRequest car_post_request) {
		Optional<CarTypeEntity> car_type_entity = car_repository.find_car_type(car_post_request
				.getData()
				.getCar_form()
				.getType().toUpperCase());
		return car_repository.save(operation_model_to_entity_mapper(car_post_request, car_type_entity.get()));
	}
	
	private CarEntity operation_model_to_entity_mapper(CarPostRequest car_post_request, CarTypeEntity car_type) {
		return car_post_service_mapper.car_model_to_car_entity(car_post_request,car_type);
	}
}
