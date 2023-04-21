package mx.com.ms.car.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarPostRequestData {
	
	@Valid
	@JsonProperty("car")
	private CarForm car_form;

}
