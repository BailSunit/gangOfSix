package inventory.csye7374.config.service.adapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import inventory.csye7374.config.legacy.OrderService;
import inventory.csye7374.model.Item;
import inventory.csye7374.model.Order;

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
		data.add(order.getOrderId().toString());
		data.add(order.getCustomerName());
		data.add(order.getItem().getSlNo());
		data.add(order.getItem().getItemName());
		data.add(String.valueOf(order.getItem().getItemCost()));
		data.add(String.valueOf(order.getQuantity()));
		data.add(order.getCurrentStateName());
		orderService.writeFile(data);
	}

	public List<Order> getOrdersByCustomerName(String customerName) throws IOException {
		List<List<String>> orderRecordList = orderService.readFile();
		List<Order> orderList = new ArrayList<>();
		for (List<String> rowList : orderRecordList) {
			if (rowList.get(1).equals(customerName)) {
				Order order = new Order();
				order.setOrderId(UUID.fromString(rowList.get(0)));
				order.setCustomerName(customerName);
				Item item = new Item();
				item.setSlNo(rowList.get(2));
				item.setItemName(rowList.get(3));
				item.setItemCost(Double.valueOf(rowList.get(4)));
				order.setItem(item);
				order.setQuantity(Integer.valueOf(rowList.get(5)));
				order.setCurrentState(order.getCurrentStateFromName(rowList.get(6)));
				orderList.add(order);
			}
		}
		return orderList;
	}

	public List<Order> completeOrderList() throws IOException {
		List<List<String>> orderRecordList = orderService.readFile();
		List<Order> orderList = new ArrayList<>();
		for (List<String> rowList : orderRecordList) {
			Order order = new Order();
			order.setOrderId(UUID.fromString(rowList.get(0)));
			order.setCustomerName(rowList.get(1));
			Item item = new Item();
			item.setSlNo(rowList.get(2));
			item.setItemName(rowList.get(3));
			item.setItemCost(Double.valueOf(rowList.get(4)));
			order.setItem(item);
			order.setQuantity(Integer.valueOf(rowList.get(5)));
			order.setCurrentState(order.getCurrentStateFromName(rowList.get(6)));
			orderList.add(order);
		}
		return orderList;
	}

	public void startTheProgress(List<Order> orders) throws IOException {
		List<String> data = new ArrayList<>();
		for (Order order : orders) {
			if (order.getCurrentState().toString().equals("OrderPlaced")) {
				order.getCurrentState().orderInProgress();
			}
			data.add(order.toString());
		}
		orderService.replaceFile(data);
	}

	public void setOrderComplete(List<Order> orders) throws IOException {
		List<String> data = new ArrayList<>();
		for (Order order : orders) {
			data.add(order.toString());
		}
		orderService.replaceFile(data);
	}
}
