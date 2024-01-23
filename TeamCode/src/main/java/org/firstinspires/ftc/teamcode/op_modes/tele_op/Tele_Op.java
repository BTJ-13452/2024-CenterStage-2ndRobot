package org.firstinspires.ftc.teamcode.op_modes.tele_op;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot_system.System_Drive;

@TeleOp
public class Tele_Op extends OpMode {

    System_Drive driveSystem;


    @Override
    public void init() {
        driveSystem = new System_Drive(hardwareMap, gamepad1);
    }

    @Override
    public void loop() {
        driveSystem.Drive();
    }
}
