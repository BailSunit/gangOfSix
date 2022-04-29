package inventory.csye7374.config.legacy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import inventory.csye7374.model.User;

@Service
public class UserService {
	
	Map<String, String> validUserMap;
	
	public UserService() {
		validUserMap = new HashMap<>();
		validUserMap.put("test1", "test1");
		validUserMap.put("test2", "test2");
	}
	
	public boolean validateUser(User user) {
		if(validUserMap.containsKey(user.getUsername())) {
			String validPass = validUserMap.get(user.getUsername());
			if(validPass.equals(user.getPassword())) 
				return true;
		}
		return false;
	}

}
