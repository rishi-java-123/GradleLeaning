package com.rishi.learning;

public class DeveloperEmployeeFactory implements IEmployeeFactory{

	@Override
	public IEmployee createEmployee() {
		return new DeveloperEmployee(); 
	}

}
