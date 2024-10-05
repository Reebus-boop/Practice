package org.firstinspires.ftc.teamcode.Systems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Servos {

    private Servo lower = null;
    private Servo higher = null;

    public void InitializeServo()
    {
        lower = hardwareMap.get(Servo.class, "L");
        higher = hardwareMap.get(Servo.class, "H");
    }
    public void moveDatServo(double servoDistHigher, double servoDistLower)
    {
        higher.setPosition(servoDistHigher);
        lower.setPosition(servoDistLower);
    }
}
