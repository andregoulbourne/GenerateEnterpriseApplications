package com.andre.generations;

import java.util.Arrays;
import java.util.List;

public class GenerateModels {
	
	private String name;
	
	private String nameOfEntity;
	
	private List<String> fields; 
	
	private List<String> types;
	
	private final String[] annotationList = {"@Entity", "@Table(name=\" \")","@NoArgsContructor","@AllArgsConstructor","@Getter","@Setter" , "@Id",
		    "@GeneratedValue(strategy = GenerationType.IDENTITY)" };  
	
	public GenerateModels(String name, List<String> types, List<String> fields) {
		super();
		this.name = name;
		this.fields = fields;
		this.types = types;
		this.nameOfEntity = name; 
	}
	
	public GenerateModels(String name, String entityName, List<String> types, List<String> fields) {
		super();
		this.name = name;
		this.fields = fields;
		this.types = types;
		this.nameOfEntity = entityName; 
	}
	
	public GenerateModels(String name) {
		this.name=name;
		this.nameOfEntity=name;
	}
	
	public GenerateModels(String name, String entityName) {
		this.name=name;
		this.nameOfEntity=entityName;
	}
	
	private String updateFirstCharacterToUpperCase(String name) {
		String result= "";
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		for(int i=0; i<name.length();i++) {
			if(i==0) {
				if(lower.contains(""+name.charAt(i))) result+= upper.charAt(lower.indexOf(name.charAt(i)));
				else result+=name.charAt(i);
			} else result+=name.charAt(i);
		}
		return result;
	}
	
	public String getModelStarted() {
		String result= "";
		result += "@Entity\r\n"
				+ "@Table(name = \""+nameOfEntity.toLowerCase()+"\")\r\n"
				+ "@NoArgsConstructor\r\n"
				+ "@AllArgsConstructor\r\n"
				+ "@Getter\r\n"
				+ "@Setter\r\n"
				+ "public class "+updateFirstCharacterToUpperCase(name)+" implements Serializable { ";
				
		return result;
	}
	
	public String getPrivateFields() {
		String result="";
		for(int i=0; i<fields.size(); i++) {
			if(fields.get(i).equals("id")) {
				result+="@Id\r\n"
						+ "@GeneratedValue(strategy = GenerationType.IDENTITY)\r\n"
						+ "private "+types.get(i)+" "+fields.get(i)+"; \r\n";
			} else result+="private "+types.get(i)+" "+fields.get(i)+"; \r\n";
		}
		return result;
	}

	@Override
	public String toString() {
		return "GenerateModels [name=" + name + ", nameOfEntity=" + nameOfEntity + ", fields=" + fields + ", types=" + types
				+ ", annotationList=" + Arrays.toString(annotationList) + "]";
	}
	
	public String getAnotations() {
		String result="";
		for(String  string: annotationList) {
			result+= string+", ";
		}
		return result;
	}

}
