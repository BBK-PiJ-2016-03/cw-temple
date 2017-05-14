package student.nodes;

import game.Node;

/**
 * Created by aworton on 17/02/17.
 */
@SuppressWarnings("ALL")
public class NodeNeighbourNode implements HasIdAndDistance {

  /**
   * intance field.
   **/
  private final Node instance;

  /**
   * Constructor.
   *
   * @param suppliedInstance the injected instance.
   */
  public NodeNeighbourNode(Node suppliedInstance) {
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
    //this is bad, but so is a lack of covariant Collections.
    throw new IllegalStateException("Node does not hold distance data");
  }
}
