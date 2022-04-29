package inventory.csye7374.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import inventory.csye7374.config.service.facade.EmployeeServiceFacade;
import inventory.csye7374.model.Employee;
import inventory.csye7374.model.Item;
import inventory.csye7374.model.Order;
import inventory.csye7374.model.OrderPlaced;

public class EmployeeController {

	@Autowired
	private EmployeeServiceFacade employeeServiceFacade;

	@RequestMapping(value = "/employeeList")
	public ModelAndView employeeList(HttpServletResponse response) throws IOException {
		return new ModelAndView("employeeList");
	}

	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Employee> employeeList = employeeServiceFacade.returnEmployeeList();

		Set<String> requestList = request.getParameterMap().keySet();
		HashMap<String, Employee> employeeMap = new HashMap<>();

		List<Employee> employees = new ArrayList<>();
		for (Employee employee : employeeList) {
			employeeMap.put(employee.getEid(), employee);
		}

		for (String eid : requestList) {
			if (employeeMap.containsKey(eid)) {
				Employee e = employeeMap.get(eid);
				if (e.getCurrentState().toString().equals("RecentlyHired"))
					e.setCurrentState(e.getReviewPending());
				if (e.getCurrentState().toString().equals("ReviewPending"))
					e.setCurrentState(e.getReviewComplete());
				if (e.getCurrentState().toString().equals("ReviewComplete"))
					e.setCurrentState(e.getReviewPending());
				employeeMap.replace(eid, e);
			}
		}
		
		employeeServiceFacade.updateEmployeeRegistry(new ArrayList<>(employeeMap.values()));
	}
}
