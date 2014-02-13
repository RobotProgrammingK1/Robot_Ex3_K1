import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;


public class ArbyGriddy {
	
	
	
	DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.C,
			Motor.B);
	LightSensor lightsensor = new LightSensor(SensorPort.S1);
	LightSensor lightsensor2 = new LightSensor(SensorPort.S2);
	

	public void go() {
		
		Button.waitForAnyPress();
		
		
		
		while (true) {
			
		
			
			pilot.setTravelSpeed(3);
			pilot.forward();
			
			if (lightsensor.getLightValue() < 35 && lightsensor2.getLightValue() < 41) {
				pilot.travel(2.5);
				pilot.rotate(135);
			} 
			else if (lightsensor2.getLightValue() < 41 && lightsensor.getLightValue() > 35) {
				pilot.rotate(-10);
				
				}
			else if(lightsensor.getLightValue() < 35 && lightsensor2.getLightValue() > 41) 
				pilot.rotate(10);
			}
				
			}
	
	public static void main(String[] args) {
		ArbyGriddy control = new ArbyGriddy();
		control.go();
	}
		
	}
