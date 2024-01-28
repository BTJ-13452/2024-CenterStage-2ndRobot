//package org.firstinspires.ftc.teamcode.robot_system;
//
//import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.hardware.Servo;
//public class System_EndPoint {
//
//    final String RIGHT_CLIPPER_CONFIG ="";
//    final String LEFT_CLIPPER_CONFIG ="";
//    final String ANGLE_ADAPTER_CONFIG ="";
//
//    Servo rightClipper;
//    Servo leftClipper;
//    Servo angleAdapter;
//
//    public System_EndPoint(HardwareMap map){
//        rightClipper = map.servo.get(RIGHT_CLIPPER_CONFIG);
//        leftClipper = map.servo.get(LEFT_CLIPPER_CONFIG);
//        angleAdapter = map.servo.get(ANGLE_ADAPTER_CONFIG);
//    }
//
//    public void openCloseRight
//}
package org.firstinspires.ftc.teamcode.op_modes.tele_op;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot_system.System_Drive;
import org.firstinspires.ftc.teamcode.robot_system.System_ElevatorErection;
import org.firstinspires.ftc.teamcode.robot_system.System_EndPoint;
import org.firstinspires.ftc.teamcode.robot_system.System_Hanging;
import org.firstinspires.ftc.teamcode.robot_system.System_Plane;

@TeleOp
public class Tele_Op extends OpMode {

    System_Drive driveSystem;
    System_ElevatorErection erectionSystem;
    System_EndPoint endPointSystem;
    System_Hanging hangingSystem;
    System_Plane planeSystem;


    boolean trigger1Pressed = false;
    boolean aIsPressed = false;
    boolean bIsPressed = false;
    boolean xIsPressed = false;
    boolean yIsPressed = false;
    boolean dpad_downIsPressed = false;

    @Override
    public void init() {
        driveSystem = new System_Drive(hardwareMap, gamepad1);
        erectionSystem = new System_ElevatorErection(hardwareMap);
        endPointSystem = new System_EndPoint(hardwareMap);
        hangingSystem = new System_Hanging(hardwareMap);
        planeSystem = new System_Plane(hardwareMap);
        telemetry.addData("end init", "");
        telemetry.update();
    }

    @Override
    public void loop() {
        driveLoop();

        erectionLoop();

        endPointLoop();

        hangLoop();

        planeLoop();
    }

    public void driveLoop(){
        driveSystem.Drive();
    }

    public void erectionLoop(){
        if(gamepad1.right_trigger >0 || gamepad1.left_trigger >0){
            trigger1Pressed = true;
            erectionSystem.raisedAndlowerErection(gamepad1.right_trigger - gamepad1.left_trigger);
        }else if(trigger1Pressed){
            erectionSystem.stopErection();
            trigger1Pressed = false;
        }
    }

    public void hangLoop(){
        if(gamepad1.y && !yIsPressed){
            yIsPressed = true;
            hangingSystem.OpenAndCloseHang();
        } else if (yIsPressed && !gamepad1.y) {
            yIsPressed = false;
        }
    }

    public void planeLoop(){
        if(gamepad1.dpad_down && !dpad_downIsPressed){
            dpad_downIsPressed = true;
            planeSystem.releasePlane();
        } else if (dpad_downIsPressed && !gamepad1.dpad_down) {
            dpad_downIsPressed = false;
        }
    }

    public void endPointLoop(){
        if(gamepad1.a && !aIsPressed){
            aIsPressed = true;
            endPointSystem.openAndCloseRight();
        } else if (aIsPressed && !gamepad1.a) {
            aIsPressed = false;
        }

        if(gamepad1.b && !bIsPressed){
            bIsPressed = true;
            endPointSystem.openAndCloseLeft();
        } else if (bIsPressed && !gamepad1.b) {
            bIsPressed = false;
        }

        if(gamepad1.x && !xIsPressed){
            xIsPressed = true;
            endPointSystem.LoadReleaseAngle();
        } else if (xIsPressed && !gamepad1.x) {
            xIsPressed = false;
        }

        if(gamepad1.x && !xIsPressed){
            xIsPressed = true;
            endPointSystem.LoadReleaseAngle();
        } else if (xIsPressed && !gamepad1.x) {
            xIsPressed = false;
        }
    }
}