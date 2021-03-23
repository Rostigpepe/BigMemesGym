package GymWakeUp;

//This is just a class to add test objects

public class MassProduce {
	
	
	public static void massProduce() {
		AccountManaging.addNewGymGoer("0101010101", "Robin", "Stenskytt", "robin@gmail.com", "yes");
		AccountManaging.addNewGymGoer("0808080808", "Angry", "Person", "redbull@redbull.redbull", "yes");
		AccountManaging.addNewGymGoer("0202020202", "Vilma", "Kingsepp", "vilma@gmail.com", "yes");
		AccountManaging.addNewGymGoer("0303030303", "Wilhelm", "Häggström", "weilhelm@gmail.com", "no");
		AccountManaging.addNewGymGoer("0404040404", "Måntii", "Idontremember", "måntii@gmail.com", "no");
		
		Activity.addNewActivity("Spinning", "Spinning like a beyblade");
		Activity.addNewActivity("Aerobics", "Move like a hivemind");
		Activity.addNewActivity("Yoga", "Stretch those muscles");
		Activity.addNewActivity("Lifting", "Build those muscles");
		Activity.addNewActivity("Crossfit", "Break your back and possibly your neck");
	}
	
	
}
