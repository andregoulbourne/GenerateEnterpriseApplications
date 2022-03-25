package com.andre.testgeneration;

import static com.andre.util.Util.util;

import java.util.List;

public class GenerateTestModels {
	
	private String name;

	private List<String> types;
	
	private List<String> fields;
	
	private List<String> values;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public GenerateTestModels(String name, List<String> types, List<String> fields, List<String> values) {
		super();
		this.name = util.firstLetterToCapital(name);
		this.types = types;
		this.fields = fields;
		this.values = values;
	}
	
	
	public String getTestSetUp() {
		String result= "";
		result+="public class "+name+"Test {\r\n"
				+ "	"+name+" "+util.firstLetterToLower(name)+";\r\n"
				+ "	\r\n"
				+ "	@Before\r\n"
				+ "	public void setup() {\r\n"
				+ "		this."+util.firstLetterToLower(name)+" = new "+name+"("+arrayToStringListFields(values)+");\r\n"
				+ "	}\r\n";
		return result;
	}
	
	public String getGetterSetterTest(String type, String name, String value) {
		String result = "";
		if(!type.equals("String")) {
		 result += "@Test\r\n"
				+ "public void  testGetterAndSetters_setAnother"+util.firstLetterToCapital(name)+"(){ \r\n"
				+ "  "+type+" expectedResult = "+value+"; \r\n"
				+ "  "+util.firstLetterToLower(this.name)+".set"+util.firstLetterToCapital(name)+"("+value+"); \r\n"
				+ "  assertEquals(expectedResult, "+util.firstLetterToLower(this.name)+".get"+util.firstLetterToCapital(name)+"());      \r\n"
				+ " }\r\n"
				+"\r\n";
		} else {
			result += "@Test\r\n"
					+ "public void  testGetterAndSetters_setAnother"+util.firstLetterToCapital(name)+"(){ \r\n"
					+ "  "+type+" expectedResult = \""+value+"\"; \r\n"
					+ "  "+util.firstLetterToLower(this.name)+".set"+util.firstLetterToCapital(name)+"(\""+value+"\"); \r\n"
					+ "  assertEquals(expectedResult, "+util.firstLetterToLower(this.name)+".get"+util.firstLetterToCapital(name)+"());      \r\n"
					+ " }\r\n"
					+"\r\n";
		}
		return result;
	}
	
	public String arrayToStringListFields(List<String> list) {
		String intermediateResult = "";
		for (int i = 0; i<list.size(); i++) {
			if(types.get(i).equals("String"))
			intermediateResult += "\"" + list.get(i) + "\",";
			else
				intermediateResult += list.get(i) + ",";	
		}
		String result = "";
		for (int i = 0; i < intermediateResult.length() - 1; i++) {
			result += intermediateResult.charAt(i);
		}
		return result;
	}
	
	public String getAllGetterSetterTest() throws IndexOutOfBoundsException{
		String result="";
		for(int i=0; i<types.size();i++) {
			result+=getGetterSetterTest(types.get(i), fields.get(i), values.get(i));
		}
		return result;
	}

}
