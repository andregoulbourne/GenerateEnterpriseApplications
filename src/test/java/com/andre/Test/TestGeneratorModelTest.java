package com.andre.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.andre.testgeneration.GenerateTestModels;

public class TestGeneratorModelTest {
	GenerateTestModels generator;
	
	@Before
	public void setup() {
		List<String> types = Arrays.asList("int", "String");
		List<String> names = Arrays.asList("id", "name");
		List<String> values = Arrays.asList("1", "andre");
		this.generator = new GenerateTestModels("TestGenerate", types , names , values);
	}
	
	@Test
	public void testToTestListOfFieldasSting() {
		String expected = "1,\"andre\"";
		assertEquals(expected, generator.arrayToStringListFields(generator.getValues()));
	}
	
	@Test
	public void testGenerateMethod_ReturnsValidGeneratedTestClass() {
		String expectedResult = "public class TestGenerateTest {\r\n"
				+ "	TestGenerate testGenerate;\r\n"
				+ "	\r\n"
				+ "	@Before\r\n"
				+ "	public void setup() {\r\n"
				+ "		this.testGenerate = new TestGenerate(1,\"andre\");\r\n"
				+ "	}\r\n";
		String result = generator.getTestSetUp();
		assertEquals(expectedResult, result);		
	}
	
	@Test
	public void testGenerateModelTest_fieldsGetterAndSetterTest() {
		String expected = "@Test\r\n"
				+ "public void  testGetterAndSetters_setAnotherName(){ \r\n"
				+ "  String expectedResult = \"andre\"; \r\n"
				+ "  testGenerate.setName(\"andre\"); \r\n"
				+ "  assertEquals(expectedResult, testGenerate.getName());      \r\n"
				+ " }\r\n"
				+"\r\n";
		assertEquals(expected, generator.getGetterSetterTest("String", "name", "andre"));
	}
	
	@Test
	public void testGenerateModels_GetterSetterAll() {
		String expected = "@Test\r\n"
				+ "public void  testGetterAndSetters_setAnotherId(){ \r\n"
				+ "  int expectedResult = 1; \r\n"
				+ "  testGenerate.setId(1); \r\n"
				+ "  assertEquals(expectedResult, testGenerate.getId());      \r\n"
				+ " }\r\n"
				+"\r\n"
				+"@Test\r\n"
				+ "public void  testGetterAndSetters_setAnotherName(){ \r\n"
				+ "  String expectedResult = \"andre\"; \r\n"
				+ "  testGenerate.setName(\"andre\"); \r\n"
				+ "  assertEquals(expectedResult, testGenerate.getName());      \r\n"
				+ " }\r\n"
				+"\r\n";
		assertEquals(expected, generator.getAllGetterSetterTest());
	}
}
