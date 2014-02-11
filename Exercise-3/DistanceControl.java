import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class DistanceControl {

	OpticalDistanceSensor sensor = new OpticalDistanceSensor(SensorPort.S1);
	DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.C, Motor.B);
	

	public void go() {

		 while (true) {
			
			
			if (sensor.getDistance() > 250) {
				
				pilot.setTravelSpeed(10);
				pilot.forward();
				
			}
			else if(sensor.getDistance() <= 150){
				pilot.setTravelSpeed(-10);
				pilot.backward();
				
			}
			else if(sensor.getDistance() < 250){
				pilot.setTravelSpeed((sensor.getDistance()/50));
				pilot.forward();
			}
			
			else {
				
			}

		}
		}

	public static void main(String[] args) {

		DistanceControl control = new DistanceControl();
		control.go();
	}
}
