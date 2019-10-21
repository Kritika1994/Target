//Driver class for creating objects of Robot.
public class RoboDriver {
	public static void main(String args[]) {
		Robot robo101 =  Robot.Builder.getInstance().setRobo_battery_percent(100).setRoboWeightCarrier(2).build();
	}

}
