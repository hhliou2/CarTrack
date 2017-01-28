package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.MethodSlave.encoderForward;
import static org.firstinspires.ftc.teamcode.MethodSlave.shootOne;

/**
 * Created by Fluff on 1/28/2017.
 */

//sets program name and group on phone, and groups are in alphabetic order
@Autonomous(name="Center Shoot One Stop Red", group="Stop")
public class VVShootOneStopCenterRed extends LinearOpMode {

    //initialize motors and floodgate servo.
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor loader;
    DcMotor launcher;

    Servo floodgate;

    @Override
    public void runOpMode() throws InterruptedException {
        //initializes components to names on phone
        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        loader = hardwareMap.dcMotor.get("loader");
        launcher = hardwareMap.dcMotor.get("launcher");

        floodgate = hardwareMap.servo.get("floodGate");

        //close the floodgate
        floodgate.setPosition(1);
        //waits for user to press start
        waitForStart();

        encoderForward(4.4, 1.0, leftMotor, rightMotor,opModeIsActive());
        shootOne(floodgate, launcher, opModeIsActive()); }
}

