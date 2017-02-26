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
import static org.firstinspires.ftc.teamcode.MethodSlave.gyroTurn;
import static org.firstinspires.ftc.teamcode.MethodSlave.lineApproach;
import static org.firstinspires.ftc.teamcode.MethodSlave.rangeRight;
import static org.firstinspires.ftc.teamcode.MethodSlave.realEncoderForwardLeft;
import static org.firstinspires.ftc.teamcode.MethodSlave.realEncoderForwardRight;
import static org.firstinspires.ftc.teamcode.MethodSlave.shootOne;
import static org.firstinspires.ftc.teamcode.MethodSlave.wallAlign;

/**
 * Created by Hasan on 12/1/2016.
 */

//sets program name and group on phone, and groups are in alphabetic order
@Autonomous(name="Center Shoot One Beacons Park Blue", group="Beacon")
public class VVShootOneBeaconsParkCenterBlue extends LinearOpMode {

    //initialize motors, servos, booleans, and sensors
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor loader;
    DcMotor launcher;

    Servo buttonPresser;
    Servo floodgate;

    ColorSensor color;

    OpticalDistanceSensor eopd;

    TouchSensor touch;

    GyroSensor gyro;

    ModernRoboticsI2cRangeSensor rangeFront;

    @Override
    public void runOpMode() throws InterruptedException {
        //initializes co    mponents to names on phone
        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        loader = hardwareMap.dcMotor.get("loader");
        launcher = hardwareMap.dcMotor.get("launcher");

        buttonPresser = hardwareMap.servo.get("button");
        floodgate = hardwareMap.servo.get("floodGate");

        color = hardwareMap.colorSensor.get("color");

        eopd = hardwareMap.opticalDistanceSensor.get("eopd");

        touch = hardwareMap.touchSensor.get("touch");

        gyro = hardwareMap.gyroSensor.get("gyro");

        rangeFront = hardwareMap.get(ModernRoboticsI2cRangeSensor.class,"frange");

        //close the floodgate
        floodgate.setPosition(0.8);
        buttonPresser.setPosition(1);
        //waits for user to press start
        waitForStart();

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoderForward(-2, -1.0, leftMotor, rightMotor,opModeIsActive());
        shootOne(floodgate, launcher, opModeIsActive());
        encoderForward(-30, -1.0, leftMotor, rightMotor, opModeIsActive());
        realEncoderForwardRight(10, 1.0, leftMotor, rightMotor, opModeIsActive());
        encoderForward(46.5, 1.0, leftMotor, rightMotor, opModeIsActive());
        realEncoderForwardLeft(9.7, 1.0, leftMotor, rightMotor, opModeIsActive());
        lineApproach(0.25, 0.2, true, leftMotor, rightMotor, eopd, rangeFront, opModeIsActive());

        beaconCheckOut(buttonPresser);
        sleep(700);
        beaconCheckIn(buttonPresser);
        sleep(500);

        if (color.blue() < color.red()) {
            sleep(4400);
        }

        while (color.blue() < color.red() && opModeIsActive()) {
            beaconCheckOut(buttonPresser);
            sleep(700);
            beaconCheckIn(buttonPresser);
            sleep(700);
            if(!opModeIsActive()){
                break;
            }
        }

        lineApproach(0.25, 0.25, true, leftMotor, rightMotor, eopd, rangeFront, opModeIsActive());

        beaconCheckOut(buttonPresser);
        sleep(700);
        beaconCheckIn(buttonPresser);
        sleep(1000);

        if (color.blue() < color.red()) {
            sleep(4100);
        }

        while (color.blue() < color.red() && opModeIsActive()) {
            beaconCheckOut(buttonPresser);
            sleep(700);
            beaconCheckIn(buttonPresser);
            sleep(700);
            if(!opModeIsActive()){
                break;
            }
        }
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        realEncoderForwardRight(15, 1.0, leftMotor, rightMotor, opModeIsActive());
        encoderForward(-47, -1.0, leftMotor, rightMotor, opModeIsActive());
    }
}

