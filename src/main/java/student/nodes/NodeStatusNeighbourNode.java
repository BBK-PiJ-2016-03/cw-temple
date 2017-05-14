package student.nodes;

import game.NodeStatus;

/**
 * Created by aworton on 16/02/17.
 */
@SuppressWarnings("ALL")
public class NodeStatusNeighbourNode implements HasIdAndDistance {

  /**
   * instance field.
   **/
  private final NodeStatus instance;

  /**
   * Constructor.
   *
   * @param suppliedInstance the injected instance
   */
  public NodeStatusNeighbourNode(NodeStatus suppliedInstance) {
    this.instance = suppliedInstance;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final long getId() {
    return instance.getId();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final int getDistance() {
    return instance.getDistanceToTarget();
  }
}
