package inventory.csye7374.config.service.facade;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import inventory.csye7374.config.service.adapter.OrderServiceAdapter;
import inventory.csye7374.model.Order;

@Component
public class OrderServiceFacade {
	
	@Autowired
	private OrderServiceAdapter orderServiceAdapter;

	public void addOrders(List<Order> orders) throws IOException {
		orderServiceAdapter.checkFileExists(orderServiceAdapter.getFile());
		for(Order order: orders) {
			orderServiceAdapter.addOrder(order);
		} 		
	}

	public List<Order> getOrdersByCustomerName(String customerName) throws IOException {
		orderServiceAdapter.checkFileExists(orderServiceAdapter.getFile());
		return orderServiceAdapter.getOrdersByCustomerName(customerName);
	}

}
