import lejos.nxt.Button;
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
		
		Button.waitForAnyPress();
		
		int base = lightsensor.getLightValue();
		int base2 = lightsensor2.getLightValue();
		
		while (true) {
			
			System.out.println("1 is " + lightsensor.getLightValue());
			System.out.println("2 is " + lightsensor2.getLightValue());
			
			pilot.setTravelSpeed(7);
			pilot.forward();
			
			if (lightsensor.getLightValue() < 35) {
				pilot.rotate(10);			
			} 
			else if (lightsensor2.getLightValue() < 41) {
				pilot.rotate(-10);
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
