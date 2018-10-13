package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import static org.firstinspires.ftc.teamcode.MethodSlave.encoderForward;
import static org.firstinspires.ftc.teamcode.MethodSlave.gyroTurn;
import static org.firstinspires.ftc.teamcode.MethodSlave.realEncoderForwardRight;
import static org.firstinspires.ftc.teamcode.MethodSlave.shootOne;
import static org.firstinspires.ftc.teamcode.MethodSlave.shootTwo;

/**
 * Created by Hasan on 12/1/2016.
 */

//sets program name and group on phone, and groups are in alphabetic order
@Autonomous(name="Shoot Two Auts", group="Auts")
public class VVShootTwoAuts extends LinearOpMode {

    //initialize motors, servos, booleans, and sensors
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor loader;
    DcMotor launcher;

    Servo floodgate;
    Servo rightPresser;
    Servo leftPresser;



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

        //close the floodgate
        floodgate.setPosition(1);
        rightPresser.setPosition(0);
        leftPresser.setPosition(1.0);

        //waits for user to press start
        waitForStart();

        sleep(15000);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoderForward(37, 1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());
        shootTwo(floodgate, launcher, opModeIsActive());
        encoderForward(18, 1.0, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, opModeIsActive());


    }

}
