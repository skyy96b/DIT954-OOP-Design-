package src.main.java.Model;
public class TiltablePlatform implements IPlatform<Double> {


    /**
     * The angle of the loading platform
     */
    private double angle = 0D;

    /**
     * A TiltablePlatform that can be assigned to a car
     * @param car Can be a car or null (when platform not on a truck)
     */
    public TiltablePlatform(){

    }


    /**
     * Raises the platform by 1 degree. If angle > 70 it is unchanged.
     */
    @Override
    public void raise() {
        this.angle = Math.min(70, this.angle + 1);

    }

    /**
     * Lowers the platform by 1 degree. If angle <= 0 then it is set to 0.
     */
    @Override
    public void lower() {
        this.angle = Math.max(0, this.angle - 1);

    }

    @Override
    public Double getState() {
        return this.angle;
    }


    /**
     *
     * @return Returns TRUE when the TiltablePlatform is down & the truck can drive.
     */
    @Override
    public boolean isInRestingState() {
        return this.angle == 0;
    }

    /**
     * Gets the angle of the loading platform.
     * @return
     */
    public double getAngleOfPlatform(){
        return this.getState();
    }

}
