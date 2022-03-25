package com.andre.testgeneration;

public class TestGenerateNotFoundException {

	public String getNotFoundExceptionTest() {
		return "import static org.junit.jupiter.api.Assertions.assertThrows;\r\n"
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
				+ "}";
	}
	
}
