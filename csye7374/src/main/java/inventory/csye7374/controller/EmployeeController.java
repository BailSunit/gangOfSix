package inventory.csye7374.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import inventory.csye7374.config.service.facade.EmployeeServiceFacade;
import inventory.csye7374.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceFacade employeeServiceFacade;

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public ModelAndView employeeList(HttpServletResponse response) throws IOException {
		List<Employee> employeeList = employeeServiceFacade.returnEmployeeList();
		return new ModelAndView("employeeList", "employeeList", employeeList);
	}

	@RequestMapping(value = "/employeeList", method = RequestMethod.POST)
	public ModelAndView updateStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Employee> employeeList = employeeServiceFacade.returnEmployeeList();

		Set<String> requestList = request.getParameterMap().keySet();
		HashMap<String, Employee> employeeMap = new HashMap<>();

		for (Employee employee : employeeList) {
			employeeMap.put(employee.getEid(), employee);
		}

		for (String eid : requestList) {
			if (employeeMap.containsKey(eid)) {
				Employee e = employeeMap.get(eid);
				if (e.getCurrentState().toString().equals("RecentlyHired"))
					e.getCurrentState().reviewPending();
				else if (e.getCurrentState().toString().equals("PendingReview")) {
					e.getCurrentState().reviewComplete();
				}
				else if (e.getCurrentState().toString().equals("ReviewComplete"))
					e.getCurrentState().reviewPending();
				employeeMap.replace(eid, e);
			}
		}
		List<Employee> updatedList = new ArrayList<>(employeeMap.values());
		employeeServiceFacade.updateEmployeeRegistry(updatedList);
		return new ModelAndView("employeeList", "employeeList", updatedList);
	}
}
