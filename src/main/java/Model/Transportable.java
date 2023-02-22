package src.main.java.Model;
import java.awt.*;

/**
 * Contract for being transportable (as in contrast to being Loadable, i.e can load transportables)
 */
public interface Transportable<T> {

    public Point getPosition();

}
