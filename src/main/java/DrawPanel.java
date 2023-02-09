package src.main.java;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    /**
     * All loaded images of cars & trucks.
     */
    Map<String, BufferedImage> images;
    private ArrayList<Car> cars;

    public DrawPanel(int x, int y, ArrayList<Car> cars) {
        this.cars = cars;
        images = new HashMap<>();

        this.setDoubleBuffered(true);
        this.setBackground(Color.green);
        this.setPreferredSize(new Dimension(x, y));

        try {
            for(Car car: cars){
                //Loading all images of the cars (based on matching class name with image name)
                String name = car.getClass().getSimpleName();
                BufferedImage loadedImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + name + ".jpg"));
                images.put(name, loadedImage);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Car car: cars){//Draw all cars onto DrawPanel
            BufferedImage image = this.images.get(car.getClass().getSimpleName());
            Point pos = car.getPosition();
            g.drawImage(image, pos.x, pos.y, null); // see javadoc for more info on the parameters
        }
    }
}
