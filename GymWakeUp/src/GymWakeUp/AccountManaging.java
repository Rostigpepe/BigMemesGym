package GymWakeUp;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountManaging {

	private static ArrayList<GymGoer> GymGoers = new ArrayList<GymGoer>();

	
	public static int getSize() {
		return GymGoers.size();
	}
	
	
	public static void register() {

		Scanner uInput = new Scanner(System.in); 

		System.out.print("Please enter your social security number following this format yymmddnnnn:  ");
		String ssn = ssnCheck();

		if(ssn == null) {
			System.out.println("Please try again\n");

		}
		else if (ssn != "null") {
			System.out.println(ssn);

			System.out.print("Please enter your first name:  ");
			String firstName = uInput.next();

			System.out.print("Please enter your last name:  ");
			String lastName = uInput.next();

			System.out.print("Please enter your email adress:  ");
			String email = uInput.next();

			System.out.print("Please enter your password:  ");
			String password = uInput.next();


			try {
				//Write these to some file to save the user
				//Thats what needs to be done to finsh the register part
				GymGoer GymGoer = new GymGoer(ssn, firstName, lastName, email, password);
				GymGoers.add(GymGoer);
				System.out.print("You're now registered!\n\n");

			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Something went wrong, please try again!" + e);
			}


		}
		return;
	}

	
	
	public static String ssnCheck() {

		int[] ssnTemp = new int[10];
		int i = 0;
		double secCheck = 0;

		Scanner uInput = new Scanner(System.in); 


		String ssn = uInput.next();
		String[] out = ssn.split("|");
		if(out.length == 10) {
			try {

				for( i = 0; i < out.length; i++) {
					ssnTemp[i] = Integer.parseInt(out[i]);
				}

			}

			catch (Exception e) {
				System.out.println("Error: Did you follow the format? " + e); 	
			}

			for( i = 0; i < ssnTemp.length; i+=2) {
				int tempHold;

				tempHold = ssnTemp[i] * 2;
				if (tempHold >= 10) {
					int x = tempHold / 10;
					int z = tempHold % 10;
					ssnTemp[i] = x + z;
				}
				else {
					ssnTemp[i] = tempHold;
				}

			}

			for( i = 0; i < ssnTemp.length; i++) {
				secCheck += ssnTemp[i];
			}
			secCheck = secCheck / 10;

			if (secCheck % 1 == 0) {
				return ssn;
			}
			else {
				System.out.println("Invalid SSN");
				return null;
			}

		}
		else if(out.length < 10){
			System.out.println("Your ssn is too short");
			return null;
		}
		else{
			System.out.println("Your ssn is too long");
			return null;
		}
	}
	
	
	
	public static int login() {
			
		Scanner uInput = new Scanner(System.in); 
		
		System.out.println("Please enter your Social Security Number");
		System.out.print(">> ");
		String SSN = uInput.next();
		System.out.println(SSN);
		
		System.out.println("Please enter your Password");
		System.out.print(">> ");
		String pass = uInput.next();
		System.out.println(pass);
		
		
		int foundSSN = findSSN(SSN);
		
		if(foundSSN >= 0) {
			
			boolean correctPass = checkPass(pass, foundSSN);
			if(correctPass) {
				System.out.println("Success");
				return foundSSN;
			}
			else {
				System.out.println("The SSN or the Password was incorrect, please try again!1\n");
				foundSSN = -1;
				return foundSSN;
			}
			
		}
		else {
			System.out.println("The SSN or the Password was incorrect, please try again!2\n");
			return foundSSN;
		}
		
	}
	
	
	//Finds the SSN of a specifc user
	public static int findSSN(String SSN) {
		boolean miniRun = true;
		boolean found = false;	
		int index = 0;
		
		
			//
			for(int i = 0; i < GymGoers.size(); i++) {
				
				if(GymGoers.get(i).getssn().equals(SSN)) {
					index = i;
					i = GymGoers.size() + 1;
					
					found = true;
				}
				else {
					found = false;
				}
			}


			
			
			if(found == true) {
				return index;
			}
			else {
				return -1;
			}
		}
	
	
	//Checks if the password entered equals that of which is stored in the user class
	public static boolean checkPass(String pass, int index) {
		
		if(pass.equals(GymGoers.get(index).getPassword())) {
			return true;
		}
		else {
			return false;
		}
		
	}



	//Method for getting one of the gym goers from the arraylist
	public static GymGoer getGymGoer(int userIndex) {
		
		return GymGoers.get(userIndex);
		
	}
	


	//just for my massproduce class
	public static void addNewGymGoer(String SSN, 
			String firstName, 
			String lastName, 
			String email, 
			String password) {
		
		GymGoer GymGoer = new GymGoer(SSN, firstName, lastName, email, password);
		GymGoers.add(GymGoer);
		
	}
	
	
	
	public static void removeGymGoer(String SSN) {
		
		int index = findSSN(SSN);
		
		if(index >= 0) {
			GymGoers.remove(index);
			System.out.println("Successfully removed user!");
		}
		else {
			System.out.println("This user does not exist!");
		}
		
	}
}
