package lifeTrackerModule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LifeDetailsRepo extends JpaRepository <LifeDetails, Long> {
	
	List<LifeDetails> findByUser(User user);
}	

