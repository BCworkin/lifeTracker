package lifeTrackerModule;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main {
	
    public static void main(String[] args) {
    	
    	ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
    	
    	LifeTrackingService service = context.getBean(LifeTrackingService.class);
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Welcome to LifeLedger!");
    	
    	
    	boolean running = true;
    	
		System.out.print("Who are we speaking to today?");
		String name = scanner.nextLine();
		
		User user = service.getUser(name);
		System.out.println("How's your day going!");

		
    	while (running) {
    		
    		
    		System.out.println("1. Log Experiences");
    		System.out.println("2. View Life Stats");
    		System.out.println("3. Exit");
    		
    		System.out.println(" ");
    		System.out.print("Make your choice, master.");
    		String choice = scanner.nextLine();
    		
    		switch (choice) {
            case "1":
                System.out.print("Enter details of experience: ");
                String content = scanner.nextLine();

                System.out.println("Select mood (HAPPY, MID, SAD, DISAPPOINTED, ECSTATIC): ");
                Mood mood = null;
                while (mood == null) {
                    String moodInput = scanner.nextLine().toUpperCase();
                    try {
                        mood = Mood.valueOf(moodInput);
                        switch (mood) {
                        case HAPPY:
                            user.addMental(10);
                            break;
                        case MID:
                            user.addMental(1);
                            break;
                        case SAD:
                            user.addMental(-5);
                            break;
                        case DISAPPOINTED:
                            user.addMental(-10);
                            break;
                        case ECSTATIC:
                            user.addMental(15);
                            break;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.print("Invalid mood. Try again: ");
                    }
                }
                

                System.out.println("Select type (SPENDING, EARNING, EXERCISING, SOCIALISING, CODING, DATING, DOOMSCROLLING, LEARNING, FAMILYTIME, RESTING, UNHEALTHY): ");
                ActionType type = null;
                while (type == null) {
                    String typeInput = scanner.nextLine().toUpperCase();
                    try {
                        type = ActionType.valueOf(typeInput);
                        switch (type) {
                        // work on this part, case is a little iffy on replies
                        case SPENDING:
                            System.out.println("How much did you spend today? ");
                            Float outFlow = scanner.nextFloat();
                            scanner.nextLine();
                            user.addMoney(-outFlow);
                            break;
                        case EARNING:
                            System.out.println("How much did you earn today? ");
                            Float inFlow = scanner.nextFloat();
                            scanner.nextLine();
                            user.addMoney(inFlow);
                            break;
                        case EXERCISING:
                            user.addHealth(10);
                            user.addMental(5);
                            user.addAesthetic(10);
                            break;
                        case SOCIALISING:
                            user.addMental(15);
                            break;
                        case CODING:
                            user.addSmarts(20);
                            break;
                        case DATING:
                            user.addMental(20);
                            break;
                        case DOOMSCROLLING:
                            user.addMental(-10);
                            break;
                        case LEARNING:
                            user.addSmarts(10);
                            break;
                        case FAMILYTIME:
                            user.addMental(10);
                            break;
                        case RESTING:
                            user.addMental(2);
                            break;
                        case UNHEALTHY:
                            user.addMental(-15);
                            break;
                        }
                        LifeDetails entry = new LifeDetails(content, mood, type);
                        service.addEntry(name, entry);
                        System.out.println("Entry added!");
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.print("Invalid type. Try again: ");
                    }
                }
                break;

            case "2":
                System.out.println("\nAll LifeLedger Entries:");
                service.printAllEntries();
                break;

            case "3":
                running = false;
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Invalid option, try again.");
    		}

    	}
        scanner.close();
    	    	
    }

}
