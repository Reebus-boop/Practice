package org.firstinspires.ftc.teamcode.Components;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.TouchSensor;
public class RobotHardware {
    public LinearOpMode myOpMode = null;
    public RobotHardware(LinearOpMode opMode)
    {
        myOpMode = opMode;
    }

    //Subsystems
    public  MoveMotor movemotor = new MoveMotor();
    public  MoveServo moveservo = new MoveServo();
    Component[] components = {movemotor, moveservo};

    public void init()
    {
        //init motors

        //init servos


        //initialize subsystems
        for (int i = 0; i < components.length; i++)
        {
            components[i].init(this);
        }
        myOpMode.telemetry.addData("status", "initialized");
        myOpMode.telemetry.update();
        myOpMode.waitForStart();
    }

}
