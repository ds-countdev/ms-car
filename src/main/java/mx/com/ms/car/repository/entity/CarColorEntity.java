package mx.com.ms.car.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_color")
public class CarColorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long car_color_id;
	
	@Column(length = 30, nullable = true)
	private String name; 
	
	@Column(length = 100, nullable = true)
	private String description;

}
