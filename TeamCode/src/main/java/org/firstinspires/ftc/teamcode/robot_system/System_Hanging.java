package org.firstinspires.ftc.teamcode.robot_system;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class System_Hanging {

    final  String HANG_CONFIG = "hang";
    final Double HANG_OPEN_POS = 0.0;
    final Double HANG_CLOSE_POS = 1.0;

    Servo hang;

    boolean hangIsOpen;
    public System_Hanging(HardwareMap map){
        hang = map.servo.get(HANG_CONFIG);

        hang.setPosition(HANG_CLOSE_POS);
        hangIsOpen = false;
    }
    public void OpenAndCloseHang(){
        if (hangIsOpen){
            hang.setPosition(HANG_CLOSE_POS);
            hangIsOpen = false;
        }
        else{
            hang.setPosition(HANG_OPEN_POS);
            hangIsOpen = true;
        }
    }
}
