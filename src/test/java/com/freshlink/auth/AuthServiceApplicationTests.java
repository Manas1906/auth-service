package com.freshlink.auth;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(properties = {
		"spring.datasource.url=jdbc:h2:mem:test",
		"spring.datasource.driverClassName=org.h2.Driver",
		"spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
		"spring.jpa.hibernate.ddl-auto=create-drop",
		"auth.jwt.secret=testsecretkeytestsecretkeytestsecret!"
})
class AuthServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
