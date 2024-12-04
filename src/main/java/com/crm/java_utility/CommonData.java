package com.crm.java_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonData {

	
	Properties  properties=new Properties();
	FileInputStream inputStream;
	
	public String data(String key) throws IOException {
		
		inputStream=new FileInputStream("./src/main/java/com/crm/File_utility/prop.properties");
		properties.load(inputStream);
		String data=properties.getProperty(key);
		
		return data;
		
	}
}
