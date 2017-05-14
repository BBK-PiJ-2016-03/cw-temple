package student.navigators;

import java.util.Collection;
import student.nodes.HasIdAndDistance;


/**
 * Created by Alexander Worton on 06/02/2017.
 */
@SuppressWarnings("ALL")
public interface Seeker {

  /**
   * Getter for the next move to make.
   *
   * @param currentLocation the current location
   * @return the next move
   */
  long getNextMove(long currentLocation, Collection<? extends HasIdAndDistance> neighbours);
}
