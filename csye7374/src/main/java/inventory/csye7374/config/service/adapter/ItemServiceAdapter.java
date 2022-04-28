package inventory.csye7374.config.service.adapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import inventory.csye7374.config.legacy.ItemService;
import inventory.csye7374.model.Item;

@Component
public class ItemServiceAdapter {

	@Autowired
	private ItemService itemService;

	public File getFile() {
		return new File(itemService.getFileName());
	}

	public void checkFileExists(File file) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	public List<Item> getItemList() throws NumberFormatException, IOException {
		List<List<String>> itemStringList = itemService.readFile();
		List<Item> itemList = new ArrayList<Item>();
		for (List<String> item : itemStringList) {
			Item i = new Item();
			i.setSlNo(item.get(0));
			i.setItemName(item.get(1));
			i.setItemCost(Double.parseDouble(item.get(2)));
			i.setAvailable(Integer.parseInt(item.get(3)));
			if (i.getAvailable() > 0)
				itemList.add(i);
		}
		return itemList;
	}

	public void updateAvailability(List<Item> itemList) throws IOException {
		List<String> data = new ArrayList<>();
		for(Item item : itemList) {
			data.add(item.toString());
		}
		itemService.writeFile(data);
	}

}
