package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;
import org.usfirst.frc.team4939.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	public CANTalon leftDriveFront = new CANTalon(RobotMap.leftDriveFront);
	public CANTalon leftDriveBack = new CANTalon(RobotMap.leftDriveBack);
	public CANTalon rightDriveFront = new CANTalon(RobotMap.rightDriveFront);
	public CANTalon rightDriveBack = new CANTalon(RobotMap.rightDriveBack);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new TankDrive());
		
	}
	public void runLeftDrive(double power)
	{
		this.leftDriveFront.set(power);
		this.leftDriveBack.set(power);
	}
	
	public void runRightDrive (double power)
	{
		this.rightDriveFront.set(power);
		this.rightDriveBack.set(power);
	}
	
}
