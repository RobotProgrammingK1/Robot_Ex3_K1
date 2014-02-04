import lejos.nxt.Button;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;


public class DistaneControl {

	/**
	 * @param args
	 */
	static OpticalDistanceSensor sensor;
	static DifferentialPilot pilot;
	
	public static void main(String[] args) {

		
		// TODO Auto-generated method stub
		Button.waitForAnyPress();
		
		int initialdistance = sensor.getDistance();
		
		while(pilot.isMoving()) {
			Delay.msDelay(1000);
			
			if (sensor.getDistance() < initialdistance) { 
				pilot.setTravelSpeed((initialdistance-sensor.getDistance())/100);
			
			}
		}
		
	}
}
