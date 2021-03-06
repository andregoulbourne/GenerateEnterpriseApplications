package com.andre.feature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.andre.generations.POMDependencies;

public class POMDependenciesTest {
	
	POMDependencies generator = new POMDependencies();
	
	@Test
	public void testTheJUnitDependency_isCorrect() {
		assertEquals("<dependencies>\r\n"
				+ "		<!-- https://mvnrepository.com/artifact/junit/junit -->\r\n"
				+ "		<dependency>\r\n"
				+ "			<groupId>junit</groupId>\r\n"
				+ "			<artifactId>junit</artifactId>\r\n"
				+ "			<version>4.13.2</version>\r\n"
				+ "			<scope>test</scope>\r\n"
				+ "		</dependency>\r\n"
				+ "	</dependencies>", generator.getJunitDependency());
	}
	
	@Test
	public void generateDependenciesForSpringBoot() {
		assertEquals("<dependencies>\r\n"
				+ "		<dependency>\r\n"
				+ "			<groupId>org.springframework.boot</groupId>\r\n"
				+ "			<artifactId>spring-boot-starter-validation</artifactId>\r\n"
				+ "		</dependency>\r\n"
				+ "		<dependency>\r\n"
				+ "			<groupId>org.springframework.boot</groupId>\r\n"
				+ "			<artifactId>spring-boot-starter-data-jpa</artifactId>\r\n"
				+ "		</dependency>\r\n"
				+ "		<dependency>\r\n"
				+ "			<groupId>org.springframework.boot</groupId>\r\n"
				+ "			<artifactId>spring-boot-starter-web</artifactId>\r\n"
				+ "		</dependency>\r\n"
				+ "\r\n"
				+ "		<dependency>\r\n"
				+ "			<groupId>com.h2database</groupId>\r\n"
				+ "			<artifactId>h2</artifactId>\r\n"
				+ "			<scope>runtime</scope>\r\n"
				+ "		</dependency>\r\n"
				+ "		<dependency>\r\n"
				+ "			<groupId>org.postgresql</groupId>\r\n"
				+ "			<artifactId>postgresql</artifactId>\r\n"
				+ "			<scope>runtime</scope>\r\n"
				+ "		</dependency>\r\n"
				+ "		<dependency>\r\n"
				+ "			<groupId>org.projectlombok</groupId>\r\n"
				+ "			<artifactId>lombok</artifactId>\r\n"
				+ "			<optional>true</optional>\r\n"
				+ "		</dependency>\r\n"
				+ "		<dependency>\r\n"
				+ "			<groupId>org.springframework.boot</groupId>\r\n"
				+ "			<artifactId>spring-boot-starter-test</artifactId>\r\n"
				+ "			<scope>test</scope>\r\n"
				+ "		</dependency>\r\n"
				+ "		<dependency>\r\n"
				+ "			<groupId>org.springframework.boot</groupId>\r\n"
				+ "			<artifactId>spring-boot-starter-test</artifactId>\r\n"
				+ "			<scope>test</scope>\r\n"
				+ "			<exclusions>\r\n"
				+ "				<exclusion>\r\n"
				+ "					<groupId>org.junit.vintage</groupId>\r\n"
				+ "					<artifactId>junit-vintage-engine</artifactId>\r\n"
				+ "				</exclusion>\r\n"
				+ "			</exclusions>\r\n"
				+ "		</dependency>\r\n"
				+ "	</dependencies>\r\n"
				+ "\r\n"
				+ "	<build>\r\n"
				+ "		<plugins>\r\n"
				+ "			<plugin>\r\n"
				+ "				<groupId>org.springframework.boot</groupId>\r\n"
				+ "				<artifactId>spring-boot-maven-plugin</artifactId>\r\n"
				+ "				<configuration>\r\n"
				+ "					<excludes>\r\n"
				+ "						<exclude>\r\n"
				+ "							<groupId>org.projectlombok</groupId>\r\n"
				+ "							<artifactId>lombok</artifactId>\r\n"
				+ "						</exclude>\r\n"
				+ "					</excludes>\r\n"
				+ "				</configuration>\r\n"
				+ "			</plugin>\r\n"
				+ "		</plugins>\r\n"
				+ "	</build>", generator.getAllDependenciesSpring());
	}

}
