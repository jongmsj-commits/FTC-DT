
package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "DT", group = "Test")
public class DT extends OpMode {


    private DcMotor FL;
    private DcMotor FR;
    private DcMotor BL;
    private DcMotor BR;


    @Override
    public void init() {

        FL = hardwareMap.get(DcMotor.class, "frontLeft");
        FR = hardwareMap.get(DcMotor.class, "frontRight");
        BL = hardwareMap.get(DcMotor.class, "backLeft");
        BR = hardwareMap.get(DcMotor.class, "backRight");


        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


    @Override
    public void loop() {


        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;


        double turn = gamepad1.right_stick_x;


        double denominator = Math.max(
                Math.abs(y) + Math.abs(x) + Math.abs(turn), 1.0
        );


        double FLPower = (y + x + turn) / denominator;
        double BLPower = (y - x + turn) / denominator;
        double FRPower = (y - x - turn) / denominator;
        double BRPower = (y + x - turn) / denominator;


        FL.setPower(FLPower);
        BL.setPower(BLPower);
        FR.setPower(FRPower);
        BR.setPower(BRPower);
    }
}
