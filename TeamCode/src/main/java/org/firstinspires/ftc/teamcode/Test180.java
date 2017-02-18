package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.teamcode.MethodSlave.encoderTurn;

/**
 * Created by Fluff on 1/25/2017.
 */

//sets program name and group on phone, and groups are in AIGHUHGGHUGHG order
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

        encoderTurn(20.42, 1.0, true, leftMotor, rightMotor, opModeIsActive());
    }

}
/**
 * I like big butts and I cannot lie
 * -BLING2000
 */