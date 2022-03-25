package com.andre.feature;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.andre.generations.GenerateDTO;

public class GenerateDTOTest {
	
	GenerateDTO generator;
	
	@Before
	public void setup() {
		this.generator = new GenerateDTO("Matrix", Arrays.asList("int", "String", "List<Skill>", "Portfolio"), Arrays.asList("id", "header", "skills", "portfolio"));
	}
	
	@Test
	public void testGetPrivateFields_returnCorrectPrivateFields() {
		assertEquals( "\r\n"
				+ "private int id;\r\n"
				+ "\r\n"
				+ "private String header;\r\n"
				+ "\r\n"
				+ "private Portfolio portfolio;\r\n"
				+ "\r\n"
				+ "private List<Skill> skills;\r\n"
				+ "\r\n", generator.getPrivateFields());
	}
	
	@Test
	public void testGenerateListDeclarations() {
		assertEquals("public MatrixDTO(String header, List<Skill> skills, Portfolio portfolio) {\r\n", 
				generator.getDeclarationContructor());
	}
	
	@Test
	public void testGenerateListFieldInContructor() {
		assertEquals( "		this.header = header;\r\n"
				+ "		this.skills = skills;\r\n"
				+ "		this.portfolio = portfolio;\r\n",generator.setInTheContructor());
	}
	
	@Test
	public void testGetAValidDTO() {
		assertEquals("package com.forge.revature.models;\r\n"
				+ "\r\n"
				+ "import java.util.List;\r\n"
				+ "\r\n"
				+ "import lombok.AllArgsConstructor;\r\n"
				+ "import lombok.Getter;\r\n"
				+ "import lombok.NoArgsConstructor;\r\n"
				+ "import lombok.Setter;\r\n"
				+ "\r\n"
				+ "@Getter\r\n"
				+ "@Setter\r\n"
				+ "@AllArgsConstructor\r\n"
				+ "@NoArgsConstructor\r\n"
				+ "public class MatrixDTO {\r\n"
				+ "\r\n"
				+ "private int id;\r\n"
				+ "\r\n"
				+ "private String header;\r\n"
				+ "\r\n"
				+"private List<Skill> skills;\r\n"
				+ "\r\n"
				+ "private Portfolio portfolio;\r\n"
				+ "\r\n"
				+ "public MatrixDTO(String header, List<Skill> skills, Portfolio portfolio) {\r\n"
				+ "		this.header = header;\r\n"
				+ "		this.skills = skills;\r\n"
				+ "		this.portfolio = portfolio;\r\n"
				+ "	}\r\n"
				+ "\r\n"
				+ "}", generator.getDTO());
	}

}
