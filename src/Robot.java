
public class Robot implements RoboConstants{
	float robo_battery_percent;
	boolean red_light;
	float robo_weight_carried;
	
	
	static class Builder{
		float robo_battery_percent;
		boolean red_light;
		float robo_weight_carried;
		
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
		public float getRobo_weight_carried() {
			return robo_weight_carried;
		}
		public Builder setRobo_weight_carried(float robo_weight_carried) {
			this.robo_weight_carried = robo_weight_carried;
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
			if(robo_weight_carried<0)
				return false;
			return true;
        }
	}
	Robot(Builder bp){
		//Do some basic validations to check
        //if user object does not break any assumption of system
		this.red_light=bp.red_light;
		this.robo_battery_percent=bp.robo_battery_percent;
		this.robo_weight_carried=bp.robo_weight_carried;
	}
	private Robot(){
		
	}
	public void addWeight(float weight) {
		robo_weight_carried+=weight;
		checkHealth();
	}
	public void reduceWeight(int weight) {
		robo_weight_carried-=weight;
	}
	public void makeRoboWalk(float distanceinKms) {
		float batteryReducedDueToWalk = batteryReducedPerKm*distanceinKms;
		float batteryReducedDueToWeight = batteryReducedDueToWalk*batteryReducedPerKg*robo_weight_carried;
		robo_battery_percent = robo_battery_percent - batteryReducedDueToWalk - batteryReducedDueToWeight;
		if(robo_battery_percent<0)
			robo_battery_percent=0;
		checkHealth();
	}
	public void charge() {
		robo_battery_percent=full;
		red_light=false;
	}
	public void checkHealth() {
		if(robo_battery_percent<red_light_threshold) {
			red_light=true;
			display(low_battery);	
		}
		else
			display(batteryRemaining+robo_battery_percent);
		if(robo_weight_carried>robo_overweight_threshold) {
			display(Overweight);	
		}		
		System.out.println();
	}
	public void scanItems(Item item){
		//Call API's to scan items.
		if(item.scanItem())
			display("Price of item scanned: "+item.getPrice());
		else
			display(scanFailure);
	}
	public String display(String message) {
		System.out.println(message);
		return message;
	}
	
	public static void main(String args[]) {
		Robot robo101 =  Robot.Builder.getInstance().setRobo_battery_percent(100).setRobo_weight_carried(2).build();
		
	}
}

class Item{
	String name;
	float price;
	boolean scan;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean scanItem() {
		//scan can be either success or failure.
		return false;
	}
}
