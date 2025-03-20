package org.firstinspires.ftc.teamcode.Components;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class Lifts implements Component {


    private LinearOpMode myOpMode = null;
    private final int LIFT_LOW = 0;
    private final int LIFT_HIGH = 4100;
    private DcMotorEx lLift;
    private DcMotorEx rLift;

    public void init(RobotHardware robotHardware) {
        // Initialize lift motors from RobotHardware
        myOpMode = robotHardware.myOpMode;
        lLift = robotHardware.lLift;
        rLift = robotHardware.rLift;

        lLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        lLift.setDirection(DcMotorSimple.Direction.FORWARD);
        rLift.setDirection(DcMotorSimple.Direction.FORWARD);






}
    public void raiseLift() {
        if (lLift.getCurrentPosition() < LIFT_HIGH && rLift.getCurrentPosition() < LIFT_HIGH) {
            rLift.setTargetPosition(LIFT_HIGH);
            lLift.setTargetPosition(LIFT_HIGH);
            rLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rLift.setPower(1);
            lLift.setPower(1);
        }
    }

    public void lowerLift() {
        if (true) {
            rLift.setTargetPosition(LIFT_LOW);
            lLift.setTargetPosition(LIFT_LOW);
            rLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rLift.setPower(1);
            lLift.setPower(1);
        }
    }



}

