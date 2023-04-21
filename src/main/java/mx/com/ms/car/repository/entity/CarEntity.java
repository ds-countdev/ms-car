package mx.com.ms.car.repository.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "car")
public class CarEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name ="model",length = 100,unique = false )
	private String car_model;
	
	@Column(nullable = false, name="color", length = 20, unique = false)
	private String car_color;
	
	@Column(nullable = false, name="velocity", length = 6, unique = false)
	private Double car_velocity;
	
	@OneToOne
	@JoinColumn(name = "car_type_id")
	private CarTypeEntity car_type;
	
	@Column(nullable = false, name ="created_car", length = 11, columnDefinition = "DATE")
	private LocalDate created_date;
	
	@Column(nullable = false, name="registry_car", length = 11)
	private LocalDate registry_date;
	
	

}
