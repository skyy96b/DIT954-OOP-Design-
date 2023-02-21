package src.main.java.Controller;
import src.main.java.Model.Car;
import src.main.java.Model.IPlatform;
import src.main.java.Model.Saab95;
import src.main.java.Model.Scania;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController{
    // member fields:

    // A list of cars, modify if needed
    private List<Car> cars;
    private CompositeCar compositeCar;

    private double jSpinnerAmount = 0;

    //methods:

    public CarController(List<Car> cars){

        this.cars = cars;
        this.compositeCar = new CompositeCar(cars);
    }

    /**
     * Create a JButton with a listener
     * @param listener
     * @return
     */
    public JButton createButton(String buttonText, ActionListener listener){
        JButton button = new JButton(buttonText);
        button.addActionListener(listener);
        return button;
    }

    public JButton createGasButton(){
        return this.createButton("Gas", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gas = ((double) jSpinnerAmount) / 100;
                try {
                    compositeCar.gas(gas);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public JButton createBrakeButton(){
        return this.createButton("Brake", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gas = ((double) jSpinnerAmount) / 100;
                try {
                    compositeCar.brake(gas);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public JButton createStartAllCarsButton(){
        return this.createButton("Start All Cars", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compositeCar.startEngine();
            }
        });
    }

    public JButton createStopAllCarsButton(){
        return this.createButton("Stop All Cars", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compositeCar.stopEngine();
            }
        });
    }

    public JButton createTurboOnButton(){
        return this.createButton("Turbo On",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compositeCar.setTurbo(true);
            }
        });
    }

    public JButton createTurboOffButton(){
        return this.createButton("Turbo Off",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compositeCar.setTurbo(false);
            }
        });
    }

    public JButton createRaisePlatformButton(){
        return this.createButton("Raise platform",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compositeCar.raisePlatform();
            }
        });
    }

    public JButton createLowerPlatformButton(){
        return this.createButton("Lower platform",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compositeCar.lowerPlatform();
            }
        });
    }


    /**
     * Creates the spinner which provides amount to gas or break.
     * @return
     */
    public JSpinner createGasAmountSpinner(){
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        JSpinner gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                jSpinnerAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        return gasSpinner;
    }

}
