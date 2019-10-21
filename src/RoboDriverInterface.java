
public interface RoboDriverInterface {
	//Adds weight to robot in Kgs
	public void addWeight(float weightInKgs);
	//Reduces weight to robot in Kgs
	public void reduceWeight(int weight);
	//To make a robot walk x distance in Kms. Also Displays battery after robot has walked. 
	public void makeRoboWalk(float distanceinKms);
	//Charge a robot. Optional param could be battery percent.
	public void charge();
	//Checks battery of a robo. 
	public boolean checkBattery() ;
	//Scans a particular item and gets it's price. 
	public void scanItems(Item item);
	//Checks general health of robo and alerts if required
	public void checkHealth();
}
