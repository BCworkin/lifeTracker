package lifeTrackerModule;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserList {
	
	private final List<User> users = new ArrayList<>();
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void removeUser(User user) {
		users.remove(user);
	}
	
	public User getUser(String name) {
		for (User user : users) {
			if (user.getname().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}
	
	
	public List<User> getUsers() {
		return users;
	}

	public int size() {
		return users.size();
	}
	}
