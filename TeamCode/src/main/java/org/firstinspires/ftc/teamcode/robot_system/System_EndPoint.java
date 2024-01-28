package org.firstinspires.ftc.teamcode.robot_system;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class System_EndPoint {

    final String RIGHT_CLIPPER_CONFIG = "right clipper";
    final String LEFT_CLIPPER_CONFIG = "left clipper";
    final String ANGLE_ADAPTER_CONFIG = "angle adapter";

    final double RIGHT_CLOSE_POS = 0.0;
    final double RIGHT_OPEN_POS = 0.5;

    final double LEFT_CLOSE_POS = 0.0;
    final double LEFT_OPEN_POS = 0.5;

    final double ANGLE_ADAPTER_LOAD_POS = 1.0;
    final double ANGLE_ADAPTER_RELEASE_POS = 0.2;
    final double ANGLE_ADAPTER_START_POS = 0.5;

    Servo angle_adapter;
    Servo left_clipper;
    Servo right_clipper;


    boolean rightIsOpen;
    boolean leftIsOpen;
    boolean angleAdapterRelease;
    public System_EndPoint(HardwareMap map){
        right_clipper = map.servo.get(RIGHT_CLIPPER_CONFIG);
        left_clipper = map.servo.get(LEFT_CLIPPER_CONFIG);
        angle_adapter = map.servo.get(ANGLE_ADAPTER_CONFIG);

        right_clipper.setPosition(RIGHT_CLOSE_POS);
        rightIsOpen = false;

        left_clipper.setPosition(LEFT_CLOSE_POS);
        leftIsOpen = false;

        angle_adapter.setPosition(ANGLE_ADAPTER_START_POS);
        angleAdapterRelease = false;
    }



    public void openAndCloseRight(){
        if (rightIsOpen){
            right_clipper.setPosition(RIGHT_CLOSE_POS);
            rightIsOpen = false;
        }else{
            right_clipper.setPosition(RIGHT_OPEN_POS);
            rightIsOpen  = true;
        }
    }
    public void openAndCloseLeft(){
        if (leftIsOpen){
            left_clipper.setPosition(LEFT_CLOSE_POS);
            leftIsOpen = false;
        }else {
            left_clipper.setPosition(LEFT_OPEN_POS);
            leftIsOpen = true;
        }
    }

    public void LoadReleaseAngle(){
        if (angleAdapterRelease){
            angle_adapter.setPosition(ANGLE_ADAPTER_RELEASE_POS);
            angleAdapterRelease = false;
        }else {
            angle_adapter.setPosition(ANGLE_ADAPTER_LOAD_POS);
            angleAdapterRelease = true;
        }
    }
}
