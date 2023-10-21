package com.example.meepmeeptesting;


import static java.lang.Math.PI;
import static java.lang.Math.toRadians;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;


public class MeepMeepTesting {

    public static void main(String[] args) {

        MeepMeep meepMeep = new MeepMeep(600);


        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setDimensions(15.5,16.5)
                .setConstraints(50, 40, 4 * PI, 2 * PI, 11)
                .setConstraints(60, 60, toRadians(180), toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-38.5, -63.25, Math.toRadians(-90)))
                                .setReversed(true)
                                .lineToLinearHeading(new Pose2d(-38.5, -34, toRadians(-90)))
                                .setReversed(false)
                                .lineToLinearHeading(new Pose2d(-34.5,-34, toRadians(-180)))
                                .lineToLinearHeading(new Pose2d(-46, -58, toRadians(0)))
                                .splineTo(new Vector2d(10, -58), toRadians(0))
                                .splineTo(new Vector2d(51, -41.5), toRadians(0))
                                .lineToLinearHeading(new Pose2d(51, -12, toRadians(0)))
                                .lineToLinearHeading(new Pose2d(60, -12, toRadians(0)))
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}