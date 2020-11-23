package org.firstinspires.ftc.teamcode.Qualifier_1.Autonomous;

        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

        import org.firstinspires.ftc.teamcode.Qualifier_1.Components.BasicChassis;
        import org.firstinspires.ftc.teamcode.Qualifier_1.Components.Navigations.Odometry;
        import org.firstinspires.ftc.teamcode.Qualifier_1.Robot;

@Autonomous(name= "WobbleShooter_autonomous")
public class R_mid3_P1w_park extends LinearOpMode {
    final boolean debug = true;

    @Override
    public void runOpMode(){

        Robot robot=new Robot(this, BasicChassis.ChassisType.ENCODER);
        Odometry odom = new Odometry();

        telemetry.addData("Status", "Ready to go");
        telemetry.update();

        odom.init(this);
        telemetry.addData("Status", "InitComplete, Ready to Start");
        telemetry.update();
        waitForStart();
        robot.moveBackward(63,0.5);
        robot.moveRight(20,0.5);
        robot.moveForward(7,0.5);
        sleep(2000);
        //robot.shootHighGoal(3);
        robot.moveBackward(10,0.5);
        sleep(500);
        stop();
    }



}
