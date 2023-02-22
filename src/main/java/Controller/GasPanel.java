package src.main.java.Controller;

import src.main.java.Controller.CarController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GasPanel extends JPanel{

    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    private CarController carController;

    public GasPanel(CarController cc){
        this.carController = cc;
        this.init();
    }

    private void init(){
        JLabel gasLabel = new JLabel("Amount of gas");


        setLayout(new BorderLayout());
        add(gasLabel, BorderLayout.PAGE_START);
        add(carController.createGasAmountSpinner(), BorderLayout.PAGE_END);

    }

}
