package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Hasan on 12/1/2016.
 */

@Autonomous(name="ZeroMiddleRed", group="A")
public class ZeroMiddleRed extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;

    final static int ENCODER_CPR = 1440;
    final static double GEAR_RATIO = 0.5;
    final static int WHEEL_DIAMETER = 4;

    final static int DISTANCE = 72;
    final static double SPIN_DISTANCE = 53.4;
    final static double FINAL_SPIN = 13.35;
    final static double FORWARD_DISTANCE = 8.49;

    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;

    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    final static double SPIN_ROTATIONS = SPIN_DISTANCE / CIRCUMFERENCE;
    final static double FINAL_ROTATIONS = FINAL_SPIN / CIRCUMFERENCE;
    final static double FORWARD_ROTATIONS = FORWARD_DISTANCE / CIRCUMFERENCE;

    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
    final static double SPIN_COUNTS = ENCODER_CPR * SPIN_ROTATIONS * GEAR_RATIO;
    final static double FINAL_COUNTS = ENCODER_CPR * FINAL_ROTATIONS * GEAR_RATIO;
    final static double FORWARD = ENCODER_CPR * FORWARD_ROTATIONS * GEAR_RATIO;

    @Override
    public void runOpMode() throws InterruptedException {

        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");

        waitForStart();

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

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftMotor.setTargetPosition((int) -SPIN_COUNTS);
        rightMotor.setTargetPosition((int) -SPIN_COUNTS);

        leftMotor.setPower(-1.0);
        rightMotor.setPower(-1.0);

        while (leftMotor.isBusy()) {
            leftMotor.setPower(-1.0);
            rightMotor.setPower(-1.0);
        }

        leftMotor.setPower(0);
        rightMotor.setPower(0);

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftMotor.setTargetPosition((int) -FINAL_COUNTS);
        rightMotor.setTargetPosition((int) -FINAL_COUNTS);

        leftMotor.setPower(-1.0);
        rightMotor.setPower(-1.0);

        while (leftMotor.isBusy()) {
            leftMotor.setPower(-1.0);
            rightMotor.setPower(-1.0);
        }

        leftMotor.setPower(0);
        rightMotor.setPower(0);

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftMotor.setTargetPosition((int) FORWARD);
        rightMotor.setTargetPosition((int) -FORWARD);

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
