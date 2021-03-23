package GymWakeUp;
import java.util.ArrayList;

public class GymGoer {

	private ArrayList<String> RegAct = new ArrayList<String>();
	
	private String ssn;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
	public GymGoer(String ssn, 
			String firstName, 
			String lastName, 
			String email, 
			String password){
		
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		
	}
	
	
	
	public String getssn() {
		return this.ssn;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getWholeName() {
		String wholeName = this.firstName + " " + this.lastName;
		
		return wholeName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	//Oh very safe!
	public String getPassword() {
		return this.password;
	}
	
	public int getActivity(int index) {
		int ID = Integer.parseInt(RegAct.get(index));
		return ID;
	}
	
	
	public void printActivities() {
		for(int i = 0; i < RegAct.size(); i++) {
			System.out.println(RegAct.get(i));
		}
	}
	
	
	public int findActivtiy(String activity) {
		int index = -1;
		
		for(int i = 0; i < RegAct.size(); i++) {
			
			if(RegAct.get(i) == activity) {
				index = i;
				i = RegAct.size() + 1;
			}
		}
		
		return index;
	}
		
	//Adds activity to the gymgoer
	public void addActivity(String ID){
		RegAct.add(ID);
	}
	
	
	//Removes activity from the gymgoer
	public void removeActivity(String ID) {
		Boolean removed = false;
		
		for(int i = 0; i < RegAct.size(); i++) {
			if(RegAct.get(i) == ID) {
				RegAct.remove(i);
				i = RegAct.size() + 1;
				removed = true;
				
				System.out.println("Successfully removed activtiy");
			}	
		}
		
		if(removed == false) {
			System.out.println("Something went wrong");
		}
	}
	
	public int getSize() {
		return RegAct.size();
	}
	
}
