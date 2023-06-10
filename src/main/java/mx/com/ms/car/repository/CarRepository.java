package mx.com.ms.car.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.ms.car.repository.entity.CarColorEntity;
import mx.com.ms.car.repository.entity.CarEntity;
import mx.com.ms.car.repository.entity.CarTypeEntity;

	public interface CarRepository extends JpaRepository<CarEntity, Long> {
		
		@Query("SELECT c From CarEntity c WHERE c.id= :car_id")
		public Optional<CarEntity> find_car(@Param("car_id") Long car_id);
		
		@Query("SELECT c FROM CarTypeEntity c WHERE c.name = UPPER(:car_type)")
		public Optional<CarTypeEntity> find_car_type(@Param("car_type") String car_type);
		
		@Query("SELECT c FROM CarColorEntity c WHERE c.name = UPPER(:car_color)")
		public Optional<CarColorEntity> find_car_color(@Param("car_color") String car_color);
		
	}
