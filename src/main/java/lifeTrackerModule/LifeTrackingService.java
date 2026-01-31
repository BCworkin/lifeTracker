package lifeTrackerModule;

import org.springframework.stereotype.Service;


@Service
public class LifeTrackingService {

	private final UserList userList;
	
	public LifeTrackingService(UserList userList) {
		this.userList = userList;
	}
	
	public User getUser(String name) {
		User user = userList.getUser(name);
        if (user == null) {
            user = new User(name);
            userList.addUser(user);
            System.out.println("New user created: " + name);
        }
        System.out.println("Hi, " + name);
        return user;
	}

    public void addEntry(String userName, LifeDetails entry) {
        User user = userList.getUser(userName);
        
        if (user != null) {
            user.addLifeEntry(entry);  
        } else {
            System.out.println("User is not found.");
        }
    }

    public void printAllEntries() {
    	for (User user : userList.getUsers()) {
    		System.out.println("Life Entries for " + user.getname() + ": ");
    		System.out.println("Money: " + user.getMoney() + " | Health: " + user.getHealth() + " | Mental: " + user.getMental());
    		for (LifeDetails detail : user.getEntries()) {
        		System.out.println(detail.getCurrentTime() + " | " + detail.getMood() + " | " + detail.getType());
    		}
    	}
    }
}
