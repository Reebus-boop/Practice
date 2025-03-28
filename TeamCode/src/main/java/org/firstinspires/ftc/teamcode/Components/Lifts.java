package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Lifts implements Component {

    private LinearOpMode myOpMode = null;
    private final int LIFT_LOW = 0;
    private final int LIFT_HIGH = 2000;
    private DcMotorEx lLift;
    private DcMotorEx rLift;
    private int holdPosition = 0; // Stores last held position

    public void init(RobotHardware robotHardware) {
        myOpMode = robotHardware.myOpMode;
        lLift = robotHardware.lLift;
        rLift = robotHardware.rLift;

        lLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        lLift.setDirection(DcMotorSimple.Direction.REVERSE);
        rLift.setDirection(DcMotorSimple.Direction.FORWARD);

        lLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void raiseLift() {
        if (lLift.getCurrentPosition() < LIFT_HIGH && rLift.getCurrentPosition() < LIFT_HIGH) {
            holdPosition = lLift.getCurrentPosition(); // Store last known position
            moveToPosition(LIFT_HIGH);
        }
    }

    public void lowerLift() {
        if (lLift.getCurrentPosition() > LIFT_LOW && rLift.getCurrentPosition() > LIFT_LOW) {
            holdPosition = lLift.getCurrentPosition(); // Store last known position
            moveToPosition(LIFT_LOW);
        }
    }

    public void sLifts() {
        holdPosition = lLift.getCurrentPosition(); // Save last position before stopping
        holdLiftPosition();
    }

    private void moveToPosition(int target) {
        holdPosition = target; // Update hold position
        lLift.setTargetPosition(target);
        rLift.setTargetPosition(target);
        lLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lLift.setPower(1);
        rLift.setPower(1);
    }

    public void holdLiftPosition() {
        // Lock the motors at the last position
        lLift.setTargetPosition(holdPosition);
        rLift.setTargetPosition(holdPosition);
        lLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lLift.setPower(0.75); // Small power to hold position
        rLift.setPower(0.75);
    }
    public int getlLifts(){
        return lLift.getCurrentPosition();
    }
    public int getrLifts(){
        return rLift.getCurrentPosition();
    }
}
