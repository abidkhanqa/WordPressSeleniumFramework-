package com.wordpress.constants;

public final class FilePathConstants {


	private FilePathConstants() {
		
	}
	
	private static final String SYSTEM_GETPROPERTY = System.getProperty("user.dir");
	private static final String CONFIG_FILEPATH = SYSTEM_GETPROPERTY+"/src/test/resources/config/config.properties";
	private static final String EXTENTREPORT_FILEPATH = SYSTEM_GETPROPERTY+"/Reports";
	
	
	public static String getConfigFilepath() {
		return CONFIG_FILEPATH;
	}


	public static String getExtentreportFilepath() {
		return EXTENTREPORT_FILEPATH;
	}
}
