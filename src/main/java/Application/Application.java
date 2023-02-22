package src.main.java.Application;

import src.main.java.Controller.CarController;
import src.main.java.Controller.ICarController;
import src.main.java.Model.*;
import src.main.java.View.CarView;
import src.main.java.View.DrawPanel;
import src.main.java.View.SpeedView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args){

        List<Car> cars = new ArrayList<>();
        cars.add(CarFactory.createVolvo240());
        cars.add(CarFactory.createSaab95(0, 100));
        cars.add(CarFactory.createScania(new Point(0, 200), Direction.NORTH));

        // The delay (ms) corresponds to 20 updates a sec (hz)
        final int delay = 50;

        SpeedView speedView = new SpeedView();
        CarController carController = new CarController(cars);
        carController.addSpeedChangeListener(speedView);

        //Instead of different classes needing to access DrawPanel. Application
        // now creates it and injects it where it needs to be.
        DrawPanel drawPanel = new DrawPanel(CarView.X, CarView.Y - 240, cars);
        CarView view = new CarView("CarSim", drawPanel, carController);

        Timer timer = new Timer(delay, new TimerListener(cars, drawPanel, carController));
        timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private static class TimerListener implements ActionListener {

        private List<Car> cars;
        private DrawPanel panel;

        private CarController carController;

        private TimerListener(List<Car> car, DrawPanel panel, CarController carController){
            this.cars = car;
            this.panel = panel;
            this.carController = carController;
        }

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


            }
            // repaint() calls the paintComponent method of the panel
            panel.repaint();
        }



        /**
         * Handles car outside the frame/window.
         * @param x Position of car
         * @param y Position of car
         * @param car
         * @throws Exception
         */
        public void handleOutsideWindow(int x, int y, Car car) throws Exception {
            int yLimit = CarView.Y; //TODO - height of controlpanel
            if(x < 0 || x > CarView.X || y > yLimit || y < 0){
                car.stopEngine();
                car.turnLeft();car.turnLeft();
                car.startEngine();
                car.gas(1);
                this.carController.notifySpeedChangeListeners();
            }
        }

    }

}
