package lifeTrackerModule;

import java.time.LocalDateTime;


public class LifeDetails {
	
	private final LocalDateTime currentTime;
	private final Mood mood;
	private final ActionType type;
	
	public LifeDetails(String content, Mood mood, ActionType type) {
        this.currentTime = LocalDateTime.now();
        this.mood = mood;
        this.type = type;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public Mood getMood() {
        return mood;
    }

    public ActionType getType() {
        return type;
    }
}
	
