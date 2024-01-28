////package org.firstinspires.ftc.teamcode.op_modes.tele_op;
////
////import com.qualcomm.robotcore.eventloop.opmode.OpMode;
////import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
////
////import org.firstinspires.ftc.teamcode.robot_system.System_Drive;
////import org.firstinspires.ftc.teamcode.robot_system.System_ElevatorErection;
////
////@TeleOp
////public class Tele_Op extends OpMode {
////
////    System_Drive driveSystem;
////    System_ElevatorErection erectionSystem;
////
////
////    boolean trigger1Pressed = false;
////
////    @Override
////    public void init() {
////        driveSystem = new System_Drive(hardwareMap, gamepad1);
////        erectionSystem = new System_ElevatorErection(hardwareMap);
////    }
////
////    @Override
////    public void loop() {
////        driveSystem.Drive();
////
////        if(gamepad1.right_trigger >0 || gamepad1.left_trigger >0){
////            trigger1Pressed = true;
////            erectionSystem.raisedAndlowerErection(gamepad1.right_trigger - gamepad1.left_trigger);
////        }else if(trigger1Pressed){
////            erectionSystem.stopErection();
////            trigger1Pressed = false;
////        }
////    }
////}
//package org.firstinspires.ftc.teamcode.robot_system;
//
//import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.hardware.Servo;
//
//public class System_EndPoint {
//    final  String RIGHT_CLIPPER_CONFIG = "right clipper";
//    final  String LEFT_CLIPPER_CONFIG = "left clipper";
//    final  String ANGLE_ADAPTER_CONFIG = "angle adapter";
//    final  String HANG = "hang";
//    final  String PLANE = "plane";
//
//    final Double RIGHT_CLOSE_POS = 0.0;
//    final Double LEFT_CLOSE_POS = 0.0;
//    final Double RIGHT_OPEN_POS = 0.5;
//    final Double LEFT_OPEN_POS = 0.5;
//    final Double HANG_OPEN_POS = 0.0;
//    final Double HANG_CLOSE_POS = 1.0;
//    final Double PLANE_OPEN_POS = 0.0;
//    final Double PLANE_CLOSE_POS = 1.0;
//
//    final Double ANGLE_LOADING_POS = 1.0;
//    final Double ANGLE_RELEASING_POS = 0.2;
//    final Double ANGLE_START_POS = 0.2;
//
//    Servo right_clipper;
//    Servo left_clipper;
//    Servo angel_adapter;
//    Servo hang;
//    SerSvo plane;
//
//    boolean rightIsOpen;
//    boolean leftIsOpen;
//    boolean angleInReleasing;
//    boolean hangIsOpen;
//    boolean planeIsOpen;
//
//    public System_EndPoint(HardwareMap map){
//        right_clipper = map.servo.get(RIGHT_CLIPPER_CONFIG);
//        left_clipper = map.servo.get(LEFT_CLIPPER_CONFIG);
//        angel_adapter = map.servo.get(ANGLE_ADAPTER_CONFIG);
//        hang = map.servo.get(HANG);
//        plane = map.servo.get(PLANE);
//
//        right_clipper.setPosition(RIGHT_CLOSE_POS);
//        rightIsOpen = false;
//        left_clipper.setPosition(LEFT_CLOSE_POS);
//        leftIsOpen = false;
//        angel_adapter.setPosition(ANGLE_START_POS);
//        angleInReleasing = false;
//        hang.setPosition(HANG_CLOSE_POS);
//        hangIsOpen = false;
//        plane.setPosition(PLANE_CLOSE_POS);
//        planeIsOpen = false;
//    }
//
//    public void OpenCloseRight(){
//        if (rightIsOpen){
//            right_clipper.setPosition(RIGHT_CLOSE_POS);
//            rightIsOpen = false;
//        }
//        else{
//            right_clipper.setPosition(RIGHT_OPEN_POS);
//            rightIsOpen = true;
//        }
//    }
//
//    public void OpenCloseLeft(){
//        if (leftIsOpen){
//            left_clipper.setPosition(LEFT_CLOSE_POS);
//            leftIsOpen = false;
//        }
//        else{
//            left_clipper.setPosition(LEFT_OPEN_POS);
//            leftIsOpen = true;
//        }
//    }
//
//    public void OpenCloseHang(){
//        if (hangIsOpen){
//                hang.setPosition(HANG_CLOSE_POS);
//            hangIsOpen = false;
//        }
//        else{
//            hang.setPosition(HANG_OPEN_POS);
//            hangIsOpen = true;
//        }
//    }
//
//    public void OpenClosePlane(){
//        if (planeIsOpen){
//            plane.setPosition(PLANE_CLOSE_POS);
//            planeIsOpen = false;
//        }
//        else{
//            plane.setPosition(PLANE_OPEN_POS);
//            planeIsOpen = true;
//        }
//    }
//
//    public void LoadReleaseAngle(){
//        if(angleInReleasing){
//            angel_adapter.setPosition(ANGLE_LOADING_POS);
//            angleInReleasing = false;
//        }
//        else {
//            angel_adapter.setPosition(ANGLE_RELEASING_POS);
//            angleInReleasing = true;
//        }
//    }
//
//
//
//}