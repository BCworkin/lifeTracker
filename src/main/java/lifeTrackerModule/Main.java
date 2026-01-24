package lifeTrackerModule;

import java.util.Scanner;


public class Main {
	
    public static void main(String[] args) {
    	
    	LifeTrackingService service = new LifeTrackingService();
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Welcome to LifeLedger!");
    	
    	boolean running = true;
    	
    	while (running) {
    		System.out.println("How's your day going!");
    		System.out.println("1. Log Experiences");
    		System.out.println("2. View Life Stats");
    		System.out.println("3. Exit");
    		
    		System.out.print("Make your choice, master.");
    		String choice = scanner.nextLine();
    		
    		switch (choice) {
            case "1":
                System.out.print("Enter details of experience: ");
                String content = scanner.nextLine();

                System.out.println("Select mood (HAPPY, MID, SAD, LETHARGIC, DRAINED, DISAPPOINTED, ECSTATIC): ");
                Mood mood = null;
                while (mood == null) {
                    String moodInput = scanner.nextLine().toUpperCase();
                    try {
                        mood = Mood.valueOf(moodInput);
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
                    } catch (IllegalArgumentException e) {
                        System.out.print("Invalid type. Try again: ");
                    }
                }

                LifeDetails entry = new LifeDetails(content, mood, type);
                service.addEntry(entry);
                System.out.println("Entry added!");
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
