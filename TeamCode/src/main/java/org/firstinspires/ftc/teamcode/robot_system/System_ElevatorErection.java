/**
 * The System_ElevatorErection class represents the control system for an elevator erection mechanism in a robotic system.
 * It provides methods to control the movement of the elevator using motors and a touch sensor for zeroing.
 */
package org.firstinspires.ftc.teamcode.robot_system;

        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.HardwareMap;
        import com.qualcomm.robotcore.hardware.TouchSensor;

public class System_ElevatorErection {

    /**
     * Constant representing the number of ticks required for backdrops.
     */
    final public static int TICKS_FOR_BACKDROPS = 1;

    /**
     * Constant representing the number of ticks required for rigging.
     */
    final public static int TICKS_FOR_RIGGING = 2;

    /**
     * Default power setting for motor movements.
     */
    final double POWER = 1;

    /**
     * Configuration name for the right motor.
     */
    final String RIGHT_MOTOR_CONFIGURE = "erection right motor";

    /**
     * Configuration name for the left motor.
     */
    final String LEFT_MOTOR_CONFIGURE = "erection left motor";

    /**
     * Reference to the right motor.
     */
    DcMotor motorRight;

    /**
     * Reference to the left motor.
     */
    DcMotor motorLeft;

    /**
     * Touch sensor for zeroing the elevator position.
     */
    TouchSensor erectionSensor;

    /**
     * Constructor for the System_ElevatorErection class.
     *
     * @param map The HardwareMap object used to initialize hardware components.
     */
    public System_ElevatorErection(HardwareMap map) {
        // Motor initialization
        motorRight = map.dcMotor.get(RIGHT_MOTOR_CONFIGURE);
        motorLeft = map.dcMotor.get(LEFT_MOTOR_CONFIGURE);

        // Motor zero power behavior
        motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Set motors to zero position
        setToZero();

        // Motor run modes and encoder setup
        motorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorRight.setTargetPosition(0);
        motorLeft.setTargetPosition(0);

        motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    /**
     * Raises or lowers the elevator based on the specified multiplier.
     *
     * @param multiplier The multiplier to adjust the power for raising or lowering the elevator.
     */
    public void raisedAndlowerErection(int multiplier) {
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorLeft.setPower(POWER * multiplier);
        motorRight.setPower(POWER * multiplier);
    }

    /**
     * Stops the elevator and resets motor run modes and positions.
     */
    public void stopErection() {
        motorRight.setPower(0);
        motorLeft.setPower(0);

        motorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motorRight.setTargetPosition(motorRight.getCurrentPosition());
        motorLeft.setTargetPosition(motorLeft.getCurrentPosition());

        motorRight.setPower(1);
        motorLeft.setPower(1);

        motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    /**
     * Moves the elevator to a specified number of ticks using encoder positions.
     *
     * @param tick The target position in ticks.
     */
    public void erectionTicks(int tick) {
        motorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motorRight.setTargetPosition(tick);
        motorLeft.setTargetPosition(tick);

        motorRight.setPower(1);
        motorLeft.setPower(1);

        motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    /**
     * Sets the elevator to a zero position using the touch sensor.
     */
    public void setToZero() {
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorLeft.setPower(-0.5);
        motorRight.setPower(-0.5);

        // Wait until the touch sensor is pressed to set the position to zero
        while (!erectionSensor.isPressed()) {
        }

        motorRight.setPower(0);
        motorLeft.setPower(0);
    }
}

