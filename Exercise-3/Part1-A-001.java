import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;


public class LightLoop {
	
	DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.C,
			Motor.B);
	LightSensor lightsensor = new LightSensor(SensorPort.S1);
	LightSensor lightsensor2 = new LightSensor(SensorPort.S2);
	

	public void go() {

		
		while (true) {
			
			System.out.println("1 is " + lightsensor.getLightValue());
			System.out.println("2 is " + lightsensor2.getLightValue());
			
			pilot.setTravelSpeed(10);
			pilot.forward();
			
			if (lightsensor.getLightValue() < 38) {
				pilot.rotate(5);			
			} 
			else if (lightsensor2.getLightValue() < 38) {
				pilot.rotate(-5);
				}
			else {
				
			}
		}
	}

	public static void main(String[] args) {
		LightLoop control = new LightLoop();
		control.go();
	}

}
