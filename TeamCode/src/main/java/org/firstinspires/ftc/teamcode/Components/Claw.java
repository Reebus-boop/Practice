package org.firstinspires.ftc.teamcode.Components;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
public class Claw implements Component{

    private LinearOpMode myOpMode;
    private Servo clawServo;     // Servo to open/close the claw
    private DcMotor Wrist;
    private final double CLAW_OPEN_POSITION = 0.98;   // Adjust as needed for your claw design
    private final double CLAW_CLOSE_POSITION = 1;  // Adjust as needed for your claw design

    @Override
    public void init(RobotHardware robotHardware) {
        myOpMode = robotHardware.myOpMode;
        clawServo = myOpMode.hardwareMap.get(Servo.class, "clawServo");
        Wrist = myOpMode.hardwareMap.get(DcMotor.class, "Wrist")
        clawServo.setPosition(CLAW_CLOSE_POSITION);
        Wrist.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void clawOpen() {
        clawServo.setPosition(CLAW_OPEN_POSITION);
    }

    // Method to close the claw
    public void clawClose() {
        clawServo.setPosition(CLAW_CLOSE_POSITION);
    }

    public double getClawPos()
    {
        return clawServo.getPosition();
    }

    public void DcMotor getWrist() {
        return Wrist;
    }
}