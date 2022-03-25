package com.andre.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.andre.testgeneration.TestGenerateRepository;

public class TestGenerateRepoTest {
	
	TestGenerateRepository generate;
	
	@Before
	public void setup() {
		this.generate = new TestGenerateRepository("user");
	}
	
	@Test
	public void testGeneratorGeneratesRepository() {
		String expected = "@ExtendWith(SpringExtension.class)\r\n"
				+ "@DataJpaTest\r\n"
				+ "public class IUserTest {\r\n"
				+ "	     \r\n"
				+ "    @Autowired\r\n"
				+ "    private IUser repo;\r\n"
				+ "    \r\n"
				+ "    private User user;\r\n"
				+ "    \r\n"
				+ "    private User user2;\r\n"
				+ "    \r\n"
				+ "    @BeforeEach\r\n"
				+ "    public void setup() {\r\n"
				+ "    	this.user = new User(\"patient\", \"password\", \"firstName\", \"lastName\", \"middleName\", new ArrayList<>(),\r\n"
				+ "				\"19735678888\");\r\n"
				+ "    	this.user2 = new User(\"patient2\", \"password2\", \"firstName2\", \"lastName2\", \"middleName2\", new ArrayList<>(),\r\n"
				+ "				\"19735678882\");\r\n"
				+ "    	repo.save(user2);\r\n"
				+ "    	repo.save(new User(\"patient3\", \"password3\", \"firstName3\", \"lastName3\", \"middleName3\", new ArrayList<>(),\r\n"
				+ "				\"19735678885\"));\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    @Test\r\n"
				+ "    void injectedComponentsAreNotNull(){\r\n"
				+ "      assertThat(repo).isNotNull();\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    @Test\r\n"
				+ "    public void testSaveNewUser() {\r\n"
				+ "    	User savedUser = repo.save(user);\r\n"
				+ "    	\r\n"
				+ "    	assertThat(savedUser.getId()).isGreaterThan(0);\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    @Test  \r\n"
				+ "    public void testReadAllUser() {\r\n"
				+ "    	repo.save(user);\r\n"
				+ "    	List<User> users = repo.findAll();\r\n"
				+ "    	assertNotNull(users);\r\n"
				+ "    	assertEquals(users.size(), 3);\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    @Test\r\n"
				+ "    public void testFindAUser() {\r\n"
				+ "    	User foundUser = repo.findByUsername(\"patient3\");\r\n"
				+ "    	assertEquals(\"patient3\", foundUser.getUsername());\r\n"
				+ "    	assertEquals(2, foundUser.getId()); //This id is generated by the spring //This entity counts as the second entity inserted\r\n"
				+ "    }\r\n"
				+" \r\n"
					+ "    @Test\r\n"
					+ "    public void testFindAUserByEmailIdAndPassword() {\r\n"
					+ "    	User foundUser = repo.findByEmailIdAndPassword(\"patient3\", \"password3\");\r\n"
					+ "    	assertEquals(\"patient3\", foundUser.getUsername());\r\n"
					+ "    	assertEquals(2, foundUser.getId()); //This id is generated by the spring //This entity counts as the second entity inserted\r\n"
					+ "    }\r\n"
				+ "     \r\n"
				+ "    @Test  \r\n"
				+ "    public void testfindUserAndUpdateUser() {\r\n"
				+ "    	User user = repo.findByUsername(\"patient3\");\r\n"
				+ "    	user.setUsername(\"Hello\");\r\n"
				+ "    	repo.save(user);\r\n"
				+ "    	User updatedUser = repo.findByUsername(\"Hello\");\r\n"
				+ "    	assertNotNull(updatedUser);\r\n"
				+ "    	assertEquals(user.getId(), updatedUser.getId());//Making sure it has the same id as the previous one\r\n"
				+ "    }\r\n"
				+ "     \r\n"
				+ "    @Test  \r\n"
				+ "    public void testDeleteUser() {\r\n"
				+ "    	repo.delete(user2);\r\n"
				+ "    	User user2 = repo.findByUsername(\"patient2\");\r\n"
				+ "    	assertNull(user2);\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "}\r\n"
				+ "";
		assertEquals(expected, generate.getRepositoryTest());
	}

}
