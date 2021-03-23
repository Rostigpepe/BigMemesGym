package GymWakeUp;
import java.util.Scanner;

public class Administration {

	
	//Adds an activity to the end of the arraylist of activites, also sets the id to that index + 1
	public static void addActivity() {
		Scanner uInput = new Scanner(System.in); 
		
		int tempIndex = Activity.getSize();
		
		int ID = Activity.getActivityID(tempIndex - 1) + 1;
		
		System.out.print("Please enter the activities name:  ");
		String name = uInput.next();

		System.out.print("Please enter the activities description:  ");
		String desc = uInput.next();

		Activity Activity = new Activity(ID, name, desc);
		Activity.addActivity(Activity);
	}
	
	
	
	public static void removeActivity(int ID) {
		//Bool used to say that nothing was found if nothing was found
		boolean nothingFound = true;
		
		for(int i = 0; i < Activity.getSize(); i++) {
			if(Activity.getActivityID(i) == ID) {
				//Makes so the method wont say that nothing was found
				nothingFound = false;
				
				//Removes the activity
				Activity.removeActivtiy(i);
				
				//Stops the for loop
				i = Activity.getSize() + 1;
				
				System.out.println("Successfully removed!");
			}
			
		}
		
		if(nothingFound) {
			System.out.println("Nothing was found!");
		}
		
	}
	
}
