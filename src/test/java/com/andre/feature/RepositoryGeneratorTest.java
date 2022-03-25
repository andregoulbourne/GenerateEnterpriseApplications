package com.andre.feature;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.andre.generations.GenerateRepo;

public class RepositoryGeneratorTest {

	private GenerateRepo generateRepo;

	private String className;

	@Before
	public void setup() {
		this.generateRepo = new GenerateRepo();
		this.className = "User";
		generateRepo.setName("User");
	}

	@Test
	public void inClassName_OutFormatedRepositoryClass() {
		String expectedResult = "@Repository\r\n" + "public interface I" + className
				+ " extends JpaRepository<User, Integer>{\r\n"
				+"       public User findByUsername(String username);\r\n"
				+"       public User findByEmailIdAndPassword(String emailId, String password);\r\n"
				+ "\r\n" + "}";
		String result = generateRepo.getRepo(className);
		assertEquals(expectedResult, result);
	}

	@Test
	public void constructorAcually_PutInTheName() {
		String result = "User";
		assertEquals(generateRepo.getName(), result);
	}

	@Test
	public void testGetterAndSetters_setAnotherName() {
		String expectedResult = "andrea";
		generateRepo.setName("andrea");
		assertEquals(expectedResult, generateRepo.getName());
	}

}
