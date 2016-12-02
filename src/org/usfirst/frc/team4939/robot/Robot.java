
package org.usfirst.frc.team4939.robot;

import org.usfirst.frc.team4939.robot.commands.CrossRoughTerrain;
import org.usfirst.frc.team4939.robot.commands.DoNothing;
import org.usfirst.frc.team4939.robot.commands.Reach;
import org.usfirst.frc.team4939.robot.subsystems.Arm;
import org.usfirst.frc.team4939.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4939.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static Compressor compressor; 
	public static Drivetrain dt = new Drivetrain();
	public static Shooter shooter = new Shooter();
	public static Arm arm = new Arm();
	
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;
    public static int autonumber;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
		oi = new OI();
		compressor = new Compressor (0);
		compressor.start();
		
        chooser = new SendableChooser();
        chooser.addDefault("Do Nothing", 0);
        chooser.addObject("Reach", 1);
        chooser.addObject("Cross Rough Terrain", 2);
        SmartDashboard.putData("Auto mode: ", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		autonumber = (int)chooser.getSelected();
		switch(autonumber)
		{
		case 0:
			autonomousCommand = (Command) new DoNothing();
			break;
		case 1:
			autonomousCommand = (Command) new Reach();
			break;
		case 2:
			autonomousCommand = (Command) new CrossRoughTerrain();
		}
	}

    public void autonomousInit() {
  
    	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void updateSmartDashboard()
    {
    	SmartDashboard.putNumber("Inclometer Average Value: ", Robot.arm.ArmAngle());
    }
}
