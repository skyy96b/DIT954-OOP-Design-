import java.awt.*;

/**
 * Contract for being transportable (as in contrast to being Loadable, i.e can load transportables)
 */
public interface Transportable<T> {

    /**
     * Being transportable. Setting the transporter of this object.
     * Usually meaning that the position of transportee should reflect the transporter.
     * @param transporter
     */
    public void setTransporter(T transporter);

    public Point getPosition();

}
