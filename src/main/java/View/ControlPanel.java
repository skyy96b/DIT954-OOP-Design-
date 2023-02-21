package src.main.java.View;

import src.main.java.Controller.CarController;

import javax.swing.*;
import java.awt.*;

public class ControlPanel  extends JPanel {

    private CarController carController;

    public ControlPanel(CarController cc){
        this.carController = cc;
        this.init();
    }

    private void init(){
        JPanel controlPanel = this;
        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(carController.createGasButton(), 0);
        controlPanel.add(carController.createTurboOnButton(), 1);
        controlPanel.add(carController.createRaisePlatformButton(), 2);
        controlPanel.add(carController.createBrakeButton(), 3);
        controlPanel.add(carController.createTurboOffButton(), 4);
        controlPanel.add(carController.createLowerPlatformButton(), 5);
        controlPanel.setPreferredSize(new Dimension((CarView.X/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);





        JButton startButton = carController.createStartAllCarsButton();
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(CarView.X/5-15,200));
        this.add(startButton);

        JButton stopButton = carController.createStopAllCarsButton();
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(CarView.X/5-15,200));
        this.add(stopButton);

    }
}
