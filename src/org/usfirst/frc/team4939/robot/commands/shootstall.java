package org.usfirst.frc.team4939.robot.commands;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class shootstall extends Command {
	
	public shootstall()
	{
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.shooter.setSpeed(0);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
