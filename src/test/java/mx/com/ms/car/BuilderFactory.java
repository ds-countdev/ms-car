package mx.com.ms.car;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import mx.com.ms.car.model.Car;
import mx.com.ms.car.model.CarForm;
import mx.com.ms.car.model.CarGetResponse;
import mx.com.ms.car.model.CarGetResponseData;
import mx.com.ms.car.model.CarPostRequest;
import mx.com.ms.car.model.CarPostRequestData;
import mx.com.ms.car.model.CarPostResponse;
import mx.com.ms.car.model.CarPostResponseData;
import mx.com.ms.car.model.Status;
import mx.com.ms.car.repository.entity.CarColorEntity;
import mx.com.ms.car.repository.entity.CarEntity;
import mx.com.ms.car.repository.entity.CarTypeEntity;

public class BuilderFactory {
	
	public static String create_car_id() {
		return "1";
	}

	public static CarPostRequest create_car_post_request() {
		return CarPostRequest.builder()
				.data(CarPostRequestData.builder()
						.car_form(create_car_form())
						.build()).build();
	}
	
	public static CarForm create_car_form() {
		return CarForm.builder()
				.model("F33")
				.color("blue")
				.max_velocity("200.34")
				.type("sedan")
				.created("23/11/1993")
				.build();
	}
	
	public static Car create_car() {
		return Car.builder()
				.model("F33")
				.color("blue")
				.max_velocity("200.34")
				.type("Sport")
				.created("23/11/1992")
				.build();
	}
	
	public static CarEntity create_car_entity() {
		return CarEntity.builder()
				.id(4L)
				.car_model("F33")
				.car_color(create_car_color_entity())
				.created_date(LocalDate.of(1993, 11, 23))
				.car_type(create_car_type_entity())
				.car_velocity(300.33)
				.build();
				
	}
	
	public static CarTypeEntity create_car_type_entity() {
		return CarTypeEntity.builder()
				.car_type_id(4L)
				.name("SPORT")
				.description("Big car to 4 passangers")
				.build();
	}
	
	public static CarColorEntity create_car_color_entity() {
		return CarColorEntity.builder()
				.car_color_id(4L)
				.name("BLUE")
				.description("Color Blue")
				.build();
	}
	
	public static CarPostResponseData create_car_post_response_data() {
		return CarPostResponseData.builder()
				.car_id(4L)
				.build();
	}
	
	public static CarGetResponseData create_car_get_response_data() {
		return CarGetResponseData.builder()
				.car(create_car())
				.build();
	}
	
	public static CarPostResponse create_car_post_response() {
		return CarPostResponse.builder().data(create_car_post_response_data())
				.status(create_status()).build();
	}
	
	
	public static Status create_status() {
		return Status.builder()
				.description("Success Insert")
				.status_code(200)
				.build();
	}
	
	public static ResponseEntity<CarGetResponse> create_car_get_response(){
				CarGetResponse car_get_response = CarGetResponse.builder()
				.status(Status.builder().description("Success Get").build())
				.data(create_car_get_response_data())
				.build();
				
				return ResponseEntity.ok(car_get_response);
	}
	
	public static ResponseEntity<CarPostResponse> create_response_entity_car_post_response(){
		return ResponseEntity.status(HttpStatus.OK).body(create_car_post_response());
	}
}
