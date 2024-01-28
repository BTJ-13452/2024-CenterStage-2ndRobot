package org.firstinspires.ftc.teamcode.robot_system;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class System_Plane {

    final String PLANE_CONFIG = "plane";
    CRServo plane;

    public System_Plane(HardwareMap map){
        plane = map.crservo.get(PLANE_CONFIG);
    }

    public void releasePlane(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                plane.setPower(1);
                sleep(1000);
                plane.setPower(0);
            }
        }).start();
    }
}
