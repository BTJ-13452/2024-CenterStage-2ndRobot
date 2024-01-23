package org.firstinspires.ftc.teamcode.op_modes.tele_op;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot_system.System_Drive;
import org.firstinspires.ftc.teamcode.robot_system.System_ElevatorErection;

@TeleOp
public class Tele_Op extends OpMode {

    System_Drive driveSystem;
    System_ElevatorErection erectionSystem;


    boolean trigger1Pressed = false;

    @Override
    public void init() {
        driveSystem = new System_Drive(hardwareMap, gamepad1);
        erectionSystem = new System_ElevatorErection(hardwareMap);
    }

    @Override
    public void loop() {
        driveSystem.Drive();

        if(gamepad1.right_trigger >0 || gamepad1.left_trigger >0){
            trigger1Pressed = true;
            erectionSystem.raisedAndlowerErection(gamepad1.right_trigger - gamepad1.left_trigger);
        }else if(trigger1Pressed){
            erectionSystem.stopErection();
            trigger1Pressed = false;
        }
    }
}
