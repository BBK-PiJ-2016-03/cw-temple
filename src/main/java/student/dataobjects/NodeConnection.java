package student.dataobjects;

import student.nodes.CavernNode;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
@SuppressWarnings("ALL")
public class NodeConnection {

  /**
   * node field.
   **/
  private CavernNode node;
  /**
   * pathWeight field.
   **/
  private int pathWeight;

  /**
   * Constructor.
   *
   * @param suppliedNode       injected node
   * @param suppliedPathWeight injected path weight
   */
  public NodeConnection(CavernNode suppliedNode, int suppliedPathWeight) {
    setNode(suppliedNode);
    setPathWeight(suppliedPathWeight);
  }

  /**
   * Getter for node.
   *
   * @return the node
   */
  public final CavernNode getNode() {
    return node;
  }

  /**
   * Setter for node.
   *
   * @param suppliedNode the new node
   */
  private void setNode(CavernNode suppliedNode) {
    this.node = suppliedNode;
  }

  /**
   * Getter for path weight.
   *
   * @return pathWeight
   */
  public final int getPathWeight() {
    return pathWeight;
  }

  /**
   * Setter for path weight.
   *
   * @param suppliedPathWeight the new path weight value
   */
  private void setPathWeight(int suppliedPathWeight) {
    this.pathWeight = suppliedPathWeight;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final String toString() {
    return "Id: " + node.getId() + " Weight: " + pathWeight;
  }
}
