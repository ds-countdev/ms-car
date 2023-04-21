package mx.com.ms.car.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarFormTest {
	
	private CarForm car_form;
	
	@BeforeEach
	public void create_car_object() {
		car_form= CarForm.builder()
				.model("F33")
				.color("Blue")
				.type("Sport")
				.created("23/11/1994")
				.max_velocity("200")
				.build();
	}
	
	@Test
	@DisplayName("model_pattern_test")
	void car_model_validation_patter() {
		assertTrue(
				Pattern
					.compile("^[A-Z][a-zA-Z0-9]+\\s?[0-9]{0,4}$")
					.matcher(car_form.getModel())
						.find());
	}
	
	@Test
	@DisplayName("color_pattern_test")
	void car_color_validation_pattern() {
		assertTrue(
				Pattern
					.compile("^[a-zA-Z]{0,12}$")
					.matcher(car_form.getColor())
						.find());
	}

	@Test
	@DisplayName("velocity_pattern_test")
	void car_velocity_validation_pattern() {
		assertTrue(
				Pattern
					.compile("^\\d{2,3}(.\\d{1,2})*$")
					.matcher(car_form.getMax_velocity().toString())
						.find());
	}
	
	@Test
	@DisplayName("type_pattern_test")
	void car_type_validation_pattern() {
		assertTrue(
				Pattern
					.compile("^[a-zA-Z]{1,10}$")
					.matcher(car_form.getType().toString())
						.find());
	}
	
	@Test
	@DisplayName("created_pattern_test")
	void car_created_validation_pattern() {
		assertTrue(
				Pattern
					.compile("^((?:3[01]|[12][0-9]|0?[1-9])[\\/-]){2}\\d{4}$")
					.matcher(car_form.getCreated().toString())
						.find());
	}

}
