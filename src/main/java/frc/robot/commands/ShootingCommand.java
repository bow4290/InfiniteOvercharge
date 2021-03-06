package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ShootingSubsystem;

import java.util.Set;

public class ShootingCommand extends CommandBase {

    private ShootingSubsystem shootingSubsystem;
    private final Set<Subsystem> subsystems;

    public ShootingCommand(ShootingSubsystem shootingSubsystem) {
        this.shootingSubsystem = shootingSubsystem;
        this.subsystems = Set.of(shootingSubsystem);
    }

    /**
     * this will display the y value of the left joystcik
     */
    public void execute() {
//        SmartDashboard.putBoolean("Left value", RobotContainer.xboxController.getBumper(GenericHID.Hand.kLeft));
        shootingSubsystem.dualShoot(
                RobotContainer.xboxController.getBumper(GenericHID.Hand.kLeft),
                RobotContainer.xboxController.getBumper(GenericHID.Hand.kRight)
        );
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return this.subsystems;
    }
}
