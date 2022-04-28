package inventory.csye7374.config.service.facade;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import inventory.csye7374.config.service.adapter.ItemServiceAdapter;
import inventory.csye7374.model.Item;

@Component
public class ItemServiceFacade {

	@Autowired
	private ItemServiceAdapter itemServiceAdapter;

	public List<Item> returnItemList() {
		try {
			itemServiceAdapter.checkFileExists(itemServiceAdapter.getFile());
			return itemServiceAdapter.getItemList();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void changeInventoryCount(List<Item> itemList) {
		try {
			itemServiceAdapter.checkFileExists(itemServiceAdapter.getFile());
			itemServiceAdapter.updateAvailability(itemList);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
