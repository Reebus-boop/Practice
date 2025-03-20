package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Claw implements Component {

    private LinearOpMode myOpMode;
    private Servo clawServo;
    private Servo wristServo;
  //  private DcMotor Wrist; (Motor Wrists)

    private final double CLAW_OPEN_POSITION = 0.98;
    private final double CLAW_CLOSE_POSITION = 1.0;

    private final int WRIST_UP_POSITION = 0;   // Adjustable target position
    private final int WRIST_DOWN_POSITION = 1;

    private boolean isWristUp = false;  // Toggle state

    @Override
    public void init(RobotHardware robotHardware) {
        myOpMode = robotHardware.myOpMode;
        wristServo = robotHardware.wristServo;
        clawServo = robotHardware.clawServo;
        //  Wrist = myOpMode.hardwareMap.get(DcMotor.class, "Wrist");

        clawServo.setPosition(CLAW_CLOSE_POSITION);
        wristServo.setPosition(WRIST_UP_POSITION);

        // Reset and set up the wrist motor
       // Wrist.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //Wrist.setTargetPosition(WRIST_DOWN_POSITION);
        //Wrist.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //Wrist.setPower(0.5);
    }

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

    //public DcMotor getWrist() {
       // return Wrist;
    //}

    // Toggle wrist movement when 'Y' is pressed
    //public void toggleWrist() {
      //  if (isWristUp) {
        //    Wrist.setTargetPosition(WRIST_DOWN_POSITION);
        //} else {
          //  Wrist.setTargetPosition(WRIST_UP_POSITION);
        //}
        //Wrist.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //Wrist.setPower(0.5);

        //myOpMode.sleep(300);  // Added sleep here to prevent multiple rapid toggles

        //isWristUp = !isWristUp;  // Toggle state
   // }

    public void toggleWrist() {
        if (isWristUp) {
            wristServo.setPosition(WRIST_UP_POSITION);
        } else {
            wristServo.setPosition(WRIST_DOWN_POSITION);
            isWristUp = !isWristUp;
        }
    }
}