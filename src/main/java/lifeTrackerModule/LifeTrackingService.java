package lifeTrackerModule;

public class LifeTrackingService {

	 private final StatStorage store = new StatStorage();

    public void addEntry(LifeDetails entry) {
        store.save(entry);
    }

    public void printAllEntries() {
        store.getAll().forEach(entry -> System.out.println(entry.getCurrentTime() + " | " + entry.getMood() + " | " + entry.getType())
        );
    }
}
