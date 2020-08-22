package com.rishi.learning;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;


public class ConfigurationMain {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<Configuration> loadConfiguration = Configuration.loadConfiguration(args[0]);
		for (Configuration configuration : loadConfiguration) {
			String location = configuration.getLocation();
			 URL url = new URL(location);
			 URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
			 Class<IEmployeeFactory> forName = (Class<IEmployeeFactory>)Class.forName(configuration.getFactoryType(), true, urlClassLoader);
			 IEmployeeFactory newInstance = forName.getDeclaredConstructor().newInstance();
				IEmployee createEmployee = newInstance.createEmployee();
				createEmployee.takeJob();
		}
		
	/*	String location = loadConfiguration.getLocation();
		  URL url = new URL(location);
		  URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
		  Class<IEmployeeFactory> forName = (Class<IEmployeeFactory>)Class.forName(loadConfiguration.getFactoryType(), true, urlClassLoader);
		  IEmployeeFactory newInstance = forName.getDeclaredConstructor().newInstance();
		IEmployee createEmployee = newInstance.createEmployee();
		createEmployee.takeJob();*/
	}

}
