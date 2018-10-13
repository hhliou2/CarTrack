package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static org.firstinspires.ftc.teamcode.MethodSlave.encoderForward;
import static org.firstinspires.ftc.teamcode.MethodSlave.gyroTurn;
import static org.firstinspires.ftc.teamcode.MethodSlave.lineApproach;
import static org.firstinspires.ftc.teamcode.MethodSlave.shootTwo;

/**
 * Created by Hasan on 12/1/2016.
 */

//sets program name and group on phone, and groups are in alphabetic order
@Autonomous(name="Corner Shoot Two Beacons Park Blue", group="Beacon")
@Disabled
public class VVShootTwoBeaconsParkCornerBlue extends LinearOpMode {

    //initialize motors, servos, booleans, and sensors
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor loader;
    DcMotor launcher;

    Servo buttonPresser;
    Servo floodgate;

    ColorSensor color;

    OpticalDistanceSensor eopd;

    TouchSensor touch;

    GyroSensor gyro;

    @Override
    public void runOpMode() throws InterruptedException {
        //initializes components to names on phone
        backLeftMotor = hardwareMap.dcMotor.get("backleft");
        backRightMotor = hardwareMap.dcMotor.get("backright");
        frontLeftMotor = hardwareMap.dcMotor.get("frontleft");
        frontRightMotor = hardwareMap.dcMotor.get("frontright");

        buttonPresser = hardwareMap.servo.get("button");
        floodgate = hardwareMap.servo.get("floodGate");

        color = hardwareMap.colorSensor.get("color");

        eopd = hardwareMap.opticalDistanceSensor.get("eopd");

        touch = hardwareMap.touchSensor.get("touch");

        gyro = hardwareMap.gyroSensor.get("gyro");

        //close the floodgate
        floodgate.setPosition(1);
        buttonPresser.setPosition(0);
        //waits for user to press start
        waitForStart();

        encoderForward(49, 0.5, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        shootTwo(floodgate, launcher, opModeIsActive());
        gyroTurn(5, 1.0, true, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, gyro, opModeIsActive());
        encoderForward(30, 1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        gyroTurn(10, 1.0, false, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, gyro, opModeIsActive());

        gyroTurn(10, 1.0, false, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, gyro, opModeIsActive());
        encoderForward(-18, -1, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        gyroTurn(10, 1, true, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, gyro, opModeIsActive());
        encoderForward(144, 1, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        gyroTurn(5, 1, false, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, gyro, opModeIsActive());
        encoderForward(12, 1, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
    }


}