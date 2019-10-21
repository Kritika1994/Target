import static org.junit.Assert.*;

import org.junit.Test;

public class RoboTest {

	@Test
	   public void successCaseCreateRobo() {
		   Robot roboWar = Robot.Builder.getInstance().build();
		   assertNotNull(roboWar);
	   }
	   
	   @Test
	   public void failureCaseCreateRobo() {
		   Robot roboWar = Robot.Builder.getInstance().setRoboWeightCarrier(-13).build();
		   assertNull(roboWar);
	   }
	   
	   @Test
	   public void successCaseMakeRoboWalk() {
		   Robot roboWar = Robot.Builder.getInstance().setRoboWeightCarrier(3).build();
		   System.out.println("Robo walks 3.5kms with 3kg weight: ");
		   roboWar.makeRoboWalk(3.5f);
	   }
	   
	   @Test
	   public void successCaseMakeRoboWalkWithWeight() {
		   Robot roboWar2 = Robot.Builder.getInstance().setRoboWeightCarrier(3).build();
		   System.out.println("Robo walks 2kms with 3kg weight: ");
		   roboWar2.makeRoboWalk(2);
		   
//		   Robot roboWar = Robot.Builder.getInstance().build();
//		   roboWar.addWeight(3);
//		   roboWar.makeRoboWalk(2);
		   
	   }
	   
	   
	   @Test
	   public void makeRoboOverWeight() {
		  
		   Robot roboWar = Robot.Builder.getInstance().setRoboWeightCarrier(12).build();
		   System.out.println("Robot with 12kg weight: ");
		   roboWar.checkHealth();
	   }
}
