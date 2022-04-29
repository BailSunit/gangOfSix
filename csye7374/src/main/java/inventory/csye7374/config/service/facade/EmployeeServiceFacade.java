package inventory.csye7374.config.service.facade;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import inventory.csye7374.config.service.adapter.EmployeeServiceAdapter;
import inventory.csye7374.model.Employee;

@Component
public class EmployeeServiceFacade {

	@Autowired
	private EmployeeServiceAdapter employeeServiceAdapter;

	public List<Employee> returnEmployeeList() {
		try {
			employeeServiceAdapter.checkFileExists(employeeServiceAdapter.getFile());
			return employeeServiceAdapter.getEmployeeList();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateEmployeeRegistry(List<Employee> employeeList) {
		try {
			employeeServiceAdapter.checkFileExists(employeeServiceAdapter.getFile());
			employeeServiceAdapter.updateEmployeeDirectory(employeeList);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
