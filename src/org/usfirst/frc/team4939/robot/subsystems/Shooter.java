package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;
import org.usfirst.frc.team4939.robot.commands.ReverseBatterShot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	public CANTalon shootRight = new CANTalon(RobotMap.shootRight);
	public CANTalon shootLeft = new CANTalon(RobotMap.shootleft);
	
	public DoubleSolenoid piston = new DoubleSolenoid(RobotMap.shoot, RobotMap.reverseshoot);
	
	
	public double targetspeed = 3000;
	
	public Shooter()
	{
		this.shootLeft.changeControlMode(TalonControlMode.Speed);
		this.shootLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		this.shootLeft.reverseSensor(true);
		this.shootLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		this.shootLeft.configPeakOutputVoltage(+12.0f, -12.0f);
		this.shootLeft.setP(0.11);
		this.shootLeft.setI(0);
		this.shootLeft.setD(0);
		this.shootLeft.setF(0.025);
		
		this.shootRight.changeControlMode(TalonControlMode.Speed);
		this.shootRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		this.shootRight.reverseSensor(false);
		this.shootRight.configNominalOutputVoltage(+0.0f, -0.0f);
		this.shootRight.configPeakOutputVoltage(+12.0f, -12.0f);
		this.shootRight.setP(0.11);
		this.shootRight.setI(0);
		this.shootRight.setD(0);
		this.shootRight.setF(0.025);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ReverseBatterShot());
	}
	
	public void RetractPistonIn ()
	{
		this.piston.set(DoubleSolenoid.Value.kForward);
	}
	
	public void setSpeed(double power) {
		// TODO Auto-generated method stub
		this.shootLeft.set(power);
		this.shootRight.set(-power);
	}
	public void FireOut() {
		// TODO Auto-generated method stub
		this.piston.set(Value.kReverse);
	}

}
