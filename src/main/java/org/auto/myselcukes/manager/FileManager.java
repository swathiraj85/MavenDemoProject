package org.auto.myselcukes.manager;

import org.auto.myselcukes.dataprovider.ConfigReader;

public class FileManager {
	private static FileManager filemanager_obj;
	private static ConfigReader configreader_obj;
private FileManager() 
{
}
public static FileManager getInstance() {
	if (filemanager_obj ==null)
	{
		// to make thread safe and synchronized only when the object is null
		synchronized(FileManager.class)
		{
			filemanager_obj = new FileManager();
		}
	}
	return filemanager_obj;
}
public ConfigReader getConfigReader()
{
	if (configreader_obj ==null)
	{
		// to make thread safe and synchronized only when the object is null
		synchronized(ConfigReader.class)
		{
			configreader_obj = new ConfigReader();
		}
	}
	return configreader_obj;
}
}
