package com.andre.generations;

public class GenerateNotFoundException {
	
	public String getNotFoundException() {
		return "package com.Appointments.exceptions;\r\n"
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
				+ "";
	}

}
