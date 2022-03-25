package com.andre.generations;

import static com.andre.util.Util.util;

public class GenerateRepo {
	
	private String name;

	public String getRepo(String className) {
		String result = "@Repository\r\n"
				+ "public interface I"+className+" extends JpaRepository<"+className+", Integer>{\r\n"
				+"       public "+className+" findByUsername(String username);\r\n"
				+"       public "+className+" findByEmailIdAndPassword(String emailId, String password);\r\n"
				+ "\r\n"
				+ "}";
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = util.firstLetterToCapital(name);
	}


}
