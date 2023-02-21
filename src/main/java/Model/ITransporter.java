package src.main.java.Model;

import java.awt.*;

/**
 *
 * @param <T> The type which can be loaded onto the transporter.
 */
public interface ITransporter<T> extends Loadable<T>, Movable, IObservablePosition{
    Point getPosition();
}
