package src.main.java.Model;
import java.awt.*;

/*
 * We created a general Truck class. Because a Truck can have a loading platform.
 * If it has a loading platform. The platform can either be lowered or raised.
 * All trucks share functionality of speedFactor & lowering & raising their platforms.
 *
 * We chose subclassing instead of composition because Car is abstract per Lab1A. Because
 * speedFactor differs among different implementations of Cars.
 *
 * We chose composition for the Platforms because we imagine a Truck can have different platforms
 * over time. Or at least different Trucks can have different platforms. Thus different implementations.
 *
 */

/**
 * A truck without a platform. But with ability to carry different platforms.
 */
public abstract class Truck<T> extends Car implements IPlatform<T> {


    /**
     * Loading paltform
     */
    protected IPlatform<T> platform = null;

    /**
     * Constructs a Truck. With 2 doors & 200 engine power
     *
     * @param startPos Start position of the truck
     * @param dir      Direction of the truck
     */
    public Truck(Point startPos, Direction dir, Color color, String name) {
        super(startPos, dir, 2, 200, color, name);
    }

    /**
     * Set the loading platform for the truck.
     * @param platform
     */
    public void setPlatform(IPlatform platform){
        this.platform = platform;
    }

    /**
     * { @inheritDoc }
     * Only raises if truck is not moving.
     */
    @Override
    public void raise() {
        if(this.platform != null && this.getCurrentSpeed() == 0){//If no movement => lowerable
            this.platform.raise();
        }
    }

    /**
     * { @inheritDoc }
     * Only lowers if truck is not moving.
     */
    @Override
    public void lower() {
        if(this.platform != null && this.getCurrentSpeed() == 0){//If no movement => lowerable
            this.platform.lower();
        }
    }

    /**
     * Gets the generic state of a generic loading platform.
     * Different platforms can have different states.
     * I.e TiltablePlatform has degrees & Ramp has two states.
     * @return
     */
    @Override
    public T getState() {
        return this.platform.getState();
    }

    /**
     * Only when the loading platform is in resting state. Can the truck be driven.
     * Example: Ramp is up or TiltablePlatform is at 0 degrees.
     * @return
     */
    @Override
    public boolean isInRestingState() {
        return this.platform.isInRestingState();
    }

    /**
     * Speedfactor of the truck
     * @return
     */
    @Override
    public double speedFactor() {
        return this.getEnginePower() * 0.01;
    }


}
