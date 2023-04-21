package mx.com.ms.car.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Status {
	
	@NotNull
	@JsonProperty("status_code")
	private Integer status_code;
	
	@NotBlank
	@JsonProperty("description")
	private String description;

}
