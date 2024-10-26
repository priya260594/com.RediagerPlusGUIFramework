package com.hc.rediagerplus.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contain generic method to read the data from property file
 * 
 * @author Priyanka
 */
public class PropertyFileUtility {
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.filePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
