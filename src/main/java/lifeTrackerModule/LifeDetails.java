package lifeTrackerModule;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "life_details")
public class LifeDetails {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(nullable = false)
	private LocalDateTime currentTime;
    
    @Enumerated(EnumType.STRING)
	private Mood mood;
    
    @Enumerated(EnumType.STRING)
	private ActionType type;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  
	
	public LifeDetails(String content, Mood mood, ActionType type) {
        this.currentTime = LocalDateTime.now();
        this.mood = mood;
        this.type = type;
    }
	
    public Long getId() {
        return id;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public Mood getMood() {
        return mood;
    }
    
    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public ActionType getType() {
        return type;
    }
    
    public void setType(ActionType type) {
        this.type = type;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}
	
