package inventory.csye7374.config.service.adapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import inventory.csye7374.config.legacy.OrderService;
import inventory.csye7374.model.Item;
import inventory.csye7374.model.Order;
import inventory.csye7374.model.OrderComplete;
import inventory.csye7374.model.OrderInProgress;
import inventory.csye7374.model.OrderPlaced;
import inventory.csye7374.model.State;

@Component
public class OrderServiceAdapter {
	
	@Autowired
	private OrderService orderService;
	
	public File getFile() {
		return new File(orderService.getFileName());
	}

	public void checkFileExists(File file) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	public void addOrder(Order order) throws IOException {
		List<String> data = new ArrayList<>();
		data.add(order.getCustomerName());
		data.add(order.getItem().getSlNo());
		data.add(order.getItem().getItemName());
		data.add(String.valueOf(order.getItem().getItemCost()));
		data.add(String.valueOf(order.getQuantity()));
		data.add(getStateString(order.getCurrentState()));
		orderService.writeFile(data);
	}

	private String getStateString(State currentState) {
		if(currentState instanceof OrderPlaced) {
			return "OrderPlaced";
		} else if (currentState instanceof OrderInProgress) {
			return "OrderInProgress";
		} else {
			return "OrderComplete";
		}
	}

	public List<Order> getOrdersByCustomerName(String customerName) throws IOException {
		List<List<String>> orderRecordList = orderService.readFile();
		List<Order> orderList = new ArrayList<>();
		for(List<String> rowList : orderRecordList) {
			if(rowList.get(0).equals(customerName)) {
				Order order = new Order();
				order.setCustomerName(customerName);
				Item item = new Item();
				item.setSlNo(rowList.get(1));
				item.setItemName(rowList.get(2));
				item.setItemCost(Double.valueOf(rowList.get(3)));
				order.setItem(item);
				order.setQuantity(Integer.valueOf(rowList.get(4)));
				order.setCurrentState(getStateFromStateString(rowList.get(5), order));
				orderList.add(order);
			}
		}
		return orderList;
	}

	private State getStateFromStateString(String currentStateString, Order order) {
		if(currentStateString.equals("OrderPlaced")) {
			return new OrderPlaced(order);
		} else if (currentStateString.equals("OrderInProgress")) {
			return new OrderInProgress(order);
		} else {
			return new OrderComplete(order);
		}
	}
}
