package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

//import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
/*
Add distance sensor
 */

//how to import these packages?

//import org.firstinspires.ftc.teamcode.util.MotionProfiler;

public class Slides {
    public final DcMotorEx slidesMotor_left;
    public final DcMotorEx slidesMotor_right;
    private final static double p = 0.015, i = 0 , d = 0, f = 0;
    private final PIDFCoefficients coeff = new PIDFCoefficients(p,i,d,f);
    //4410 code has staticF, not sure what that is. Look into it later
    //private PIDFController controller;

    //change values in slidesPosition based on the number of stages in the slides
    public enum slidesPosition{
        GROUND,
        LOW,
        MID,
        HIGH
    }

    // private PIDFController controller;

    private slidesPosition position = slidesPosition.GROUND;
    private final double tolerance = 20, powerUp = 0.1, powerDown = 0.05, manualDivide = 1, powerMin = 0.1;
    //change these values based on what they actually are
    private double manualPower = 0;

    public static int MAXHEIGHT = -2000, top = -1700, topTeleOp = -1750, mid = -980, low = -300, ground = 0, move_up_inc = 100, move_down_dec = 300;
    //change values based on what they actually are

    private final OpMode opMode;
    private double target = 0;
    private boolean goingDown = false;
    private double profile_init_time = 0;
    //private MotionProfiler profiler = new MotionProfiler(30000, 20000);
    public boolean movingDown = false;

    public Slides(OpMode opMode){
        this.opMode = opMode;
        slidesMotor_left = opMode.hardwareMap.get(DcMotorEx.class, "left slides motor");
        slidesMotor_right = opMode.hardwareMap.get(DcMotorEx.class, "right slides motor");
        slidesMotor_right.setDirection(DcMotorEx.Direction.REVERSE);
        slidesMotor_left.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, coeff);
        slidesMotor_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slidesMotor_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void runTo(int stage){
        slidesMotor_left.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        slidesMotor_right.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        /*
        things to code when I can import PIDFcontroller from arcrobotics library:
         */
     /*   controller = new PIDFController(PIDFCoefficients);
        controller.setTolerance(tolerance);
        controller.setSetPoint(0);

      */
        slidesMotor_left.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        slidesMotor_right.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

       /* slidesMotor_right.setRunMode(Motor.RunMode.RawPower);
          slidesMotor_left.setRunMode(Motor.RunMode.RawPower);
        */
    }

    public void runTo(double t) {
       // slidesMotor_left.setRunMode(Motor.RunMode.RawPower);
        slidesMotor_left.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
       // slidesMotor_right.setRunMode(Motor.RunMode.RawPower);
        slidesMotor_right.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

       /* controller = new PIDFController(p, i, d, f);
        controller.setTolerance(tolerance);
        resetProfiler();
        profiler.init_new_profile(motorLeft.getCurrentPosition(), t);
        profile_init_time = opMode.time;

        */
        if (t > target) {
            goingDown = true;
        } else {
            goingDown = false;
        }
        target = t;
    }

}
