package lifeTrackerModule;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatStorage {

	private final List<LifeDetails> details = new ArrayList<>();
	
	public void save(LifeDetails entry) {
		details.add(entry);
	}
	
	public List<LifeDetails> getAll() {
		return details;
	}
}
