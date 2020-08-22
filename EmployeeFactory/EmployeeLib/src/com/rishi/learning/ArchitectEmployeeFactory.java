package com.rishi.learning;

public class ArchitectEmployeeFactory implements IEmployeeFactory {

	@Override
	public IEmployee createEmployee() {
		// TODO Auto-generated method stub
		return new ArchietectEmployee();
	}

}
