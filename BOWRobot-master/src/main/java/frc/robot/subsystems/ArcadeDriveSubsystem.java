package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.RobotContainer;
import frc.robot.commands.VictorSPDriveCommand;

import java.util.logging.Logger;

public class ArcadeDriveSubsystem extends SubsystemBase{


    Compressor c;
    private final VictorSP leftVictorSP1;
    private final VictorSP leftVictorSP2;
    private final VictorSP leftVictorSP3;
    private final VictorSP rightVictorSP1;
    private final VictorSP rightVictorSP2;
    private final VictorSP rightVictorSP3;
    private Joystick m_joystick = new Joystick(0);

    public ArcadeDriveSubsystem(int leftVictorSP1Channel, int leftVictorSP2Channel, int leftVictorSP3Channel,
                               int rightVictorSP1Channel, int rightVictorSP2Channel, int rightVictorSP3Channel) {
        leftVictorSP1 = new VictorSP(leftVictorSP1Channel);
        leftVictorSP2 = new VictorSP(leftVictorSP2Channel);
        leftVictorSP3 = new VictorSP(leftVictorSP3Channel);
        rightVictorSP1 = new VictorSP(rightVictorSP1Channel);
        rightVictorSP2 = new VictorSP(rightVictorSP2Channel);
        rightVictorSP3 = new VictorSP(rightVictorSP3Channel);
    }

    public void drive(double leftspeed, double rightspeed) {
        leftVictorSP1.setSpeed(leftspeed);
        leftVictorSP2.setSpeed(leftspeed);
        leftVictorSP3.setSpeed(leftspeed);
        rightVictorSP1.setSpeed(rightspeed);
        rightVictorSP2.setSpeed(rightspeed);
        rightVictorSP3.setSpeed(rightspeed);
    }

    public void execute(){
        double    x    = m_joystick.getX();
        double    y    = m_joystick.getY();
        System.out.println(x);
        System.out.println(y);

        x = x*x*x;
        y = y*y*y;

        // used http://programming.sdarobotics.org/robot-java/arcade-drive/ as reference

        drive(y+x, y-x);
    }
}
