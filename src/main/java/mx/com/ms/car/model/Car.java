package mx.com.ms.car.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

	private String model;
	private String color;
	private String max_velocity;
	private String type;
	private String created;
}
