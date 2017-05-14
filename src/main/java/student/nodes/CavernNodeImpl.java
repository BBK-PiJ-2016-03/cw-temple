package student.nodes;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
@SuppressWarnings("ALL")
public class CavernNodeImpl implements CavernNode {

  /**
   * id field.
   **/
  private long id;
  /**
   * pathValue field.
   **/
  private int pathValue;
  /**
   * visited field.
   **/
  private Boolean visited;
  /**
   * distance field.
   **/
  private int distance;

  {
    id = -1;
    pathValue = Integer.MAX_VALUE;
    visited = false;
    distance = Integer.MAX_VALUE;
  }

  /**
   * No argument Constructor.
   */
  public CavernNodeImpl() {
  }

  /**
   * NodeId Constructor.
   *
   * @param nodeId the ID of the node
   */
  public CavernNodeImpl(long nodeId) {
    setId(nodeId);
  }

  /**
   * NodeId and distanceToTarget Constructor.
   *
   * @param nodeId           the ID of the node
   * @param distanceToTarget the distance to target
   */
  public CavernNodeImpl(long nodeId, int distanceToTarget) {
    setId(nodeId);
    setDistance(distanceToTarget);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final int getPathValue() {
    return this.pathValue;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void setPathValue(int newPathValue) {
    if (newPathValue < 0) {
      final String message = String.format("Path values must be valid to be set. %d is invalid.",
              newPathValue);
      throw new IllegalArgumentException(message);
    }
    this.pathValue = newPathValue;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final int getDistance() {
    return this.distance;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void setDistance(int newDistance) {
    if (newDistance < 0) {
      throw new IllegalArgumentException("Distance cannot be negative");
    }
    this.distance = newDistance;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final long getId() {
    if (this.id < 0) {
      throw new IllegalStateException("Id has not yet been set for this node");
    }
    return this.id;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void setId(long newId) {
    if (newId < 0) {
      throw new IllegalArgumentException("Provided Id is invalid. Please supply an id >= 0");
    }
    this.id = newId;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final Boolean isVisited() {
    return this.visited;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void setVisited(Boolean newVisited) {
    this.visited = newVisited;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final boolean equals(Object obj) {
    if (!(obj instanceof CavernNodeImpl)) {
      return false;
    }

    CavernNodeImpl cavernObj = (CavernNodeImpl) obj;

    return cavernObj.id == this.id
            && cavernObj.pathValue == this.pathValue
            && cavernObj.hashCode() == this.hashCode();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final int hashCode() {
    return (int) (this.id % Integer.MAX_VALUE);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final String toString() {
    return "Id: " + id + " pv: " + pathValue + " dist: " + distance;
  }
}
