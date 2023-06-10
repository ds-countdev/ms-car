package mx.com.ms.car.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarGetResponse {
	
	@JsonProperty("status")
	private Status status;
	
	@JsonProperty("data")
	private CarGetResponseData data;

}
