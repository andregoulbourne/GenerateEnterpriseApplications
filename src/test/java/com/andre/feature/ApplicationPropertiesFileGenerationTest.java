package com.andre.feature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.andre.generations.ApplicationProperitiesFileGeneration;

public class ApplicationPropertiesFileGenerationTest {

	ApplicationProperitiesFileGeneration generator = new ApplicationProperitiesFileGeneration("testdb", "username", "password");
	
	@Test
	public void testPropertiesFileForH2IsGenerated() {
		assertEquals("# Temporary db\r\n"
				+ "spring.h2.console.enabled=true\r\n"
				+ "spring.datasource.url=jdbc:h2:mem:testdb\r\n"
				+ "spring.datasource.driverClassName=org.h2.Driver\r\n"
				+ "spring.datasource.username=username\r\n"
				+ "spring.datasource.password=password\r\n"
				+ "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "# Hosted on port\r\n"
				+ "server.port=8081", generator.getH2PropertyFile() );
	}
	
	@Test
	public void testPropertiesFileForPostgresSqlDb() {
		assertEquals("# Hosted on port\r\n"
				+ "server.port=8081\r\n"
				+ "\r\n"
				+ "# Database credentials\r\n"
				+ "spring.datasource.driver-class-name=org.postgresql.Driver\r\n"
				+ "spring.datasource.url=${DB_URL}\r\n"
				+ "spring.datasource.username=${DB_USER}\r\n"
				+ "spring.datasource.password=${DB_PASS}\r\n"
				+ "spring.jpa.hibernate.ddl-auto=update\r\n"
				+ "spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true\r\n"
				+ "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect\r\n"
				+ "\r\n"
				+ "# Static file hosting\r\n"
				+ "spring.servlet.multipart.max-file-size = -1\r\n"
				+ "spring.servlet.multipart.max-request-size = -1\r\n"
				+ "spring.mvc.servlet.path=/",generator.getPostgresPropertyFile());
	}
	
}
