package student.dataobjects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import student.nodes.CavernNode;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
@SuppressWarnings("ALL")
public class Connection {

  /**
   * connectedNodes field.
   **/
  private Set<CavernNode> connectedNodes;
  /**
   * weight field.
   **/
  private int weight;

  /**
   * Constructor.
   *
   * @param weight injected weight value
   * @param nodes  injected nodes (varargs)
   */
  public Connection(int weight, CavernNode... nodes) {
    setConnectedNodes(nodes);
    setWeight(weight);
  }

  /**
   * Getter for weight.
   *
   * @return weight
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Setter for weight.
   *
   * @param weight the current weight
   */
  private void setWeight(int weight) {
    this.weight = weight;
  }

  /**
   * Getter for connected nodes.
   *
   * @return connectedNodes
   */
  public Set<CavernNode> getConnectedNodes() {
    return connectedNodes;
  }

  /**
   * Setter for connected nodes.
   *
   * @param nodes the new nodes value
   */
  private void setConnectedNodes(CavernNode[] nodes) {
    if (nodes[0] != null && nodes[1] != null) {
      this.connectedNodes = new HashSet<>(Arrays.asList(nodes));
    }
  }

  /**
   * Getter for node connections.
   *
   * @param node the desired node
   * @return the connections for the specified node
   */
  public NodeConnection getConnectedNode(CavernNode node) {
    return connectedNodes.stream()
            .filter(n -> !n.equals(node))
            .map(n -> new NodeConnection(n, this.weight))
            .findFirst()
            .orElse(null);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj.getClass() != this.getClass()) {
      return false;
    }

    return this.connectedNodes.equals(((Connection) obj).connectedNodes);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return connectedNodes.hashCode();
  }
}
