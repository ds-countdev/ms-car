package mx.com.ms.car.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarPostResponse {
	
	@JsonProperty("status")
	private Status status;

	@JsonProperty("data")
	private CarPostResponseData data;
	
}
