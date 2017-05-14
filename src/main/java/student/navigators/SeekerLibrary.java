package student.navigators;

import java.util.List;

import student.nodes.CavernNode;

/**
 * Created by Alexander Worton on 14/02/2017.
 */
@SuppressWarnings("ALL")
final class SeekerLibrary {

  /**
   * private empty Constructor for helper class.
   */
  private SeekerLibrary() {
  }

  /**
   * grabs the new path from the navigator, then removes the starting
   * node if that is the current location.
   */
  public static List<CavernNode> setNewPath(Navigator navigator, long currentLocationId) {
    List<CavernNode> path = navigator.getPathFromStartToDestination();
    if (path.get(0).getId() == currentLocationId) {
      path.remove(0);
    }
    return path;
  }
}
