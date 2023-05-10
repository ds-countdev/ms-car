package mx.com.ms.car.service.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.repository.entity.CarEntity;
import mx.com.ms.car.repository.entity.CarTypeEntity;

@Component
public class CarPostServiceMapper {

	public CarEntity car_model_to_car_entity(CarPostRequest car_post_request, CarTypeEntity car_type) {
			String [] format_date = car_post_request.getData().getCar_form().getCreated().split("/");
		
		return CarEntity.builder()
				.car_model(car_post_request.getData().getCar_form().getModel())
				.car_color(car_post_request.getData().getCar_form().getColor().toUpperCase())
				.car_type(car_type)
				.car_velocity(Double.parseDouble(car_post_request.getData().getCar_form().getMax_velocity()))
				.created_date(LocalDate.of(
						Integer.parseInt(format_date[2]), 
						Integer.parseInt(format_date[1]),  
						Integer.parseInt(format_date[0])))
				.registry_date(LocalDate.now())
						.build();
	}
}
