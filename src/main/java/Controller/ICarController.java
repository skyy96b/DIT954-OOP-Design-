package src.main.java.Controller;

public interface ICarController {


    // Calls the gas method for each car once
    public void gas(int amount) throws Exception;

    // Calls the gas method for each car once
    public void brake(int amount) throws Exception;

    /**
     *
     * @param setOn True sets turbo on. Otherwise to off
     */
    public void setTurbo(boolean setOn);

    public void raisePlatform();

    public void lowerPlatform();

    public void startAllCars();

    public void stopAllCars();

}
