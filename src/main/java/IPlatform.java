

public interface IPlatform<T> {

    public void raise();

    public void lower();

    /**
     * Get the current state of the tiltable platform.
     * Different implementations for different platforms (i.e angle vs boolean)
     * @return
     */
    public T getState();

    /**
     * Tells whether the platform is in the state where the vehicle using
     * it can drive. Example: A Truck cannot run with a platform not in resting state.
     * @return
     */
    public boolean isInRestingState();

}
