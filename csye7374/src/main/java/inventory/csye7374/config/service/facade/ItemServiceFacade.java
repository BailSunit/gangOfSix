package inventory.csye7374.config.service.facade;

import org.springframework.beans.factory.annotation.Autowired;

import inventory.csye7374.config.service.adapter.ItemServiceAdapter;

public class ItemServiceFacade {
	
	@Autowired
	private ItemServiceAdapter itemServiceAdapter;
	
	

}
