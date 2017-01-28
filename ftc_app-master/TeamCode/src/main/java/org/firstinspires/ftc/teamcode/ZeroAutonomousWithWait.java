package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Hasan on 12/1/2016.
 */

@Autonomous(name="ZeroMiddleWithWait", group="A")
@Disabled
public class ZeroAutonomousWithWait extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;

    final static int ENCODER_CPR = 1440;
    final static double GEAR_RATIO = 2;
    final static int WHEEL_DIAMETER = 4;

    final static int DISTANCE = 72;

    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;

    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;

    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;

    @Override
    public void runOpMode() throws InterruptedException {

        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");

        waitForStart();

        leftMotor.setPower(0);
        rightMotor.setPower(0);

        sleep(10000);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftMotor.setTargetPosition((int) COUNTS);
        rightMotor.setTargetPosition((int) -COUNTS);

        leftMotor.setPower(1.0);
        rightMotor.setPower(-1.0);

        while (leftMotor.isBusy()) {
            leftMotor.setPower(1.0);
            rightMotor.setPower(-1.0);
        }

        leftMotor.setPower(0);
        rightMotor.setPower(0);

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

}
