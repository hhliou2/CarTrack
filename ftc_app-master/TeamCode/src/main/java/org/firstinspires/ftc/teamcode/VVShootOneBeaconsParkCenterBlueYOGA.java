package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static org.firstinspires.ftc.teamcode.MethodSlave.beaconCheckIn;
import static org.firstinspires.ftc.teamcode.MethodSlave.beaconCheckOut;
import static org.firstinspires.ftc.teamcode.MethodSlave.encoderForward;
import static org.firstinspires.ftc.teamcode.MethodSlave.lineApproach;
import static org.firstinspires.ftc.teamcode.MethodSlave.realEncoderForwardLeft;
import static org.firstinspires.ftc.teamcode.MethodSlave.realEncoderForwardRight;
import static org.firstinspires.ftc.teamcode.MethodSlave.shootOne;

/**
 * Created by Fluff on 2/26/2017.
 */

//sets program name and group on phone, and groups are in alphabetic order
@Autonomous(name="Center Shoot One Blue YOGA", group="Beacon")
public class VVShootOneBeaconsParkCenterBlueYOGA extends LinearOpMode {

    //initialize motors, servos, booleans, and sensors
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor loader;
    DcMotor launcher;

    Servo rightPresser;
    Servo leftPresser;
    Servo floodgate;

    ColorSensor color;

    OpticalDistanceSensor eopd;

    TouchSensor touch;

    GyroSensor gyro;

    ModernRoboticsI2cRangeSensor rangeFront;

    @Override
    public void runOpMode() throws InterruptedException {
        //initializes components to names on phone
        backLeftMotor = hardwareMap.dcMotor.get("backleft");
        backRightMotor = hardwareMap.dcMotor.get("backright");
        frontLeftMotor = hardwareMap.dcMotor.get("frontleft");
        frontRightMotor = hardwareMap.dcMotor.get("frontright");
        loader = hardwareMap.dcMotor.get("loader");
        launcher = hardwareMap.dcMotor.get("launcher");

        rightPresser = hardwareMap.servo.get("rightpresser");
        leftPresser = hardwareMap.servo.get("leftpresser");
        floodgate = hardwareMap.servo.get("floodGate");

        color = hardwareMap.colorSensor.get("color");

        eopd = hardwareMap.opticalDistanceSensor.get("eopd");

        touch = hardwareMap.touchSensor.get("touch");

        gyro = hardwareMap.gyroSensor.get("gyro");

        rangeFront = hardwareMap.get(ModernRoboticsI2cRangeSensor.class,"frange");

        //close the floodgate
        floodgate.setPosition(0.8);
        rightPresser.setPosition(1);
        //waits for user to press start
        waitForStart();

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoderForward(3, 1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        shootOne(floodgate, launcher, opModeIsActive());
        encoderForward(15, 1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        realEncoderForwardRight(4.5, 0.6, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        encoderForward(72, 1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        realEncoderForwardRight(5.5, 0.6, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        encoderForward(26, 0.3, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        realEncoderForwardLeft(10, 1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        lineApproach(0.25, 0.2, 12, true, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, eopd, rangeFront, opModeIsActive());

        if (color.blue() > color.red()) {
            backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            encoderForward(-5, 0.5, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
            sleep(500);
            beaconCheckOut(rightPresser);
            sleep(700);
            beaconCheckIn(rightPresser);
            sleep(700);
            encoderForward(-55, -1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        }else if(color.blue() < color.red()){
            beaconCheckOut(rightPresser);
            sleep(700);
            beaconCheckIn(rightPresser);
            sleep(700);
            backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            encoderForward(-55, -1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        }

        lineApproach(0.25, -0.2, 12, true, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, eopd, rangeFront, opModeIsActive());

        if (color.blue() > color.red()) {
            backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            encoderForward(-5, 0.5, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
            sleep(500);
            beaconCheckOut(rightPresser);
            sleep(700);
            beaconCheckIn(rightPresser);
            sleep(700);
            encoderForward(5, 1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        }else if(color.blue() < color.red()){
            beaconCheckOut(rightPresser);
            sleep(700);
            beaconCheckIn(rightPresser);
            sleep(700);
            backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        realEncoderForwardLeft(19, 1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        encoderForward(17, 1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
    }
}

