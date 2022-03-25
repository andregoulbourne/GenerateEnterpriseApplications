package com.andre.generations;

import java.util.List;
import static com.andre.util.Util.util;


public class GenerateDTO {
	
	private String name;
	
	private List<String> types;
	
	private List<String> fields;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = util.firstLetterToCapital(name);
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	
	

	public GenerateDTO(String name, List<String> types, List<String> fields) {
		super();
		this.name = util.firstLetterToCapital(name);
		this.types = types;
		this.fields = fields;
	}

	public String getPrivateFields() {
		String result="\r\n";
		for(int i=0; i<fields.size(); i++) {
			result+="private "+types.get(i)+" "+fields.get(i)+";\r\n\r\n";
		}
		return result;
	}
	
	public String getDeclarationContructor() {
		String result = "public "+name+"DTO(";
		for(int i=0; i<types.size(); i++) {
			if(!fields.get(i).equals("id"))
			result += types.get(i)+" "+util.firstLetterToLower(fields.get(i))+", ";
		}
		result = util.cutLastCharacter(result);
		result = util.cutLastCharacter(result);
		result += ") {\r\n";
		return result;
	}
	
	public String setInTheContructor() {
		String result = "";
		for(int i=0; i<fields.size(); i++) {
			if(!fields.get(i).equals("id"))
			result+="		this."+util.firstLetterToLower(fields.get(i))+" = "+util.firstLetterToLower(fields.get(i))+";\r\n";
		}
		return result;
	}

	public String getDTO() {
		return "package com.forge.revature.models;\r\n"
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
				+ "public class "+name+"DTO {\r\n"
				+ getPrivateFields()
				+ getDeclarationContructor()
				+ setInTheContructor()
				+ "	}\r\n"
				+ "\r\n"
				+ "}";
	}

}
