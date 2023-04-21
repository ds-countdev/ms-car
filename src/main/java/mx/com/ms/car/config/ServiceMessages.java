package mx.com.ms.car.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class ServiceMessages {
	
	@Value("${message.service.success.insert}")
	public String message_insert;

}
