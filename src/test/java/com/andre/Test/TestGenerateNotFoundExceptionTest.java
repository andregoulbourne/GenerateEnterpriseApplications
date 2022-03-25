package com.andre.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.andre.testgeneration.TestGenerateNotFoundException;

public class TestGenerateNotFoundExceptionTest {
	
	TestGenerateNotFoundException generator;
	
	@Before
	public void setup() {
		this.generator = new TestGenerateNotFoundException();
	}
	
	@Test
	public void testGeneratedTestForNotFoundException() {
		assertEquals("import static org.junit.jupiter.api.Assertions.assertThrows;\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "import org.junit.jupiter.api.Test;\r\n"
				+ "\r\n"
				+ "import com.Appointments.exceptions.NotFoundException;\r\n"
				+ "\r\n"
				+ "public class NotFoundExceptionTest {\r\n"
				+ "		\r\n"
				+ "/*	@Test(expected=NotFoundException.class)\r\n"
				+ "	public void testCanThrowNotFoundException(){\r\n"
				+ "		throw new NotFoundException();\r\n"
				+ "	}	*/\r\n"
				+ "	\r\n"
				+ "	@Test\r\n"
				+ "	public void testCanThrowNotFoundException() {\r\n"
				+ "		assertThrows(NotFoundException.class, () -> {\r\n"
				+ "			throw new NotFoundException();\r\n"
				+ "		});\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "}", generator.getNotFoundExceptionTest());
	}

}
