package lifeTrackerModule;


import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.format.DateTimeFormatter;

@Service
public class LifeTrackingService {

	private final UserService userService; 
	private final LifeDetailsRepo lifeDetailsRepo;
	
	@Autowired
	public LifeTrackingService(UserService userService, LifeDetailsRepo lifeDetailsRepo) {
		this.userService = userService;
		this.lifeDetailsRepo = lifeDetailsRepo;
	}
	
	@Transactional
    public void addEntry(User user, LifeDetails entry) {
        entry.setUser(user);
        lifeDetailsRepo.save(entry);
        userService.saveUser(user);
    }

    public void printAllEntries() {
    	for (User user : userService.getAllUsers()) {
    		System.out.println("Life Entries for " + user.getname() + ": ");
    		System.out.println("Money: " + user.getMoney() + " | Health: " + user.getHealth() + " | Mental: " + user.getMental());
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    		for (LifeDetails detail : lifeDetailsRepo.findByUser(user)) {
        		System.out.println(detail.getCurrentTime().format(formatter) + " | " + detail.getMood() + " | " + detail.getType());
    		}
    	}
    }
}
