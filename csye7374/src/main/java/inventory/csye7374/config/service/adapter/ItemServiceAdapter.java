package inventory.csye7374.config.service.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import inventory.csye7374.config.service.ItemService;
import inventory.csye7374.model.Item;

public class ItemServiceAdapter {
	
	@Autowired
	private ItemService itemService;
	
	public List<Item> getItemList() throws NumberFormatException, IOException {
		List<List<String>> itemStringList = itemService.readFile();
		List<Item> itemList = new ArrayList<Item>();
		for(List<String> item : itemStringList) {
			Item i = new Item();
			i.setSlNo(item.get(0));
			i.setItemName(item.get(1));
			i.setItemCost(Double.parseDouble(item.get(3)));
			i.setAvailable(Integer.parseInt(item.get(4)));
			itemList.add(i);
		}
		return itemList;
	}

}
