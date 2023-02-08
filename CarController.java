import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95(0, 100));
        cc.cars.add(new Scania(new Point(0, 200), Direction.NORTH));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());

                try {
                    handleOutsideWindow(x, y, car);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private void handleOutsideWindow(int x, int y, Car car) throws Exception {
        int yLimit = this.frame.getHeight() - this.frame.getHeightOfControlPanel();
        if(x < 0 || x > this.frame.getWidth() || y > yLimit || y < 0){
            car.stopEngine();
            car.turnLeft();car.turnLeft();
            car.startEngine();
            car.gas(1);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) throws Exception {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
            System.out.println(car.getCurrentSpeed());
        }
    }

    // Calls the gas method for each car once
    void brake(int amount) throws Exception {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(gas);
            System.out.println(car.getCurrentSpeed());
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

    void startAllCars(){
        this.startAllCars(true);
    }

    void stopAllCars(){
        this.startAllCars(false);
    }

}
