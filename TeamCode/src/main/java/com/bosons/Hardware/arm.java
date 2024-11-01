package com.bosons.Hardware;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class arm {
    public DcMotor LeftArmMotor = null;//rename this to sumn else because we will have the extendo/rotation motors both affecting the arm.
    public DcMotor RightArmMotor = null;
    public DcMotor Rotation = null;

    public int Pips;//pips are actually encoder "ticks" and should probably be renamed as such
    public int MinPip = 5;
    public int MaxPip = 2185;
    public double Power = 0.0;

    public arm(OpMode op,double power){
        Power = power;

        RightArmMotor = op.hardwareMap.get(DcMotor.class, "RightArm");
        RightArmMotor.setTargetPosition(0);
        RightArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RightArmMotor.setDirection(DcMotor.Direction.REVERSE);


        LeftArmMotor = op.hardwareMap.get(DcMotor.class, "LeftArm");
        LeftArmMotor.setTargetPosition(0);
        LeftArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LeftArmMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftArmMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LeftArmMotor.setDirection(DcMotor.Direction.REVERSE);



    }

    public void RunToTarget(int Counts){
        Pips = Counts;
        //Dynamic Safty range
        if ((Pips - 5) < 0) {MinPip = 5;}
        else {MinPip = Pips - 5;}
        if ((Pips+5) > 2190) {MaxPip = 2185;}
        else {MaxPip = Pips + 5;}
        //if pips is greater or smaller than the arms maximums then clamp to arm maximums and dont exceed them.
        if(Pips <= MinPip) {// when arm is set to close
            if (RightArmMotor.getCurrentPosition() <= MinPip) {RightArmMotor.setPower(0);}
            else {RightArmMotor.setPower(Power);} // check if RightArm is fully closed then turn off power
            if(LeftArmMotor.getCurrentPosition() <= MinPip){LeftArmMotor.setPower(0);}
            else{LeftArmMotor.setPower(Power);} // check if LeftArm is fully closed then turn off power
        }

        if(Pips >= MaxPip){
            if(RightArmMotor.getCurrentPosition() >= MaxPip){RightArmMotor.setPower(0);}
            else{RightArmMotor.setPower(Power);} // check if RightArm is fully extended then turn off power
            if(LeftArmMotor.getCurrentPosition() >= MaxPip-MinPip){LeftArmMotor.setPower(0);}
            else{LeftArmMotor.setPower(Power);} // check if LeftArm is fully extended then turn off power
        }

        RightArmMotor.setTargetPosition(Pips);
        //LeftArmMotor.setTargetPosition(Counts);
    }
    public void MotorCheck(){
        if(Pips <= MinPip) {// when arm is set to close
            if (RightArmMotor.getCurrentPosition() <= MinPip) {RightArmMotor.setPower(0);} // check if LeftArm is fully closed then turn off power
            else{RightArmMotor.setPower(Power);}
            if (LeftArmMotor.getCurrentPosition() <= MinPip) {LeftArmMotor.setPower(0);} // check if LeftArm is fully closed then turn off power
            else{LeftArmMotor.setPower(Power);}
        }
        if(Pips >= MaxPip){
            if(RightArmMotor.getCurrentPosition() >= MaxPip){RightArmMotor.setPower(0);}   // check if RightArm is fully extended then turn off power
            else{RightArmMotor.setPower(Power);}
            if(LeftArmMotor.getCurrentPosition() >= MaxPip){LeftArmMotor.setPower(0);}   // check if RightArm is fully extended then turn off power
            else{LeftArmMotor.setPower(Power);}
        }
    }
    public void Stop(){
        RightArmMotor.setPower(0);
        LeftArmMotor.setPower(0);
    }
}
