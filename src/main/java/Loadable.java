

import java.util.ArrayDeque;

/**
 * Represents something that can carry things of type T.
 * @param <T>
 */
public interface Loadable<T> {

    public T unload();

    public void load(T t);

    /**
     * Returns true if the instance is of a type that should not
     * be able to be loaded using #load(T t).
     * @param t The object to check if it is disallowed.
     * @return Returns true if the type isn't allowed to enter the loadable thing.
     */
    public boolean isDisallowed(T t);

}
