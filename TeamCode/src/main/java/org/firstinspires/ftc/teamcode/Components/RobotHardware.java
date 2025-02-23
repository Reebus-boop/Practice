package org.firstinspires.ftc.teamcode.Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;


public class RobotHardware {
    public LinearOpMode myOpMode = null;
    public RobotHardware(LinearOpMode opMode)
    {
        myOpMode = opMode;
    }

    //Subsystems
    public Mecnum mecnum = new Mecnum();
    public Claw claw = new Claw();

    Component[] components = {mecnum, claw};

    public void init()
    {

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
