package lifeTrackerModule;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int healthStat = 50;
	private int mentalStat = 50;
	private int aestheticStat = 50;
	private float money = 0;
	private String name;
	
	private final List<LifeDetails> lifeEntries = new ArrayList<>();

	public User(String name) {
		this.name = name;
	}
	
	public String getname() {
		return name;
	}
	
	public int getHealth() {
		return healthStat;
	}
	
	public void addHealth(int health) {
		healthStat += health;
	}
	
	public int getMental() {
		return mentalStat;
	}
	
	public void addMental(int mental) {
		mentalStat += mental;
	}
	
	
	public int getAesthetic() {
		return aestheticStat;
	}
	
	public void addAesthetic(int aesthetic) {
		aestheticStat += aesthetic;
	}
	
	public float getMoney() {
		return money;
	}
	
	public List<LifeDetails> getEntries() {
		return lifeEntries;
	}
	
    public void addLifeEntry(LifeDetails entry) {
        lifeEntries.add(entry);
    }
	
}
