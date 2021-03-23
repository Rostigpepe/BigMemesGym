package GymWakeUp;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		MassProduce.massProduce();
	
		//The start screen text
		welcomePrint();
		mainMenu();
					
	}

	
	
	public static void mainMenu() {
		//Scanner and variables
		Scanner uInput = new Scanner(System.in);
		boolean run = true;
		
		
		while(run) {
			String input = uInput.next();
			
			try {
				int uInputInt = Integer.parseInt(input);
				
				switch(uInputInt) {
				
				case 1:
					AccountManaging.register();
					welcomePrint();
					break;
					
				case 2:
					int userIndex = AccountManaging.login();
					
					if(userIndex >= 0) {
						userMenu(userIndex);
					}
					else {
						welcomePrint();
						break;
					}
					break;
					
					
				case 3:
					admMenu();
					welcomePrint();
					break;
					
				case 0:
					System.out.println("Bye!");
					run = false;
					break;
					
				default: 
					System.out.print("Please enter 1, or 2!\n");
					System.out.print(">> ");
					break;
				}

			}
			catch(Exception e) {
				System.out.println(e);
				System.out.println("Please enter 1, or 2!\n");
				System.out.print(">> ");
				input = uInput.toString();
			}

		}
	}
	
		
	//Made this into a method because i use it in several places
	public static void welcomePrint() {
		
		System.out.println("Welcome to Gym WakeUP!");
		System.out.println("To proceed, please enter one of the displayed options as the number!");
		System.out.println("1: Register");
		System.out.println("2: Login");
		//Again, very safe and absolutely no security flaws!
		System.out.println("3: Admin Menu");
		System.out.println("0: Exit");
		System.out.print(">> ");

		
	}
	
	
	//The method that runs when someone sucessfully logs in
	public static void userMenu(int userIndex) {
		boolean run = true;
		Scanner uInput = new Scanner(System.in);
		
		System.out.println("Welcome " + AccountManaging.getGymGoer(userIndex).getFirstName());
		
		while(run) {
			System.out.println("\nTo register for actitivies enter 1!");
			System.out.println("To remove activites you've registered for, enter 2!");
			System.out.println("To display your registered activites, enter 3!");
			System.out.println("To log out, enter 4!");
			
			String input = uInput.next();
			
			try {
				switch(Integer.parseInt(input)) {
				
				case 1:
					boolean miniRun = true;
					System.out.println("What activity do you want to register for?\n");
					
					Set<Integer> storedID = posActUser(userIndex);
					System.out.println("0: Cancel");
					System.out.println(">> ");
					
					while(miniRun) {
						
						input = uInput.next();
						
						try {
							int intInput = Integer.parseInt(input);
							
							//If the number input by the user exists in the set, then that activity is added to the gymgoers arraylist of activities
							if(storedID.contains(intInput)) {
								
								//For loop that prints the available spots of that activtiy
								//for(int i = 0; i < )
								//Adds it
								AccountManaging.getGymGoer(userIndex).addActivity(input);
								System.out.println("Successfully added!");
								
								miniRun = false;
							}
							else if(intInput == 0) {
								miniRun = false;
							}
							else {
								System.out.println("Please enter one of the previously displayed options!");
								System.out.print("Options: ");
								
								for(int i : storedID) {

									System.out.print(i + ", ");
								}
								
								System.out.print("\n>> ");
								miniRun = true;

							}
							
						}
						
						
						catch(Exception e) {
							System.out.println("Please enter one of the previously displayed options!");
							System.out.print("Options: ");
							
							for(int i : storedID) {

								System.out.print(i + ", ");
							}
							System.out.print("\n>> ");
							miniRun = true;
						}

					}
					
										
					break;
					
					
				case 2:
					Set<Integer> toRemove = new HashSet<Integer>();
					System.out.println("These are the activiteis you've registered for: ");
					
					for(int i = 0; i < AccountManaging.getGymGoer(userIndex).getSize(); i++) {
						System.out.println(AccountManaging.getGymGoer(userIndex).getActivity(i));
					}
					
					
					AccountManaging.getGymGoer(userIndex).removeActivity(null);
					break;
					
					
				case 3:
					int size = AccountManaging.getGymGoer(userIndex).getSize();
					AccountManaging.getGymGoer(userIndex).printActivities();
					
					if(size == 0) {
						System.out.println("You have no registered activities!");
					}
					else {
						System.out.println("The activities you have registered to are: ");
						
						for(int i = 0; i < size; i++) {
							System.out.println("Yeet");
							int activity = AccountManaging.getGymGoer(userIndex).getActivity(i);
							
							System.out.println(Activity.getActivityID(activity - 1) + ": " + Activity.getActivityName(activity - 1));
							
						}

					}
										
					break;
					
				case 4:
					System.out.println("You're now logged out!");
					userIndex = -1;
					run = false;
					break;
					
					
				default:
					System.out.println("Please enter of of the displayed options!\n\n");
					break;
				
					
				}

			}
			catch(Exception e) {
				System.out.println("Please only enter a number!");
			}
			
		}
		welcomePrint();
		mainMenu();
	}
	
	
	
	public static void admMenu() {
		Scanner uInput = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("\n1: Add activity");
			System.out.println("2: Remove activtiy");
			System.out.println("3: Remove user");
			System.out.println("4: Print activities");
			System.out.println("5: Print all SSNs");
			System.out.println("0: Exit");
			System.out.println(">> ");
			
			String input = uInput.next();
			
			try {
				int switchInput = Integer.parseInt(input);
				
				switch(switchInput) {
				
				case 1:
					Administration.addActivity();
					break;
					
				case 2:
					System.out.println("Please enter the ID of targeted activtiy");
					System.out.print(">> ");
					
					input = uInput.next();
					
					try {
						int intInput = Integer.parseInt(input);
						
						Administration.removeActivity(intInput);
					}
					catch(Exception e) {
						System.out.println("This went wrong: " + e);
					}
					
					break;
					
				case 3:
					System.out.println("Please enter the SSN of the user which will be removed");
					
					input = uInput.next();
					AccountManaging.removeGymGoer(input);
					break;
					
				case 4:
					System.out.println("Here are all the activities");
					
					for(int i = 0; i < Activity.getSize(); i++) {
						System.out.println(Activity.getActivityID(i) + ": " + Activity.getActivityName(i));
					}
					
					break;
					
				case 5:
					System.out.println("Here are all the users SSN");
					
					for(int i = 0; i < AccountManaging.getSize(); i++) {
						System.out.println("SSN: " + AccountManaging.getGymGoer(i).getssn() + " Name: " + AccountManaging.getGymGoer(i).getWholeName());
					}
					break;
					
				case 0:
					run = false;
					break;
					
				default:
					System.out.println("Please enter one of the displayed values!");
					break;
				
				}
			}
			
			catch(Exception e) {
				System.out.println("This went wrong: ");
				System.out.println("Please enter a correct value!");
				run = true;
			}
		}
	}
	
	
	//Method that prints the possible activities and returns a set of those activity IDs
	public static Set<Integer> posActUser(int userIndex) {
		Set<Integer> storedID = new HashSet<Integer>();
		Set<Integer> tempSet = new HashSet<Integer>();
		
		//Adds the activities the user is currently registered to to a set
		//This is so we can compare the rest of the activities to what the user already has, so we dont print what the user already has
		for (int i = 0; i < AccountManaging.getGymGoer(userIndex).getSize(); i++) {
			int setAdd = AccountManaging.getGymGoer(userIndex).getActivity(i);
			
			tempSet.add(setAdd);
		}
		
		
		for(int i = 0; i < Activity.getSize(); i++) {
			if(tempSet.contains(Activity.getActivityID(i)) == false) {
				//A set to store the possible activities
				int storedIDAdd = Activity.getActivityID(i);
				
				storedID.add(storedIDAdd);
				
				System.out.println((Activity.getActivityID(i)) + ": " + Activity.getActivityName(i) + "\n" );
			}
			
		}
		return storedID;
		
	}

}
