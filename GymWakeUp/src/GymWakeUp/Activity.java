package GymWakeUp;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Activity {

	private static ArrayList<Activity> Activities = new ArrayList<Activity>();
	private ArrayList<Spot> Spots = new ArrayList<Spot>();
	//private ArrayList<Boolean> freeSpot = new ArrayList<Boolean>();
	
	
	private int ID;
	private String name;
	private String desc;
	
	
	public Activity(int ID,
			String name,
			String desc) {
		
		this.ID = ID;
		this.name = name;
		this.desc = desc;
		
		//Adds all 9 spots to the activity
		for(int i = 0; i < 9; i++) {
			Spot Spot = new Spot(i);
			Spots.add(Spot);
		}
	}
	
	
	
	public int getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	/*public Boolean getSpot(int index) {
		return spot.get(index);
	}*/
	
	
	
	//A method that returns a list with the available spots
	/*
	public static ArrayList<Integer> getFreeSpots(int index){
		ArrayList<Integer> freeSpots = new ArrayList<Integer>();
	
		for(int i = 0; i < 0; i++) {
			if(Activities.get(index).getSpot(i) == true) {
				freeSpots.add(i);
			}
		}
		
		return freeSpots;
		
	}
	*/
	
	public static void addActivity(Activity Activity) {
		Activities.add(Activity);
	}
	
	public static void removeActivtiy(int index) {
		Activities.remove(index);
	}
	
	public static int getSize() {
		return Activities.size();
	}
	
	public static String getActivityName(int index) {
		return Activities.get(index).getName();
	}
	
	public static int getActivityID(int index) {
		return Activities.get(index).getID();
	}
	
	public static void addNewActivity(String name, 
			String desc) {
		
		int ID = Activities.size() + 1;
		
		Activity Activity = new Activity(ID, name, desc);
		Activities.add(Activity);
		
	}

	
}
