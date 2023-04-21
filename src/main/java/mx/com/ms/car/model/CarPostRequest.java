package mx.com.ms.car.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarPostRequest {

	@Valid
	@NotNull
	@JsonProperty("data")
	private CarPostRequestData data;
	
}
