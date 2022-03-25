package com.andre.generations;

import com.andre.util.Util;


public class GenerateController {
	
	private Util util = new Util();
	
	private String crossOriginEndPoint;
	
	private String entity;

	public GenerateController(String crossOriginEndPoint, String entity) {
		super();
		this.crossOriginEndPoint = crossOriginEndPoint;
		this.entity = entity;
	}

	public GenerateController() {
		super();
	}
	
	public String getController() {
		return "package com.registerandlogin.controller;\r\n"
				+ "\r\n"
				+ "import java.util.List;\r\n"
				+ "import java.util.Optional;\r\n"
				+ "\r\n"
				+ "import org.springframework.beans.factory.annotation.Autowired;\r\n"
				+ "import org.springframework.web.bind.annotation.CrossOrigin;\r\n"
				+ "import org.springframework.web.bind.annotation.DeleteMapping;\r\n"
				+ "import org.springframework.web.bind.annotation.GetMapping;\r\n"
				+ "import org.springframework.web.bind.annotation.PathVariable;\r\n"
				+ "import org.springframework.web.bind.annotation.PostMapping;\r\n"
				+ "import org.springframework.web.bind.annotation.PutMapping;\r\n"
				+ "import org.springframework.web.bind.annotation.RequestBody;\r\n"
				+ "import org.springframework.web.bind.annotation.RequestMapping;\r\n"
				+ "import org.springframework.web.bind.annotation.RestController;\r\n"
				+ "\r\n"
				+ "import com.registerandlogin.dto."+entity+"DTO;\r\n"
				+ "import com.registerandlogin.models."+entity+";\r\n"
				+ "import com.registerandlogin.repo.I"+entity+";\r\n"
				+ "\r\n"
				+ "@RestController\r\n"
				+ "@CrossOrigin(origins = \""+crossOriginEndPoint+"\")\r\n"
				+ "@RequestMapping(\""+util.firstLetterToLower(entity)+"s\")\r\n"
				+ "public class "+entity+"Controller {\r\n"
				+ "	\r\n"
				+ "    @Autowired\r\n"
				+ "    I"+entity+" repo;\r\n"
				+ "    \r\n"
				+ "    /**\r\n"
				+ "     * Creates a new "+entity+" in the database\r\n"
				+ "     * @param "+entity+" new "+entity+" being created\r\n"
				+ "     * @return the representation of the "+entity+" with its newly generated primary key.\r\n"
				+ "     * @throws Exception \r\n"
				+ "     */\r\n"
				+ "    @PostMapping\r\n"
				+ "    public "+entity+" register"+entity+"(@RequestBody "+entity+" "+util.firstLetterToLower(entity)+") throws Exception {\r\n"
				+ "        if("+util.firstLetterToLower(entity)+".getEmailId() != null && !\"\".equals("+util.firstLetterToLower(entity)+".getEmailId())){\r\n"
				+ "              "+entity+" "+util.firstLetterToLower(entity)+"Obj = repo.findByEmailId("+util.firstLetterToLower(entity)+".getEmailId());\r\n"
				+ "               if("+util.firstLetterToLower(entity)+"Obj != null){\r\n"
				+ "                   throw new Exception(\""+entity+" with \"+"+util.firstLetterToLower(entity)+".getEmailId()+\" already exist\");\r\n"
				+ "               }\r\n"
				+ "         }\r\n"
				+ "        return repo.save("+util.firstLetterToLower(entity)+");\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    /**\r\n"
				+ "     * Retrieves all "+entity+" stored in the database\r\n"
				+ "     * @return List of all "+entity+" in the database in JSON format\r\n"
				+ "     */\r\n"
				+ "    @GetMapping\r\n"
				+ "    public List<"+entity+"> getAll() {\r\n"
				+ "        List<"+entity+"> "+util.firstLetterToLower(entity)+"s = repo.findAll();\r\n"
				+ "        return "+util.firstLetterToLower(entity)+"s;\r\n"
				+ "    }\r\n"
				+ "   \r\n"
				+ "    /**\r\n"
				+ "     * Retrieves an "+entity+" based on the given ID\r\n"
				+ "     * @param id id of the "+entity+"\r\n"
				+ "     * @return Single "+entity+" found\r\n"
				+ "     */\r\n"
				+ "    @GetMapping(\"/{id}\")\r\n"
				+ "    public "+entity+" get"+entity+"(@PathVariable(name = \"id\") int id) {\r\n"
				+ "        return repo.findById(id).get();\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ " /**\r\n"
				+ "     * Retrieves an "+entity+" based on the given "+util.firstLetterToLower(entity)+"name\r\n"
				+ "     * @param "+util.firstLetterToLower(entity)+"name "+util.firstLetterToLower(entity)+"name of the "+entity+"\r\n"
				+ "     * @return Single "+entity+" found\r\n"
				+ "     */\r\n"
				+ "    @GetMapping(\"/"+util.firstLetterToLower(entity)+"/{"+util.firstLetterToLower(entity)+"name}\")\r\n"
				+ "    public "+entity+" get"+entity+"(@PathVariable(name = \""+util.firstLetterToLower(entity)+"name\") String "+util.firstLetterToLower(entity)+"name) {\r\n"
				+ "        return repo.findBy"+entity+"name("+util.firstLetterToLower(entity)+"name);\r\n"
				+ "    } /**\r\n"
				+ "     * Retrieves an "+entity+" based on the given emailId and password\r\n"
				+ "     * @param "+entity+" "+util.firstLetterToLower(entity)+" with given emailId and password for query\r\n"
				+ "     * @return Single "+entity+" found\r\n"
				+ "     */\r\n"
				+ "    @PostMapping(\"/login\")\r\n"
				+ "    public "+entity+" get"+entity+"(@RequestBody "+entity+" "+util.firstLetterToLower(entity)+") {\r\n"
				+ "        String tempEmailId = "+util.firstLetterToLower(entity)+".getEmailId();\r\n"
				+ "        String tempPass = "+util.firstLetterToLower(entity)+".getPassword();\r\n"
				+ "        "+entity+" "+util.firstLetterToLower(entity)+"Obj = null;\r\n"
				+ "        if(tempEmailId != null && tempPass != null){\r\n"
				+ "	          "+util.firstLetterToLower(entity)+"Obj = repo.findByEmailIdAndPassword(tempEmailId, tempPass);\r\n"
				+ "         }\r\n"
				+ "         return "+util.firstLetterToLower(entity)+"Obj;\r\n"
				+ "    }\r\n"
				+ " /**\r\n"
				+ "	 * \r\n"
				+ "	 * @param id     of already existing "+util.firstLetterToLower(entity)+"\r\n"
				+ "	 * @param "+util.firstLetterToLower(entity)+" with changes to update\r\n"
				+ "	 * @return the newly changed "+util.firstLetterToLower(entity)+"\r\n"
				+ "	 */\r\n"
				+ "	@PutMapping\r\n"
				+ "	public User putUser(@RequestBody UserDTO "+util.firstLetterToLower(entity)+"DTO) {\r\n"
				+ "		User "+util.firstLetterToLower(entity)+";\r\n"
				+ "		try {\r\n"
				+ "			"+util.firstLetterToLower(entity)+" = repo.findById("+util.firstLetterToLower(entity)+"DTO.getId()).get();\r\n"
				+ "		} catch (Exception e) {\r\n"
				+ "			"+util.firstLetterToLower(entity)+" = new User("+util.firstLetterToLower(entity)+"DTO.getId(), "+util.firstLetterToLower(entity)+"DTO.getEmailId(), "+util.firstLetterToLower(entity)+"DTO.getUsername(), "+util.firstLetterToLower(entity)+"DTO.getPassword());\r\n"
				+ "			return repo.save("+util.firstLetterToLower(entity)+");\r\n"
				+ "		}\r\n"
				+ "		\r\n"
				+ "		    "+util.firstLetterToLower(entity)+".setEmailId("+util.firstLetterToLower(entity)+"DTO.getEmailId());\r\n"
				+ "			"+util.firstLetterToLower(entity)+".setUsername("+util.firstLetterToLower(entity)+"DTO.getUsername());\r\n"
				+ "			"+util.firstLetterToLower(entity)+".setPassword("+util.firstLetterToLower(entity)+"DTO.getPassword());\r\n"
				+ "			return repo.saveAndFlush("+util.firstLetterToLower(entity)+");\r\n"
				+ "			\r\n"
				+ "	}\r\n"
				+ "    /**\r\n"
				+ "     * Deletes the associated "+util.firstLetterToLower(entity)+"\r\n"
				+ "     * @param "+entity+"Id ID of the about me being deleted\r\n"
				+ "     */\r\n"
				+ "    @DeleteMapping(\"/{id}\")\r\n"
				+ "    public void delete"+entity+"(@PathVariable(name = \"id\") int "+util.firstLetterToLower(entity)+"Id) {\r\n"
				+ "        repo.deleteById("+util.firstLetterToLower(entity)+"Id);\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "";
	}
	

}
