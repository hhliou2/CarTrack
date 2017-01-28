package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.teamcode.MethodSlave.encoderTurn;

/**
 * Created by Hasan on 12/1/2016.
 */

//sets program name and group on phone, and groups are in alphabetic order
@Autonomous(name="Test 180", group="Test")
public class Test180 extends LinearOpMode {

    //initialize motors, servos, booleans, and sensors
    DcMotor leftMotor;
    DcMotor rightMotor;


    @Override
    public void runOpMode() throws InterruptedException {
        //initializes components to names on phone
        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");

        //waits for user to press start
        waitForStart();

        encoderTurn(25, 1.0, true, leftMotor, rightMotor, opModeIsActive());
    }


}
