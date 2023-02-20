package src.main.java.Controller;
import src.main.java.Model.Car;
import src.main.java.Model.IPlatform;
import src.main.java.Model.Saab95;
import src.main.java.Model.Scania;

import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements ICarController{
    // member fields:

    // A list of cars, modify if needed
    private List<Car> cars;

    //methods:

    public CarController(List<Car> cars){
        this.cars = cars;
    }

    // Calls the gas method for each car once
    public void gas(int amount) throws Exception {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
            //System.out.println(car.getCurrentSpeed());
        }
    }

    // Calls the gas method for each car once
    public void brake(int amount) throws Exception {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(gas);
            //System.out.println(car.getCurrentSpeed());
        }
    }

    /**
     *
     * @param setOn True sets turbo on. Otherwise to off
     */
    public void setTurbo(boolean setOn) {
        for (Car car : cars) {
            if(car instanceof Saab95){
                Saab95 saab = (Saab95) car;
                if(setOn){
                    saab.setTurboOn();
                } else {
                    saab.setTurboOff();
                }
            }
        }
    }
    public void raisePlatform() {
        for (Car car : cars
        ) {
            if(car instanceof IPlatform<?>){
                IPlatform scania = (IPlatform) car;
                scania.raise();
            }
        }
    }

    public void lowerPlatform() {
        for (Car car : cars
        ) {
            if(car instanceof Scania){
                Scania scania = (Scania) car;
                scania.lower();
            }
        }
    }

    /**
     * @param startOrNot If true then starts all cars. Otherwise stops all cars engines.
     */
    private void startAllCars(boolean startOrNot){
        for (Car car : cars) {
            if(startOrNot){
                car.startEngine();
            } else {
                car.stopEngine();
            }
        }
    }

    public void startAllCars(){
        this.startAllCars(true);
    }

    public void stopAllCars(){
        this.startAllCars(false);
    }

}
