package lifeTrackerModule;

import java.util.ArrayList;
import java.util.List;

public class StatStorage {

	private final List<LifeDetails> details = new ArrayList<>();
	
	public void save(LifeDetails entry) {
		details.add(entry);
	}
	
	public List<LifeDetails> getAll() {
		return details;
	}
}
