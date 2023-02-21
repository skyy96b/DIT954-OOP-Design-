package src.main.java.Controller;

import src.main.java.Model.*;

import java.util.List;

/**
 * One object which does the same things to all cars it consists of.
 * Helps CarController not needing to have functionality for doing things to each car.
 */
public class CompositeCar {

    private List<Car> cars;

    public CompositeCar(List<Car> cars){
        this.cars = cars;
    }

    public void addCar(Car car){
        this.cars.add(car);
    }

    public void removeCar(Car car){
        this.cars.remove(car);
    }

    public void gas(double amount) throws Exception {
        for(Car car: cars){
            car.gas(amount);
        }
    }

    public void brake(double amount) throws Exception {
        for(Car car: cars){
            car.brake(amount);
        }
    }

    public void stopEngine() {
        for(Car car: cars){
            car.stopEngine();
        }
    }

    public void startEngine() {
        for(Car car: cars){
            car.startEngine();
        }
    }
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
                IPlatform iPlatform= (IPlatform) car;
                iPlatform.raise();
            }
        }
    }


    public void lowerPlatform() {
        for (Car car : cars
        ) {
            if(car instanceof Truck){
                Truck truck = (Truck) car;
                truck.lower();
            }
        }
    }

}
