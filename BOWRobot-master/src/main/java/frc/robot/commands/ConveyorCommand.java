package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.ShootingSubsystem;

import java.util.Set;

public class ConveyorCommand extends CommandBase {
    private ConveyorSubsystem conveyorSubsystem;
    public final Set<Subsystem> subsystems;

    private ConveyorCommand(ConveyorSubsystem conveyorSubsystem, Set<Subsystem> subsystems) {

        this.subsystems = subsystems;
    }
    public ConveyorCommand(ConveyorSubsystem conveyorSubsystem) {
        this.conveyorSubsystem = conveyorSubsystem;
        this.subsystems = Set.of(conveyorSubsystem);
    }
    public void execute() {
        conveyorSubsystem.conveyBall(RobotContainer.joystickLeft.getY());
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