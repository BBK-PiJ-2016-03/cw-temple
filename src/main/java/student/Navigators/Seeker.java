package student.Navigators;

import student.Nodes.HasIdAndDistance;

import java.util.Collection;

/**
 * Created by Alexander Worton on 06/02/2017.
 */
@SuppressWarnings("ALL")
public interface Seeker {

    /**
     * Getter for the next move to make
     * @param currentLocation the current location
     * @return the next move
     */
    long getNextMove(long currentLocation, Collection<? extends HasIdAndDistance> neighbours);
}
