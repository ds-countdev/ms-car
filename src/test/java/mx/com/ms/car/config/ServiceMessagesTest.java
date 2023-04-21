package mx.com.ms.car.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@SpringBootConfiguration
@TestPropertySource(properties = {
	    "message.service.success.insert = Success Insert"
	})
class ServiceMessagesTest {
		
		@Value("${message.service.success.insert}")
		private String message_insert;
	

	@Test
	void test_for_create_service_message() {
		assertEquals("Success Insert", message_insert);
	}

}
