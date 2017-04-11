package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import static java.lang.Thread.sleep;

/**
 * Created by Hasan on 12/1/2016.
 */

public class MethodSlave {

    //sets several constants
    private final static int ENCODER_CPR = 560;
    private final static double GEAR_RATIO = 1;
    private final static int WHEEL_DIAMETER = 3;

    //gets circumference of wheel
    private final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;

    //sets several constants
    // changed to neverest 40 encoder values but kept as ENCODER_CPR_NEVEREST60 for convenience of coding
    private final static int ENCODER_CPR_NEVEREST60 = 1120;
    private final static double GEAR_RATIO_NEVEREST60 = 4;
    private final static int ROTATIONS_NEVEREST60 = 1;

    //sets value to be sent to encoder
    private final static double COUNTS_NEVEREST60 = ENCODER_CPR_NEVEREST60 * ROTATIONS_NEVEREST60 * GEAR_RATIO_NEVEREST60;

    public static void rangeLeft(double range, double speed, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor, ModernRoboticsI2cRangeSensor frange, boolean opModeIsActive){
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        if(opModeIsActive){
            if(frange.getDistance(DistanceUnit.CM) > range){
                while ((frange.getDistance(DistanceUnit.CM) > range)) {
                    backLeftMotor.setPower(speed);
                    frontLeftMotor.setPower(speed);
                    backRightMotor.setPower(speed);
                    frontRightMotor.setPower(speed);
                }
            } else if (frange.getDistance(DistanceUnit.CM) <= range){
                backLeftMotor.setPower(0);
                frontLeftMotor.setPower(0);
                backRightMotor.setPower(0);
                frontRightMotor.setPower(0);
            }
        } else if (!opModeIsActive){
            backLeftMotor.setPower(0);
            frontLeftMotor.setPower(0);
            backRightMotor.setPower(0);
            frontRightMotor.setPower(0);
        }

    }

    public static void rangeRight(double range, double speed, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor, ModernRoboticsI2cRangeSensor frange, boolean opModeIsActive){
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        if(opModeIsActive){
            if(frange.getDistance(DistanceUnit.CM) > range){
                while ((frange.getDistance(DistanceUnit.CM) > range)) {
                    backLeftMotor.setPower(-speed);
                    backRightMotor.setPower(-speed);
                    frontLeftMotor.setPower(-speed);
                    frontRightMotor.setPower(-speed);
                }
            } else if (frange.getDistance(DistanceUnit.CM) <= range){
                backLeftMotor.setPower(0);
                backRightMotor.setPower(0);
                frontLeftMotor.setPower(0);
                frontRightMotor.setPower(0);
            }
        } else if (!opModeIsActive){
            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
        }

    }

    public static void encoderSlow(double distance, double speed, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor, boolean opModeIsActive) {
        double rotations = distance / CIRCUMFERENCE;
        double counts = ENCODER_CPR * rotations * GEAR_RATIO;

        //start encoder run cycle, turns to next beacon
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setTargetPosition((int) counts);
        backRightMotor.setTargetPosition((int) -counts);
        frontLeftMotor.setTargetPosition((int) counts);
        frontRightMotor.setTargetPosition((int) -counts);

        backLeftMotor.setPower(-speed * 0.80);
        backRightMotor.setPower(speed);
        frontLeftMotor.setPower(-speed * 0.80);
        frontRightMotor.setPower(speed);

        while (backLeftMotor.isBusy() && backRightMotor.isBusy() && opModeIsActive) {
            backLeftMotor.setPower(-speed * 0.8);
            backRightMotor.setPower(speed);
            frontLeftMotor.setPower(-speed * 0.80);
            frontRightMotor.setPower(speed);
        }
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


    public static void encoderForward(double distance, double speed, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor, boolean opModeIsActive) {
        double rotations = distance / CIRCUMFERENCE;
        double counts = ENCODER_CPR * rotations * GEAR_RATIO;

        //start encoder run cycle, turns to next beacon
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setTargetPosition((int) counts);
        backRightMotor.setTargetPosition((int) -counts);
        frontLeftMotor.setTargetPosition((int) counts);
        frontRightMotor.setTargetPosition((int) -counts);

        backLeftMotor.setPower(-speed*0.8);
        backRightMotor.setPower(speed);
        frontLeftMotor.setPower(-speed*0.8);
        frontRightMotor.setPower(speed);

        while (backLeftMotor.isBusy() && backRightMotor.isBusy() && opModeIsActive) {
            backLeftMotor.setPower(-speed*0.8);
            backRightMotor.setPower(speed);
            frontLeftMotor.setPower(-speed*0.8);
            frontRightMotor.setPower(speed);
        }

        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //end of cycle
    }

    public static void gyroForward(double distance, double speed, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor, GyroSensor gyro, boolean opModeIsActive) {
        double rotations = distance / CIRCUMFERENCE;
        double counts = ENCODER_CPR * rotations * GEAR_RATIO;

        //sets gyro to 1
        gyro.calibrate();

        //start encoder run cycle, turns to next beacon
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setTargetPosition((int) counts);
        backRightMotor.setTargetPosition((int) -counts);
        frontLeftMotor.setTargetPosition((int) counts);
        frontRightMotor.setTargetPosition((int) -counts);

        backLeftMotor.setPower(speed);
        backRightMotor.setPower(-speed);
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(-speed);

        while (backLeftMotor.isBusy() && opModeIsActive) {
            if((gyro.getHeading())>1 && (gyro.getHeading())<20 && opModeIsActive){
                //if the robot is angled right, make the left motor slower
                backLeftMotor.setPower(speed * 0.75);
                backRightMotor.setPower(-speed);
                frontLeftMotor.setPower(speed * 0.75);
                frontRightMotor.setPower(-speed);
            }
            else if (((gyro.getHeading()) <= 359) && ((gyro.getHeading() >= 339)) && opModeIsActive ){
                //if the robot is angled left, make the right motor slower
                backLeftMotor.setPower(speed);
                backRightMotor.setPower(-speed * 0.75);
                frontLeftMotor.setPower(speed);
                frontRightMotor.setPower(-speed * 0.75);
            }
            else{
                //just go straight when facing straight
                backLeftMotor.setPower(speed);
                backRightMotor.setPower(-speed);
                frontLeftMotor.setPower(speed);
                frontRightMotor.setPower(-speed);
            }
        }

        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //end of cycle
    }

    public static void realEncoderForwardLeft(double distance, double speed, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor, boolean opModeIsActive) {
        double rotations = distance / CIRCUMFERENCE;
        double counts = ENCODER_CPR * rotations * GEAR_RATIO;

        //start encoder run cycle, turns to next beacon
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setTargetPosition((int) -counts);
        backRightMotor.setTargetPosition((int) -counts);
        frontLeftMotor.setTargetPosition((int) -counts);
        frontRightMotor.setTargetPosition((int) -counts);

        backLeftMotor.setPower(-speed);
        backRightMotor.setPower(-speed);
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(-speed);

        while (backLeftMotor.isBusy() && opModeIsActive) {
            backLeftMotor.setPower(-speed);
            backRightMotor.setPower(-speed);
            frontLeftMotor.setPower(-speed);
            frontRightMotor.setPower(-speed);
        }

        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //end of cycle
    }

    public static void realEncoderForwardRight(double distance, double speed, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor, boolean opModeIsActive) {
        double rotations = distance / CIRCUMFERENCE;
        double counts = ENCODER_CPR * rotations * GEAR_RATIO;

        //start encoder run cycle, turns to next beacon
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setTargetPosition((int) counts);
        backRightMotor.setTargetPosition((int) counts);
        frontLeftMotor.setTargetPosition((int) counts);
        frontRightMotor.setTargetPosition((int) counts);

        backLeftMotor.setPower(speed);
        backRightMotor.setPower(speed);
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(speed);

        while (backLeftMotor.isBusy() && opModeIsActive) {
            backLeftMotor.setPower(speed);
            backRightMotor.setPower(speed);
            frontLeftMotor.setPower(speed);
            frontRightMotor.setPower(speed);
        }

        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //end of cycle
    }

    public static void gyroTurn(double angle, double speed, boolean isLeft, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor, GyroSensor gyro,
                                boolean opModeIsActive) {
        if (isLeft) {

            while ( opModeIsActive && (gyro.getHeading() > (360 - angle) || gyro.getHeading() <= 2)) {
                if (opModeIsActive) {
                    backLeftMotor.setPower(-speed);
                    backRightMotor.setPower(-speed);
                    frontLeftMotor.setPower(-speed);
                    frontRightMotor.setPower(-speed);
                } else {
                    return;
                }
            }

            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
        } else {

            while (opModeIsActive && (gyro.getHeading() < angle || gyro.getHeading() == 0)) {
                if (opModeIsActive) {
                    backLeftMotor.setPower(speed);
                    backRightMotor.setPower(speed);
                    frontLeftMotor.setPower(speed);
                    frontRightMotor.setPower(speed);
                } else {
                    return;
                }
            }

            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
        }
    }

    public static void swingLeft(double angle, double speed, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor, GyroSensor gyro,
                                 boolean opModeIsActive) {

        while (opModeIsActive && (gyro.getHeading() > (360 - angle) || (gyro.getHeading() <= 2))) {
            if (opModeIsActive) {
                backLeftMotor.setPower(0);
                backRightMotor.setPower(-speed);
                frontLeftMotor.setPower(0);
                frontRightMotor.setPower(-speed);
            } else {
                return;
            }
        }

        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
    }

    public static void swingRight(double angle, double speed, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor, GyroSensor gyro,
                                  boolean opModeIsActive) {

        while (opModeIsActive && (gyro.getHeading() < angle || gyro.getHeading() == 0)) {
            if (opModeIsActive) {
                backLeftMotor.setPower(speed);
                backRightMotor.setPower(0);
                frontLeftMotor.setPower(speed);
                frontRightMotor.setPower(0);
            } else {
                return;
            }
        }

        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
    }

    public static void shootOne(Servo floodgate, DcMotor launcher, boolean opModeIsActive) {
        floodgate.setPosition(1);
        //start encoder run cycle, turns to next beacon
        launcher.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        launcher.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        launcher.setTargetPosition((int) -COUNTS_NEVEREST60);

        launcher.setPower(-1.0);

        while (launcher.isBusy() && opModeIsActive) {
            launcher.setPower(-1.0);
        }

        launcher.setPower(0);

        launcher.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //end of cycle
        floodgate.setPosition(1);
    }

    public static void shootTwo (Servo floodgate, DcMotor launcher, boolean opModeIsActive)  throws InterruptedException{
        floodgate.setPosition(1);
        //start encoder run cycle, turns to next beacon
        launcher.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        launcher.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        launcher.setTargetPosition((int) -COUNTS_NEVEREST60);

        launcher.setPower(-1.0);

        while (launcher.isBusy() && opModeIsActive) {
            launcher.setPower(-1.0);
        }

        launcher.setPower(0);

        launcher.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //end of cycle
        floodgate.setPosition(0);
        sleep(1000);
        floodgate.setPosition(1);

        launcher.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        launcher.setTargetPosition((int) -COUNTS_NEVEREST60);

        launcher.setPower(-1.0);

        while (launcher.isBusy() && opModeIsActive) {
            launcher.setPower(-1.0);
        }

        launcher.setPower(0);

        launcher.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //end of cycle
    }

    public static void wallAlign(double distance, double speed, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor,
                                 ModernRoboticsI2cRangeSensor frange, boolean opModeIsActive){
        double rotations = distance / CIRCUMFERENCE;
        double counts = ENCODER_CPR * rotations * GEAR_RATIO;

        //start encoder run cycle, turns to next beacon
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeftMotor.setTargetPosition((int) counts);
        backRightMotor.setTargetPosition((int) -counts);
        frontLeftMotor.setTargetPosition((int) counts);
        frontRightMotor.setTargetPosition((int) -counts);

        backLeftMotor.setPower(speed*0.8);
        backRightMotor.setPower(-speed);
        frontLeftMotor.setPower(speed*0.8);
        frontRightMotor.setPower(-speed);

        while (opModeIsActive) {
            if (frange.getDistance(DistanceUnit.CM) > 13) {
                backLeftMotor.setPower(-speed);
                backRightMotor.setPower(speed / 2.5);
                frontLeftMotor.setPower(-speed);
                frontRightMotor.setPower(speed / 2.5);
            } else if (frange.getDistance(DistanceUnit.CM) < 9) {
                frontLeftMotor.setPower(-speed / 2.5);
                frontRightMotor.setPower(speed);
                frontLeftMotor.setPower(-speed / 2.5);
                frontRightMotor.setPower(speed);
            }
        }

        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);

        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


    public static void lineApproach(double intensity, double speed, double range, boolean isWhiteLine, DcMotor backLeftMotor, DcMotor backRightMotor, DcMotor frontLeftMotor, DcMotor frontRightMotor,
                                    OpticalDistanceSensor eopd, ModernRoboticsI2cRangeSensor frange, boolean opModeIsActive) {
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        if(isWhiteLine) {
            while (opModeIsActive) {
                if (eopd.getLightDetected() < intensity) {
                    frange.getDistance(DistanceUnit.CM);
                    if (frange.getDistance(DistanceUnit.CM) < range) {
                        backLeftMotor.setPower(speed * 0.3);
                        backRightMotor.setPower(-speed);
                        frontLeftMotor.setPower(speed * 0.3);
                        frontRightMotor.setPower(-speed);
                    } else if (frange.getDistance(DistanceUnit.CM) > range) {
                        backLeftMotor.setPower(speed);
                        backRightMotor.setPower(-speed * 0.3);
                        frontLeftMotor.setPower(speed);
                        frontRightMotor.setPower(-speed * 0.3);

                    } else {
                        backLeftMotor.setPower(speed);
                        backRightMotor.setPower(-speed);
                        frontLeftMotor.setPower(speed);
                        frontRightMotor.setPower(-speed);
                    }
                }else if(eopd.getLightDetected() > intensity) {
                    break;
                }
            }

            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
        } /* else {
           while (opModeIsActive && (eopd.getLightDetected() > intensity)) {
               backLeftMotor.setPower(speed);
               backRightMotor.setPower(-speed);
           }
           backLeftMotor.setPower(0);
           backRightMotor.setPower(0);
       }

   }
*/}
    public static void backApproach(double intensity, double speed, boolean isWhiteLine, DcMotor backLeftMotor, DcMotor backRightMotor,DcMotor frontLeftMotor, DcMotor frontRightMotor,
                                    OpticalDistanceSensor eopd, ModernRoboticsI2cRangeSensor frange, boolean opModeIsActive){
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        if(isWhiteLine) {
            while (opModeIsActive) {
                if (eopd.getLightDetected() < intensity) {
                    frange.getDistance(DistanceUnit.CM);
                    if (frange.getDistance(DistanceUnit.CM) < 11) {
                        backLeftMotor.setPower(-speed / 2.5);
                        backRightMotor.setPower(speed);
                        frontLeftMotor.setPower(-speed / 2.5);
                        frontRightMotor.setPower(speed);

                    } else if (frange.getDistance(DistanceUnit.CM) > 11) {
                        backLeftMotor.setPower(-speed);
                        backRightMotor.setPower(speed / 2.5);
                        frontLeftMotor.setPower(-speed);
                        frontRightMotor.setPower(speed / 2.5);

                    } else {
                        backLeftMotor.setPower(-speed);
                        backRightMotor.setPower(speed);
                        frontLeftMotor.setPower(-speed);
                        frontRightMotor.setPower(speed);
                    }
                }else if(eopd.getLightDetected() > intensity) {
                    break;
                }
            }

            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
        }
    }
    public static void lineFollow (double intensity, double speed, boolean isWhiteLine, DcMotor backLeftMotor, DcMotor backRightMotor,
                                   DcMotor frontLeftMotor, DcMotor frontRightMotor,
                                   TouchSensor touch, OpticalDistanceSensor eopd, boolean opModeIsActive) {
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        if(isWhiteLine) {
            while (!touch.isPressed() && opModeIsActive) {
                if(eopd.getLightDetected() < intensity) {
                    backLeftMotor.setPower(speed);
                    backRightMotor.setPower(0);
                    frontLeftMotor.setPower(speed);
                    frontRightMotor.setPower(0);
                }
                else {
                    backRightMotor.setPower(-speed);
                    backLeftMotor.setPower(0);
                    frontRightMotor.setPower(-speed);
                    frontLeftMotor.setPower(0);
                }
            }

            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
        } else {
            while (!touch.isPressed() && opModeIsActive) {
                if(eopd.getLightDetected() > intensity) {
                    backLeftMotor.setPower(speed);
                    backRightMotor.setPower(0);
                    frontLeftMotor.setPower(speed);
                    frontRightMotor.setPower(0);
                }
                else {
                    backRightMotor.setPower(-speed);
                    backLeftMotor.setPower(0);
                    frontRightMotor.setPower(-speed);
                    frontLeftMotor.setPower(0);
                }
            }

            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
        }
    }

    public static void beaconCheckOut(Servo buttonPresser) {
        //checks color sensor value and presses beacon

        buttonPresser.setPosition(0);

    }

    public static void beaconCheckIn(Servo buttonPresser) {
        //checks color sensor value and presses beacon

        buttonPresser.setPosition(1.0);

    }
}

