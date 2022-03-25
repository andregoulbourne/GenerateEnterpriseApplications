package com.andre;

import static com.andre.util.Util.util;
//Can package name be the same

import java.util.List;

import com.andre.generations.ApplicationProperitiesFileGeneration;
import com.andre.generations.GenerateController;
import com.andre.generations.GenerateDTO;
import com.andre.generations.GenerateModels;
import com.andre.generations.GenerateNotFoundException;
import com.andre.generations.GenerateRepo;
import com.andre.generations.POMDependencies;
import com.andre.testgeneration.GenerateTestModels;
import com.andre.testgeneration.TestGenerateController;
import com.andre.testgeneration.TestGenerateNotFoundException;
import com.andre.testgeneration.TestGenerateRepository;

//Just wanted to log package name cant be the same ever
public class Driver {
		
	public static void main(String[] args) {
		run();
	}
		
	public static void run() {
		System.out.println("Enter 1 for Test, Enter 2 for Features, Enter 3 to Exit");
		System.out.println(" ------------------------");
		System.out.println("|Main Menu               |");
		System.out.println(" ------------------------");
		int section = util.scanInt();
		if(section == 2) {
			runFeatures();
		} else if(section == 1) {
			runTest();
		} else if(section == 3){
			System.exit(0);
		} else {
			run();
		}
	}
	
	public static void runFeatures() {
		System.out.println("Enter 1 for a Model, Enter 2 for repository, Enter 3 for A controller, \r\nEnter 4 for POM, Enter 5 for propertiesfile, Enter 6 for DTO  \r\nEnter 7 to generate a NotFoundException ,Enter 8 for the main menu");
		System.out.println(" ------------------------");
		System.out.println("|Features               |");
		System.out.println(" ------------------------");
		int input = util.scanInt();
		switch(input) {
		case 1:
		generateModelFeatures(); 
		runFeatures();
		case 2:
		generateRepos();
		runFeatures();
		case 3:
		generateControllerFeature();
		runFeatures();
		case 4:
			generatePOM();
			runFeatures();
		case 5:
			generateApplicationProperty();
			runFeatures();	
		case 6:
			generateDTOFeatures();
			runFeatures();
		case 7:
			generateNotFoundException();
			runFeatures();
		case 8: run();
		default:
			System.out.println("Sorry that "+input+" is not a valid input");
			runFeatures();
		}
	}
	
	public static void runTest() {
		System.out.println("Enter 1 for a Model/DTO, Enter 2 for repository, Enter 3 for A controller, \r\nEnter 4 for NotFoundExceptionTest, Enter 5 for the main menu");
		System.out.println(" ------------------------");
		System.out.println("|Test                   |");
		System.out.println(" ------------------------");
		int input = util.scanInt();
		switch(input) {
		case 1:
		generateModelTest();
		runTest();
		case 2:
		generateRepoTest();
		runTest();
		case 3:
		generateControllerTest();
		System.out.println("This where the test for the controllers are going to go");
		runTest();	
		case 4: 
			generateNotFoundExceptionTest();
			runTest();
		case 5: run();
		default:
			System.out.println("Sorry that "+input+" is not a valid input");
			runTest();
		}
	}
	
	public static void generateModelFeatures() {
		System.out.println(" ------------------------");
		System.out.println("|Model generator         |");
		System.out.println(" ------------------------");
		System.out.println("Make a list of field types, separate them with commas no whitespace");	
//		List<String> field = Arrays.asList("int", "String", "String","String", "String", "String", "List<Appointment>" , "String");
		String fieldString = util.scanString();
		List<String> field = util.makeListFromString(fieldString);
		System.out.println("Make a list for field names");
//		List<String> names = Arrays.asList("id", "username", "pwd","firstName", "lastName", "middleName", "appointments", "phone");
		String nameString = util.scanString();
		List<String> names = util.makeListFromString(nameString);
		System.out.println("Enter a class name and restart to restart");
		String className = util.scanString();
		if(restart(className)) generateModelFeatures();
		System.out.println("Enter a table name and restart to restart");
		String tableName = util.scanString();
		if(restart(tableName)) generateModelFeatures();
		GenerateModels c = new GenerateModels(className, tableName, field, names );
		// System.out.println(c.getAnotations());
		System.out.println(c.getModelStarted());
		System.out.println(c.getPrivateFields());
	}
	
	public static void generateDTOFeatures() {
		System.out.println(" ------------------------");
		System.out.println("|DTO generator         |");
		System.out.println(" ------------------------");
		System.out.println("Make a list of field types, separate them with commas no whitespace");	
//		List<String> field = Arrays.asList("int", "String", "String","String", "String", "String", "List<Appointment>" , "String");
		String fieldString = util.scanString();
		List<String> field = util.makeListFromString(fieldString);
		System.out.println("Make a list for field names");
//		List<String> names = Arrays.asList("id", "username", "pwd","firstName", "lastName", "middleName", "appointments", "phone");
		String nameString = util.scanString();
		List<String> names = util.makeListFromString(nameString);
		System.out.println("Enter a class name and restart to restart");
		String className = util.scanString();
		if(restart(className)) generateModelFeatures();
		GenerateDTO c = new GenerateDTO(className, field, names );
		System.out.println(c.getDTO());
		
	}
	
	public static void generateModelTest() {
		System.out.println(" ------------------------");
		System.out.println("|Model/DTO Test Generator    |");
		System.out.println(" ------------------------");
		System.out.println("Make a list of field types, separate them with commas no whitespace");	
//		List<String> field = Arrays.asList("int", "String", "String","String", "String", "String", "List<Appointment>" , "String");
		String fieldString = util.scanString();
		List<String> field = util.makeListFromString(fieldString);
		System.out.println("Make a list for field names");
//		List<String> names = Arrays.asList("id", "username", "pwd","firstName", "lastName", "middleName", "appointments", "phone");
		String nameString = util.scanString();
		List<String> names = util.makeListFromString(nameString);
		System.out.println("Make a list for example values in the fields");
//		List<String> names = Arrays.asList("id", "username", "pwd","firstName", "lastName", "middleName", "appointments", "phone");
		String valuesString = util.scanString();
		List<String> values = util.makeListFromString(valuesString);
		System.out.println("values ==>"+values);
		System.out.println("Enter any number for Model , 2 for DTO");
		int input = util.scanInt();
		System.out.println("Enter a class name and restart to restart");
		String className = util.scanString();
		if(restart(className)) generateModelTest();
		if(input == 2) className += "DTO"; 
		GenerateTestModels c = new GenerateTestModels(className, field, names, values );
		System.out.println("values array ==> "+ values);
		System.out.println(c.getTestSetUp());
		System.out.println(c.getAllGetterSetterTest());
		generateSetterGetterTestInModelTest(c);
	}
	
	public static void generateSetterGetterTestInModelTest(GenerateTestModels c) {
		System.out.println(" ------------------------");
		System.out.println("|Model Test Generator : SettersAndGetter Test   |");
		System.out.println(" ------------------------");
		System.out.println("Enter 1 generate getter and setter test and enter 2 to go back to the sub menu");
		int input = util.scanInt();
		if(input == 1) {
		System.out.println("Enter a data type and restart to restart");
		String typeName = util.scanString();
		if(restart(typeName)) generateSetterGetterTestInModelTest(c);
		System.out.println("Enter a field name and restart to restart");
		String fieldName = util.scanString();
		if(restart(fieldName)) generateSetterGetterTestInModelTest(c);
		System.out.println("Enter a value for the field and restart to restart");
		String fieldValue = util.scanString();
		if(restart(fieldValue)) generateSetterGetterTestInModelTest(c);
		System.out.println(c.getGetterSetterTest(typeName, fieldName, fieldValue));
		generateSetterGetterTestInModelTest(c);
		} else if (input == 2) {
			return;
		} else {
			System.out.println("Sorry, Invalid input");
			generateSetterGetterTestInModelTest(c);
		}
	}
	
	public static void generateRepos() {
		System.out.println(" ------------------------");
		System.out.println("|Repository Generator    |");
		System.out.println(" ------------------------");
		GenerateRepo generator = new GenerateRepo();
		String cName = util.scanString();
		if(restart(cName)) generateRepos();
		System.out.println(generator.getRepo(cName));
	}
	
	public static void generateRepoTest() {
		System.out.println(" ------------------------");
		System.out.println("|Repository Test Generator|");
		System.out.println(" ------------------------");
		System.out.println("Enter the name of the class the repo operates on");
		String cName = util.scanString();	
		if(restart(cName)) generateRepoTest();
		TestGenerateRepository repoTestGenerator = new TestGenerateRepository(cName); 
		System.out.println(repoTestGenerator.getRepositoryTest());
	}
	
	public static void generateControllerFeature() {
		System.out.println(" ------------------------");
		System.out.println("|Controller Generator    |");
		System.out.println(" ------------------------");
		System.out.println("Enter a cross orign enabled url and restart to restart");
		String crossPoint = util.scanString();
		if(restart(crossPoint)) generateControllerFeature();
		System.out.println("Enter a name for the class your making the controller for and restart to restart");
		String className2 = util.scanString();
		if(restart(className2)) generateControllerFeature();
		GenerateController controller = new GenerateController(crossPoint, className2);
		System.out.println(controller.getController());
	}
	
	public static void generateControllerTest() {
		System.out.println(" ------------------------");
		System.out.println("|Controller Test Generator|");
		System.out.println(" ------------------------");
		System.out.println("The model that it working on");
		String className = util.scanString();
		TestGenerateController generator = new TestGenerateController(className);
		System.out.println(generator.generateControllerTest());
		
	}
	
	public static void generatePOM() {
		System.out.println(" ------------------------");
		System.out.println("|Generate POM             |");
		System.out.println(" ------------------------");
		System.out.println("Enter 1 for just JUnit Dependencies, Enter 2 for spring dependencies and enter 3 to leave this menu");
		int input = util.scanInt();
		POMDependencies pom = new POMDependencies();
		if(input == 1) {
			System.out.println(pom.getJunitDependency());
			generatePOM();
		} else if(input == 2) {
			System.out.println(pom.getAllDependenciesSpring());
			generatePOM();
		} else if(input == 3){
			
		}else {
			generatePOM();
		}
	}
	
	public static void generateApplicationProperty() {
		System.out.println(" ------------------------");
		System.out.println("|Generate application.properties|");
		System.out.println(" ------------------------");
		System.out.println("Enter 1 for just H2, Enter 2 for Postgres and enter 3 to leave this menu");
		int input = util.scanInt();
		ApplicationProperitiesFileGeneration b = new ApplicationProperitiesFileGeneration();
		if(input == 1) {
			System.out.println("Enter a name for the db");
			String dbName = util.scanString();
			System.out.println("Enter a username for the db");
			String username = util.scanString();
			System.out.println("Enter a password for the db");
			String password = util.scanString();
			ApplicationProperitiesFileGeneration a = new ApplicationProperitiesFileGeneration(dbName, username, password);
			System.out.println(a.getH2PropertyFile());
			generateApplicationProperty();
		} else if(input == 2) {
			System.out.println(b.getPostgresPropertyFile());
			generateApplicationProperty();
		} else if(input == 3){
			
		}else {
			generateApplicationProperty();
		}
	}
	
	public static void generateNotFoundException() {
		System.out.println(" ------------------------");
		System.out.println("|Generated NotFoundException|");
		System.out.println(" ------------------------");
	
		GenerateNotFoundException generator = new GenerateNotFoundException();
		
		System.out.println(generator.getNotFoundException());
	}
	
	public static void generateNotFoundExceptionTest() {
		System.out.println(" ------------------------");
		System.out.println("|Generated NotFoundExceptionTest|");
		System.out.println(" ------------------------");
	
		TestGenerateNotFoundException generator = new TestGenerateNotFoundException();
		
		System.out.println(generator.getNotFoundExceptionTest());
	}
	
	public static boolean restart(String restart) {
		if(restart.equals("restart")) {
			return true;
		}
		return false;
	}
}
