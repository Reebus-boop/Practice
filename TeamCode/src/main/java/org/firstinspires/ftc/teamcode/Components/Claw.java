package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Claw implements Component {

    private LinearOpMode myOpMode;
    private Servo clawServo;
    private Servo wristServo;

    private final double CLAW_OPEN_POSITION = 0.98;
    private final double CLAW_CLOSE_POSITION = 1.0;
    private final int WRIST_UP_POSITION = 0;
    private final int WRIST_DOWN_POSITION = 1;

    private boolean isWristUp = false;  // Toggle state for wrist
    private boolean isClawOpen = false; // Track claw open/close state

    @Override
    public void init(RobotHardware robotHardware) {
        myOpMode = robotHardware.myOpMode;
        wristServo = robotHardware.wristServo;
        clawServo = robotHardware.clawServo;

        clawServo.setPosition(CLAW_CLOSE_POSITION);
        wristServo.setPosition(WRIST_UP_POSITION);
    }

    // Toggle claw open/close state
    public void toggleClaw() {
        isClawOpen = !isClawOpen;  // Toggle claw state

        if (isClawOpen) {
            clawServo.setPosition(CLAW_OPEN_POSITION);
        } else {
            clawServo.setPosition(CLAW_CLOSE_POSITION);
        }
    }
//open w a and close w b code
    public void clawOpen() {
        clawServo.setPosition(CLAW_OPEN_POSITION);
    }

    public void clawClose() {
        clawServo.setPosition(CLAW_CLOSE_POSITION);
    }

    public double getClawPos() {
        return clawServo.getPosition();
    }

    public double getWristPos() {
        return wristServo.getPosition();
    }

    // Toggle wrist position when 'Y' is pressed
    public void toggleWrist() {
        if (isWristUp) {
            wristServo.setPosition(WRIST_UP_POSITION);
        } else {
            wristServo.setPosition(WRIST_DOWN_POSITION);
        }
        isWristUp = !isWristUp;  // Toggle wrist state
    }
}