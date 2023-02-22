package src.main.java.Model;

import java.awt.*;

public class CarFactory {

    public static Car createVolvo240(){
        return new Volvo240();
    }

    public static Saab95 createSaab95(){
        return new Saab95();
    }

    /**
     *
     * @param x xpos
     * @param y ypos
     * @return
     */
    public static Saab95 createSaab95(int x, int y){
        return new Saab95(x, y);
    }

    /**
     *
     * @param startPos
     * @param dir
     * @return
     */
    public static Truck createScania(Point startPos, Direction dir){
        return new Scania(startPos, dir);
    }

    /**
     *
     * @param startPos
     * @param dir
     * @return
     */
    public static FerryBoat<Car> createFerryBoat(Point startPos, Direction dir, int capacity){
        return new FerryBoat<Car>(dir, startPos, capacity);
    }


    public static TransportTruck createTransportTruck(Point startPos, Direction dir){
        return new TransportTruck(startPos, dir);
    }

}
