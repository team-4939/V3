package org.usfirst.frc.team4939.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4939.robot.commands.Fire;
import org.usfirst.frc.team4939.robot.commands.RetractPiston;
import org.usfirst.frc.team4939.robot.commands.ReverseBatterShot;
import org.usfirst.frc.team4939.robot.commands.intake;
import org.usfirst.frc.team4939.robot.commands.rotatedown;
import org.usfirst.frc.team4939.robot.commands.rotatestall;
import org.usfirst.frc.team4939.robot.commands.rotateup;
import org.usfirst.frc.team4939.robot.commands.shootnormal;
import org.usfirst.frc.team4939.robot.commands.shootstall;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	//initialize joysticks
	public Joystick movementStick = new Joystick(1);
	public Joystick shootStick = new Joystick (2);
	// buttons 
	private Button rotatedown = new JoystickButton(this.shootStick, 5);
	private Button rotateup = new JoystickButton(this.shootStick, 6);
	private Button intake = new JoystickButton(this.shootStick, 4);
	private Button shootnormal = new JoystickButton(this.shootStick, 2);
	private Button ReverseBatterShot = new JoystickButton(this.shootStick, 3);
	private Button Fire = new JoystickButton(this.shootStick,1);

	public OI()
	{
		this.rotatedown.whenPressed(new rotatedown());
		this.rotatedown.whenReleased(new rotatestall());
		this.rotateup.whenPressed(new rotateup());
		this.rotateup.whenReleased(new rotatestall());
		
		this.intake.whenPressed(new intake());
		this.intake.whenReleased(new shootstall());
		this.shootnormal.whenPressed(new shootnormal());
		this.shootnormal.whenReleased(new shootstall());
		this.ReverseBatterShot.whenPressed(new ReverseBatterShot());
		this.ReverseBatterShot.whenReleased(new shootstall());
		
		this.Fire.whenPressed(new Fire());
		this.Fire.whenReleased(new RetractPiston());
	}
	
	public double left()
	{
		return this.movementStick.getRawAxis(1);
	}
	
	public double right()
	{
		return this.movementStick.getRawAxis(5);
	}
}

