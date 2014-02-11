import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;


public class DistaneControl {

	/**
	 * @param args
	 */
	OpticalDistanceSensor sensor = new OpticalDistanceSensor(SensorPort.S3);
	DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.C, Motor.B);
	LightSensor lightsensor = new LightSensor(SensorPort.S1);
	LightSensor lightsensor2 = new LightSensor(SensorPort.S2);

	public static void main(String[] args) {
		Button.waitForAnyPress();
		
	
	}	
	
	public void go() {
			
		int initialdistance = sensor.getDistance();
			
			//Light Sensor
		while(pilot.isMoving()) {
			Delay.msDelay(1000);
			
			if (sensor.getDistance() < initialdistance) { 
				pilot.setTravelSpeed((initialdistance-sensor.getDistance())/100);
			}
			
			if(lightsensor.getLightValue() < 50 & lightsensor2.getLightValue() < 50) {
				pilot.rotate(10);
			}
			else if(lightsensor.getLightValue() < 50) {
				pilot.rotate(5);
			}	
			else if(lightsensor2.getLightValue() < 50) {
				pilot.rotate(-5);
			}
		}
	
	}
	
}
