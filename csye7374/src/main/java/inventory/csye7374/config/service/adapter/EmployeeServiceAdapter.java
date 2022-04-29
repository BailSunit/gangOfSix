package inventory.csye7374.config.service.adapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import inventory.csye7374.config.legacy.EmployeeService;
import inventory.csye7374.model.Employee;
import inventory.csye7374.model.PendingReview;
import inventory.csye7374.model.RecentlyHired;
import inventory.csye7374.model.ReviewComplete;

@Component
public class EmployeeServiceAdapter {

	@Autowired
	private EmployeeService employeeService;

	public File getFile() {
		return new File(employeeService.getFileName());
	}

	public void checkFileExists(File file) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	public List<Employee> getEmployeeList() throws NumberFormatException, IOException {
		List<List<String>> employeeStringList = employeeService.readFile();
		List<Employee> employeeList = new ArrayList<Employee>();
		for (List<String> employee : employeeStringList) {
			Employee e = new Employee();
			e.setEid(employee.get(0));
			e.setName(employee.get(1));
			e.setEmail(employee.get(2));
			e.setPhone(employee.get(3));
			e.setPosition(employee.get(4));
			if(employee.get(5).equals("RecentlyHired"))
				e.setCurrentState(new RecentlyHired(e));
			if(employee.get(5).equals("PendingReview"))
				e.setCurrentState(new PendingReview(e));
			if(employee.get(5).equals("ReviewComplete"))
				e.setCurrentState(new ReviewComplete(e));

			employeeList.add(e);
		}
		return employeeList;
	}

	public void updateEmployeeDirectory(List<Employee> employeeList) throws IOException {
		List<String> data = new ArrayList<>();
		for(Employee employee : employeeList) {
			data.add(employee.toString());
		}
		employeeService.writeFile(data);
	}

}
