package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Mecnum implements Component{

    public LinearOpMode myOpMode = null;

    public DcMotor fLeft;
    public DcMotor fRight;
    public DcMotor bLeft;
    public DcMotor bRight;

    @Override
    public void init(RobotHardware robotHardware) {
        myOpMode = robotHardware.myOpMode;

        fLeft = myOpMode.hardwareMap.get(DcMotor.class, "fLeft");
        fRight = myOpMode.hardwareMap.get(DcMotor.class, "fRight");
        bLeft = myOpMode.hardwareMap.get(DcMotor.class, "bLeft");
        bRight = myOpMode.hardwareMap.get(DcMotor.class, "bRight");

        fLeft.setDirection(DcMotor.Direction.FORWARD);
        fRight.setDirection(DcMotor.Direction.REVERSE);
        bLeft.setDirection(DcMotor.Direction.FORWARD);
        bRight.setDirection(DcMotor.Direction.REVERSE);




        //Set ZeroPowerBehavior to BRAKE
        setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);




        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void driveRobot(Gamepad gamepad1){
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;
        double slow = (gamepad1.right_trigger*2) +1;

        double frLeft = y + x + rx;
        double frRight = y - x - rx  ;
        double baLeft = y - x + rx;
        double baRight = y + x - rx;

        setDrivePower(frLeft, frRight, baLeft, baRight, slow);





        //Cause Force Instant STOP
             if (Math.abs(y) < 0.05 && Math.abs(x) < 0.05 && Math.abs(rx) < 0.05){
            stopMotors();
             }
            else{

                setDrivePower(frLeft, frRight, baLeft, baRight, slow);
            }
    }


        //Stops all motors instantly and ensures zero coasting

    public void stopMotors() {
      setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fLeft.setPower(0);
        fRight.setPower(0);
        bLeft.setPower(0);
        bRight.setPower(0);




    }





    //Sets driving speed
    public void setDrivePower(double v1, double v2, double v3, double v4, double s) {
        double n = 2 * s;
        fLeft.setPower(v1/n);
        fRight.setPower(v2/n);

        bLeft.setPower(v3/n);
        bRight.setPower(v4/n);

    }

    //Code to prevent coasting
    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroPowerBehavior) {

        fLeft.setZeroPowerBehavior(zeroPowerBehavior);
        fRight.setZeroPowerBehavior(zeroPowerBehavior);

        bLeft.setZeroPowerBehavior(zeroPowerBehavior);
        bRight.setZeroPowerBehavior(zeroPowerBehavior);

    }


}
