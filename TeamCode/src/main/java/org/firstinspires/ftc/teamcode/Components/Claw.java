package org.firstinspires.ftc.teamcode.Components;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
public class Claw implements Component{

    private LinearOpMode myOpMode;
    private Servo clawServo;     // Servo to open/close the claw

    private final double CLAW_OPEN_POSITION = 1.0;   // Adjust as needed for your claw design
    private final double CLAW_CLOSE_POSITION = 0.0;  // Adjust as needed for your claw design

    @Override
    public void init(RobotHardware robotHardware) {
        myOpMode = robotHardware.myOpMode;
        clawServo = myOpMode.hardwareMap.get(Servo.class, "clawServo");
        clawServo.setPosition(CLAW_CLOSE_POSITION);
    }

    public void clawOpen() {
        clawServo.setPosition(CLAW_OPEN_POSITION);
    }

    // Method to close the claw
    public void clawClose() {d
        clawServo.setPosition(CLAW_CLOSE_POSITION);
    }

    public double getClawPos()
    {
        return clawServo.getPosition();
    }

}