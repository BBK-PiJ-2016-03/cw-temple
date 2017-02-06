package student.Navigators;

/**
 * Created by Alexander Worton on 06/02/2017.
 */
public interface Seeker {

    /**
     * Getter for the next move to make
     * @param currentLocation the current location
     * @return the next move
     * @throws IllegalStateException if the currentLocation is unknown
     */
    long getNextMove(long currentLocation) throws IllegalStateException;
}
