
public class Robot implements RoboUtilityInterface,RoboDriverInterface{
	float robo_battery_percent;
	boolean red_light;
	float roboWeightCarrier;
	
	
	static class Builder{
		float robo_battery_percent;
		boolean red_light;
		float roboWeightCarrier;
		
		public float getRobo_battery_percent() {
			return robo_battery_percent;
		}
		public Builder setRobo_battery_percent(float robo_battery_percent) {
			this.robo_battery_percent = robo_battery_percent;
			return this;
		}
		public boolean isRed_light() {
			return red_light;
		}
		public Builder setRed_light(boolean red_light) {
			this.red_light = red_light;
			return this;
		}
		public float getRoboWeightCarrier() {
			return roboWeightCarrier;
		}
		public Builder setRoboWeightCarrier(float robo_weight_carried) {
			this.roboWeightCarrier = robo_weight_carried;
			return this;
		}
		public static Builder getInstance() {
			return new Builder();
		}
		
		public Robot build() {
			//Should throw exceptions here
			if(!validateUserObject())
				return null;
	        return new Robot(this);
	    }
		private boolean validateUserObject() {
            //Do some basic validations to check
            //if user object does not break any assumption of system
			if(robo_battery_percent<=0) {
				robo_battery_percent=100;
			}	
			if(roboWeightCarrier<0)
				return false;
			return true;
        }
	}
	Robot(Builder bp){
		//Do some basic validations to check
        //if user object does not break any assumption of system
		this.red_light=bp.red_light;
		this.robo_battery_percent=bp.robo_battery_percent;
		this.roboWeightCarrier=bp.roboWeightCarrier;
	}
	private Robot(){
		alertBadHealth();
	}
	public void addWeight(float weight) {
		if(weight<=0)
			return;
		roboWeightCarrier+=weight;
		alertBadHealth();
	}
	public void reduceWeight(int weight) {
		if(weight<=0)
			return;
		roboWeightCarrier-=weight;
	}
	public void makeRoboWalk(float distanceinKms) {
		if(distanceinKms<=0)
			return;
		float batteryReducedDueToWalk = batteryReducedPerKm*distanceinKms;
		float batteryReducedDueToWeight = batteryReducedDueToWalk*batteryReducedPerKg*roboWeightCarrier;
		robo_battery_percent = robo_battery_percent - batteryReducedDueToWalk - batteryReducedDueToWeight;
		if(robo_battery_percent<0)
			robo_battery_percent=0;
		alertBadHealth();
		displayRemainingBattery();
	}
	public void charge() {
		robo_battery_percent=full;
		red_light=false;
	}
	public void checkHealth() {
		if(!alertBadHealth())
			display(goodHealthyRobot);
	}
	
	public boolean alertBadHealth() {
		if(checkBattery()) {
			return true;
		}
		if(checkWeight()) {
			 return true;
		}		
		return false;
	}
	public boolean checkWeight() {
		if(roboWeightCarrier>robo_overweight_threshold) {
			 display(Overweight);
			 return true;
		}
		return false;
	}
	
	public boolean checkBattery() {
		if(robo_battery_percent<red_light_threshold) {
			red_light=true;
			 display(low_battery);	
			return true;
		}
		return false;
	}
	public void displayRemainingBattery() {
		display(batteryRemaining+robo_battery_percent);
	}
	public void scanItems(Item item){
		//Call API's to scan items.
		if(item.scanItem())
			display("Price of item scanned: "+item.getPrice());
		else
			display(scanFailure);
	}
	private void display(String message) {
		
		System.out.println(message);
		System.out.println();
	}
}
