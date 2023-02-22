package src.main.java.View;
import src.main.java.Controller.CarController;
import src.main.java.Controller.ControlPanel;
import src.main.java.Controller.GasPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{
    public static final int X = 800;
    public static final int Y = 800;

    // The controller member
    CarController carC;

    DrawPanel drawPanel;

    JPanel controlPanel;

    JPanel gasPanel;

    // Constructor
    public CarView(String framename, DrawPanel drawPanel, CarController cc){
        this.carC = cc;
        this.drawPanel = drawPanel;
        this.carC = cc;
        initComponents(framename);
    }

    public int getHeightOfControlPanel(){
        return this.controlPanel.getHeight();
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        controlPanel = new ControlPanel(carC);
        gasPanel = new GasPanel(carC);

        this.add(controlPanel);
        this.add(gasPanel);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}