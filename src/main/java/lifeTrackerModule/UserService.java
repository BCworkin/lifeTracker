package lifeTrackerModule;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserService {
	
	private final UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
    public User getOrCreateUser(String name) {
        User user = userRepo.findByNameIgnoreCase(name);
        if (user == null) {
            user = new User(name);
            userRepo.save(user);
            System.out.println("New user created: " + name);
        }
        System.out.println("Hi, " + name);
        return user;
    }

	public void removeUser(User user) {
		userRepo.delete(user);
	}
	
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
}
