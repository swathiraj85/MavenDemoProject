package org.auto.myselcukes.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.auto.myselcukes.enums.DriverType;
import org.auto.myselcukes.enums.EnvironmentType;

public class ConfigReader
{
	private Properties properties;
	private String prop_path = "config//config.properties";
	public ConfigReader()
	{
		try
		{
		
		BufferedReader reader = new BufferedReader(new FileReader(prop_path));
		try
		{
			properties =  new Properties();
			properties.load(reader);
		}
		catch(IOException ie)
		{
			System.out.println(ie.toString());
		}
		}
		catch(FileNotFoundException fe) {
			System.out.println(fe.toString());
			
		}
	}
  public String getDriverPath()
		{
			String driverPath = properties.getProperty("driverPath");
			if(driverPath!= null) return driverPath;
			else throw new RuntimeException("driverPath not specified in the config.properties file");
			
		}
 public String getappURL()
		{
			String appURL = properties.getProperty("url");
			if(appURL!= null) return appURL;
			else throw new RuntimeException("application URL not specified in the config.properties file");
			
		}
 public long getTimeOut()
	{
		String timeout = properties.getProperty("timeout");
		long def_timeout = 30;
		if(timeout!= null) 
		{
			try
			{
				return Long.parseLong(timeout);
			}
			catch (NumberFormatException e)
			{
				throw new RuntimeException("unable to parse the value : " + timeout);
			}
		}
		return def_timeout;
		
	}
public EnvironmentType getEnvType() {	
	String env = properties.getProperty("environment");
	if(env == null  || env.equalsIgnoreCase("local"))return EnvironmentType.LOCAL;
	else if (env.equalsIgnoreCase("remote")) return EnvironmentType.REMOTE;
	else throw new RuntimeException("The env value is in-valid");
}
public DriverType getDriverType() {	
	String driver_type = properties.getProperty("browser");
	if(driver_type == null  || driver_type.equalsIgnoreCase("chrome"))return DriverType.CHROME;
	else if (driver_type.equalsIgnoreCase("ie")) return DriverType.IE;
	else if (driver_type.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
	else throw new RuntimeException("The driver type is in-valid");
}
} 