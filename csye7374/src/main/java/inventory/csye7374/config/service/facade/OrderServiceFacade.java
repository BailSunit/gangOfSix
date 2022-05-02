package inventory.csye7374.config.service.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
	
	public List<Order> getAllOrder() throws IOException {
		orderServiceAdapter.checkFileExists(orderServiceAdapter.getFile());
		return orderServiceAdapter.completeOrderList();
	}

	public void setInProgress(List<Order> orders) throws IOException {
		orderServiceAdapter.startTheProgress(orders);
	}

	public List<Order> getRequestedOrders(Set<String> requestList) throws IOException {
		List<Order> requestedList = getAllOrder();
		List<Order> returnedList = new ArrayList<>();
		for(Order order : requestedList) {
			if(requestList.contains(order.getOrderId().toString())) {
				returnedList.add(order);
			}
		}
		return returnedList;
	}

	public void updateOrderStatus(List<Order> orders) throws IOException {
		List<Order> allOrders = getAllOrder();
		HashMap<UUID, Order> orderMap = new HashMap<>();
		for(Order o : allOrders) 
			orderMap.put(o.getOrderId(), o);
		for(Order order : orders) {
			Order rep = order;
			if(rep.getCurrentState().toString().equals("OrderPlaced"))
				rep.orderInProgress();
			else if(rep.getCurrentState().toString().equals("OrderInProgress"))
				rep.orderComplete();
			orderMap.replace(rep.getOrderId(), rep);
		}
		orderServiceAdapter.setOrderComplete(new ArrayList<>(orderMap.values()));
	}

}
