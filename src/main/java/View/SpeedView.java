package src.main.java.View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpeedView extends JFrame implements SpeedObserver {


    private JPanel jpanel;
    public SpeedView(){

        //Add SpeedView via application to carcontroller listener

        this.setTitle("SpeedView");
        this.setPreferredSize(new Dimension(350, 700));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2 - 700, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.reinit(new ArrayList<>());

    }

    private void reinit( List<Map.Entry<String, Double>> cars){
        if(jpanel != null) this.remove(jpanel);

        jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(10,1));//A list of entries

        JLabel jLabel = new JLabel("Car speed:");
        jpanel.add(jLabel);

        for(Map.Entry<String, Double> entry: cars){
            jLabel = new JLabel(entry.getKey() + ": " + entry.getValue());
            jpanel.add(jLabel);
        }
        this.add(jpanel);
        this.pack();
        this.repaint();
        System.out.println("OK");
    }


    @Override
    public void onSpeedChange(List<Map.Entry<String, Double>> cars) {
        this.reinit(cars);
    }
}
