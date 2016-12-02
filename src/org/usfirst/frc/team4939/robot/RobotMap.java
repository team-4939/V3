package org.usfirst.frc.team4939.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//CAN 
	public static final int leftDriveFront = 3;
	public static final int leftDriveBack = 4;
	public static final int rightDriveBack = 1;
	public static final int rightDriveFront = 2;
	public static final int shootRight = 5;
	public static final int shootleft = 6;
	
	// PWM
	public static final int rotateLeft = 0;
	public static final int rotateRight = 1;
	
	// Solenoids 
	public static final int shoot = 0;
	public static final int reverseshoot = 1;
	
	// analog 
	public static final int ArmInclinationSense = 0;
}
