package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.MethodSlave.gyroTurn;
import static org.firstinspires.ftc.teamcode.MethodSlave.swingRight;

/**
 * Created by Hasan on 12/1/2016.
 */

//sets program name and group on phone, and groups are in alphabetic order
@Autonomous(name="Test 180", group="Test")
public class Test180 extends LinearOpMode {

    //initialize motors, servos, booleans, and sensors
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    GyroSensor gyro;
    Servo buttonPresser;

    @Override
    public void runOpMode() throws InterruptedException {
        //initializes components to names on phone
        backLeftMotor = hardwareMap.dcMotor.get("backleft");
        backRightMotor = hardwareMap.dcMotor.get("backright");
        gyro = hardwareMap.gyroSensor.get("gyro");
        buttonPresser = hardwareMap.servo.get("button");

        buttonPresser.setPosition(0);

        //waits for user to press start
        waitForStart();

        gyro.calibrate();
        while (gyro.isCalibrating()) {
            backLeftMotor.setPower(0);
        }
        swingRight(167, 0.4, backLeftMotor, backRightMotor, frontLeftMotor, frontRightMotor, gyro, opModeIsActive());
    }


}
