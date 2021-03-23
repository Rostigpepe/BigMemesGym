package GymWakeUp;


//Class to store whether a spot is taken or not
public class Spot {

	private Boolean occupied;
	private int spot;
	
	
	public Spot(int spot) {
		this.spot = spot;
		this.occupied = false;
	}
	
	
	public Boolean getOccupied() {
		return this.occupied;
	}
	
	//Returns the 
	public String getSpot() {
		if(this.spot <= 3) {
			return "A" + spot;
		}
		else if (spot >= 4 && spot <= 6) {
			return "B" + (spot - 3);
		}
		else {
			return "C" + (spot - 6);
		}
	}
	
	
	
	public void setOccupied(Boolean update) {
		this.occupied = update;
	}
}
