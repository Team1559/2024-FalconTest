// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Falcons extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final TalonFX motor1;
  private final TalonFX motor2;
  private double speed = 0;

  public Falcons() {
    motor1 = new TalonFX(19);
    motor2 = new TalonFX(17);
    motor1.setInverted(true);
    motor2.setInverted(false);
  }

  public void decrease() {
    speed -= 0.05;
    if (speed < 0) speed = 0;
    System.out.println("decreased: " + speed);
  }

  public void increase() {
    speed += 0.05;
    if (speed > 1) speed = 1;
    System.out.println("increased" + speed);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    motor1.setControl(new DutyCycleOut(speed));
    motor2.setControl(new DutyCycleOut(speed));
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
