package mx.com.ms.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import mx.com.errors.handler.controller.ErrorHandlerController;
import mx.com.errors.handler.model.MessageProperties;
import mx.com.errors.handler.util.Utilities;

@SpringBootApplication
@Import(value = {ErrorHandlerController.class, Utilities.class, MessageProperties.class})
public class MsCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCarApplication.class, args);
	}

}
