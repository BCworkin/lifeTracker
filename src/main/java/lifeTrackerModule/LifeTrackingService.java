package lifeTrackerModule;

import org.springframework.stereotype.Service;


@Service
public class LifeTrackingService {

	private final StatStorage store;
	
	public LifeTrackingService(StatStorage store) {
		this.store = store;
	}

    public void addEntry(LifeDetails entry) {
        store.save(entry);
    }

    public void printAllEntries() {
        store.getAll().forEach(entry -> System.out.println(entry.getCurrentTime() + " | " + entry.getMood() + " | " + entry.getType())
        );
    }
}
