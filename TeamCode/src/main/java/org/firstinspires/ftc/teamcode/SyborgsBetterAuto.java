package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IMUFactory;
import org.firstinspires.ftc.teamcode.subsystems.IntakeAndWristSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlideSubsystem;
@SuppressWarnings("unused")
@Autonomous(name="SyborgsBetterAuto")
public class SyborgsBetterAuto extends LinearOpMode {
    DriveSubsystem drive;
    IMU imu;
    ArmSubsystem arm;
    SlideSubsystem lift;
    IntakeAndWristSubsystem intakeAndWrist;
    @Override
    public void runOpMode() {
        waitForStart();
        initSubsystems();
        sleep(3000);
        arm.setPositionAuto(arm.ARM_SCORE_SAMPLE_IN_HIGH);

    }
    public void initSubsystems() {
        drive = new DriveSubsystem(hardwareMap, telemetry, imu);
        imu = IMUFactory.initIMU(hardwareMap);
        arm = new ArmSubsystem(hardwareMap, telemetry);
        lift = new SlideSubsystem(hardwareMap, telemetry);
        intakeAndWrist = new IntakeAndWristSubsystem(hardwareMap, telemetry);
    }
}