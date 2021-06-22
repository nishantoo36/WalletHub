package com.walletHub.driverFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    final private  String configRelative =  "Config/Common.properties";
    final private String commonConfigFilePath = System.getProperty("user.dir")+"/" + configRelative;


	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(configRelative));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + commonConfigFilePath);
		}
	}

	public String getBrowserName() {
		if (System.getProperty("browser") != null) {
			return (System.getProperty("browser"));
		}else if(properties.getProperty("browser")!=null) {
			return properties.getProperty("browser");
		}
		else {
			throw new RuntimeException("browser not specified.");
		}
	}


	public String getPlatform()  {
		if (System.getProperty("platform") != null) {
			return (System.getProperty("platform"));
		}else if(properties.getProperty("platform")!=null) {
			return properties.getProperty("platform");
		}
		else {
			throw new RuntimeException("platform not specified.");
		}
	}
}
