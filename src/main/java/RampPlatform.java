

public class RampPlatform implements IPlatform<Boolean> {


    /**
     * Tells whether the loading platform is raised or lowered.
     * Two states.
     */
    private boolean raised = true;
    /**
     * The truck which the platform is curently connected to.
     */
    private Truck car = null;

    /**
     * A RampPlatform that can be assigned to a car
     * @param car Can be a car or null (when platform not on a truck)
     */
    public RampPlatform(Truck car){
        this.car = car;
    }


    /**
     * Raises the platform by 1 degree. If angle > 70 it is unchanged.
     */
    @Override
    public void raise() {
        this.raised = true;
    }

    /**
     * Lowers the platform by 1 degree. If angle <= 0 then it is set to 0.
     */
    @Override
    public void lower() {
        if(car != null && car.getCurrentSpeed() == 0){//Platofrm can only be down if truck is still
            this.raised = false;
        }
    }

    /**
     * Gets the state of the loading platform.
     * @return Returns true if raised & cannot enter the platform.
     */
    @Override
    public Boolean getState() {
        return this.raised;
    }

    /**
     *
     * @return Returns TRUE when the Ramp is up and the truck can drive.
     */
    @Override
    public boolean isInRestingState() {
        return this.raised;
    }

    /**
     * Gets the state of the loading platform.
     * @return Returns true if raised & cannot enter the platform.
     */
    public boolean isRaised(){
        return this.getState();
    }

}
