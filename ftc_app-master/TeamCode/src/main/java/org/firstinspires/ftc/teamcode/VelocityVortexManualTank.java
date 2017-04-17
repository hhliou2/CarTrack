package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Fluff on 2/10/2017.
 */


@TeleOp(name="Driver Controllur", group="TeleOp")
public class VelocityVortexManualTank extends OpMode {

    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor loader;
    DcMotor launcher;
    DcMotor liftOne;
    DcMotor liftTwo;

    Servo rightPresser;
    Servo leftPresser;
    Servo floodgate;
    Servo release;

    boolean isBackWheelDrive;

    //sets several constants
    final static int ENCODER_CPR = 1600;
    final static double GEAR_RATIO = 4;

    final static int ROTATIONS = 1;

    //sets value to be sent to encoder
    final static double COUNTS1 = ENCODER_CPR * ROTATIONS * GEAR_RATIO;

    @Override
    public void init() {

        backLeftMotor = hardwareMap.dcMotor.get("backleft");
        backRightMotor = hardwareMap.dcMotor.get("backright");
        frontLeftMotor = hardwareMap.dcMotor.get("frontleft");
        frontRightMotor = hardwareMap.dcMotor.get("frontright");
        loader = hardwareMap.dcMotor.get("loader");
        launcher = hardwareMap.dcMotor.get("launcher");
        liftOne = hardwareMap.dcMotor.get("liftOne");
        liftTwo = hardwareMap.dcMotor.get("liftTwo");


        rightPresser = hardwareMap.servo.get("rightpresser");
        leftPresser = hardwareMap.servo.get("leftpresser");
        floodgate = hardwareMap.servo.get("floodGate");
        release = hardwareMap.servo.get("release");

        isBackWheelDrive = false;
        floodgate.setPosition(0.9);
        rightPresser.setPosition(1.0);
        leftPresser.setPosition(0);
        release.setPosition(1.0);
    }

    @Override
    public void loop() {

        if (isBackWheelDrive) {
            float leftDrive = gamepad1.left_stick_y;
            float rightDrive = -gamepad1.right_stick_y;

            backRightMotor.setPower(leftDrive);
            backLeftMotor.setPower(rightDrive);
            frontRightMotor.setPower(leftDrive);
            frontLeftMotor.setPower(rightDrive);

            if(gamepad2.a) {
                loader.setPower(1.0);
            }

            else if(gamepad2.x) {
                loader.setPower(-1.0);
            } else {
                loader.setPower(0);
            }

            if(gamepad1.dpad_up) {
                launcher.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                launcher.setPower(-1.0);
            } else if(gamepad1.dpad_down) {
                launcher.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                launcher.setPower(0.5);
            } else {
                launcher.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                launcher.setPower(0);
            }

            if (gamepad2.right_bumper || gamepad1.right_bumper) {
                rightPresser.setPosition(0);
            } else {
                rightPresser.setPosition(1.0);
            }
            if (gamepad2.left_bumper || gamepad1.left_bumper) {
                leftPresser.setPosition(1.0);
            } else {
                leftPresser.setPosition(0);
            }
            if (gamepad2.dpad_up) {

                floodgate.setPosition(0);
            } else {
                floodgate.setPosition(1);
            }

            if (gamepad1.x) {
                isBackWheelDrive = false;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {

            float leftDrive = -gamepad1.left_stick_y;
            float rightDrive = gamepad1.right_stick_y;

            backRightMotor.setPower(rightDrive * 0.5);
            backLeftMotor.setPower(leftDrive * 0.5);
            frontRightMotor.setPower(rightDrive * 0.5);
            backLeftMotor.setPower(leftDrive * 0.5);

            if(gamepad2.dpad_down){
                release.setPosition(0);
            }

            if(gamepad2.y) {
                liftOne.setPower(-1.0);
                liftTwo.setPower(-1.0);
            } else if (gamepad2.b) {
                liftOne.setPower(1.0);
                liftTwo.setPower(1.0);
            } else {
                liftOne.setPower(0);
                liftTwo.setPower(0);
            }

            if(gamepad2.a) {
                loader.setPower(1.0);
            }

            else if(gamepad2.x) {
                loader.setPower(-1.0);
            } else {
                loader.setPower(0);
            }

            if(gamepad1.dpad_up) {
                launcher.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                launcher.setPower(-1.0);
            } else if(gamepad1.dpad_down) {
                launcher.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                launcher.setPower(0.5);
            } else {
                launcher.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                launcher.setPower(0);
            }

            if (gamepad2.right_bumper || gamepad1.right_bumper) {
                rightPresser.setPosition(0);
            } else {
                rightPresser.setPosition(1.0);
            }
            if (gamepad2.right_bumper || gamepad1.right_bumper) {
                rightPresser.setPosition(0);
            } else {
                rightPresser.setPosition(1.0);
            }

            if (gamepad2.dpad_up) {
                floodgate.setPosition(0);
            } else {
                floodgate.setPosition(0.9);
            }

            if (gamepad1.x) {
                isBackWheelDrive = true;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}