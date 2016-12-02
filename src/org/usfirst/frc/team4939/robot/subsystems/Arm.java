package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
	// motors
	public Victor rotateRight = new Victor(RobotMap.rotateRight);
	public Victor rotateLeft = new Victor(RobotMap.rotateLeft);
	
	// sensors
	private AnalogInput ArmInclinationSense = new AnalogInput(RobotMap.ArmInclinationSense);
	
	public double ArmAngle()
	{
		return ArmInclinationSense.getAverageVoltage()*110.769-360;
	}
	
	public void ArmUpTrig(double power)
	{
		this.rotateLeft.set(power);
		this.rotateRight.set(power);
	}
	
	public void ArmDownTrig (double power)
	{
		this.rotateLeft.set(power);
		this.rotateRight.set(power);
	}
	public void ArmStop (double power)
	{
		this.rotateLeft.set(power);
		this.rotateRight.set(power);
	}
	
@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}