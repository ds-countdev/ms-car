package mx.com.ms.car.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarForm {
	
	@Valid
	@NotNull
	@Pattern(regexp = "^[A-Z][a-zA-Z0-9]+\\s?[0-9]{0,4}$")
	private String model;
	
	@Valid
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]{0,12}$")
	private String color;
	
	@Valid 
	@NotNull
	@Pattern(regexp = "^\\d{2,3}(.\\d{1,2})*$")
	private String max_velocity;
	
	@Valid
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]{1,10}$")
	private String type;
	
	@Valid
	@NotNull
	@Pattern(regexp = "^((?:3[01]|[12][0-9]|0?[1-9])[\\/-]){2}\\d{4}$")
	private String created;
	

}
