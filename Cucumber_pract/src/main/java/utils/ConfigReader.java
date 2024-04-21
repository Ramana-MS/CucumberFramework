package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.nio.file.Paths;

public class ConfigReader {
	
	
	public static Properties intializeProperties() {
		
		Properties prop = new Properties();
		
		File proFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resource" + File.separator + "config" + File.separator + "Config.properties");
        
	try {
		FileInputStream fis = new FileInputStream(proFile);
		prop.load(fis);
	} catch (Throwable e) {
		e.printStackTrace();
	}
		   
		return prop;   
	}
	
}
