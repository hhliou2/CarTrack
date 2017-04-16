package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

import static org.firstinspires.ftc.teamcode.MethodSlave.gyroTurn;

/**
 * Created by Fluff on 1/28/2017.
 */

//sets program name and group on phone, and groups are in alphabetic order
@Autonomous(name="Red Beacon Rotate", group="Test")
public class VVRedBeaconRotate extends LinearOpMode {

    //initialize motors, servos, booleans, and sensors
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;

    GyroSensor gyro;

    @Override
    public void runOpMode() throws InterruptedException {
        //initializes components to names on phone
        backLeftMotor = hardwareMap.dcMotor.get("backleft");
        backRightMotor = hardwareMap.dcMotor.get("backright");
        frontLeftMotor = hardwareMap.dcMotor.get("frontleft");
        frontRightMotor = hardwareMap.dcMotor.get("frontright");

        gyro = hardwareMap.gyroSensor.get("gyro");

        //waits for user to press start
        waitForStart();

        gyroTurn(27.57333, 1.0, false, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, gyro, opModeIsActive());
        sleep(2000);
        gyroTurn(5.426, 1.0, false, backLeftMotor,  backRightMotor, frontLeftMotor, frontRightMotor, gyro, opModeIsActive());
    }


}




