package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Hasan on 4/11/2017.
 */
@TeleOp(name = "servo test", group = "Test")
public class ServoTester extends OpMode{
    Servo servo360;
    Servo highSpeed;
    @Override
    public void init() {
        servo360 = hardwareMap.servo.get("floodGate");
        highSpeed = hardwareMap.servo.get("button");
    }

    @Override
    public void loop() {
        if(gamepad1.x) {
            servo360.setPosition(1);
        } else {
            servo360.setPosition(0);
        }

        if(gamepad1.y) {
            highSpeed.setPosition(1);
        } else {
            highSpeed.setPosition(0);
        }
    }
}
