package mx.com.ms.car.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.ms.car.repository.entity.CarEntity;
import mx.com.ms.car.repository.entity.CarTypeEntity;

	public interface CarRepository extends JpaRepository<CarEntity, Long> {
		
		@Query("SELECT c FROM CarTypeEntity c WHERE c.name = :car_type")
		public Optional<CarTypeEntity> find_car_type(@Param("car_type") String car_type);
		
	}
