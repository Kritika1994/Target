import static org.junit.Assert.*;

import org.junit.Test;

public class RoboTest {

		String message = "Hello World";	
	   Robot roboWar = Robot.Builder.getInstance().build();
	   Robot roboWar2 = Robot.Builder.getInstance().setRobo_weight_carried(3).build();
	   Robot roboWar3 = Robot.Builder.getInstance().setRobo_weight_carried(12).build();
	   
	   @Test
	   public void testScanItem() {
		   
	      roboWar.makeRoboWalk(3.5f);
	      roboWar2.makeRoboWalk(2);
	      roboWar3.checkHealth();
	   }
}
