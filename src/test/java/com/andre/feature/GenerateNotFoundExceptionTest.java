
package com.andre.feature;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.andre.generations.GenerateNotFoundException;

public class GenerateNotFoundExceptionTest {
	
	GenerateNotFoundException generator;
	
	@Before
	public void setup() {
		this.generator = new GenerateNotFoundException();
	}
	
	@Test
	public void testNotFoundExceptionGenerateCorrectly() {
		assertEquals("package com.Appointments.exceptions;\r\n"
				+ "\r\n"
				+ "public class NotFoundException extends RuntimeException {\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "public NotFoundException() {\r\n"
				+ "  }\r\n"
				+ "\r\n"
				+ "  public NotFoundException(String message) {\r\n"
				+ "    super(message);\r\n"
				+ "  }\r\n"
				+ "\r\n"
				+ "  public NotFoundException(Throwable cause) {\r\n"
				+ "    super(cause);\r\n"
				+ "  }\r\n"
				+ "\r\n"
				+ "  public NotFoundException(String message, Throwable cause) {\r\n"
				+ "    super(message, cause);\r\n"
				+ "  }\r\n"
				+ "  \r\n"
				+ "}\r\n"
				+ "", generator.getNotFoundException());
	}
}
