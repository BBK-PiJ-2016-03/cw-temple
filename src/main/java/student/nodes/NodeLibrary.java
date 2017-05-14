package student.nodes;

import game.Node;
import game.NodeStatus;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aworton on 17/02/17.
 */
@SuppressWarnings("ALL")
public class NodeLibrary {

  /**
   * Helper method to convert a collection of Nodes to a collection of wrapped NodeNeighbournodes.
   *
   * @param nodes the source collection of nodes
   * @return collection of NodeNeighbourNode wrappers
   */
  public static List<NodeNeighbourNode> wrapGameNodeCollection(Collection<Node> nodes) {
    return nodes.stream()
            .map(NodeNeighbourNode::new)
            .collect(Collectors.toList());
  }

  /**
   * Helper method to convert a collection of NodeStatus's to a collection of wrapped
   * NodeStatusNeighbournodes.
   *
   * @param nodes the source collection of nodes
   * @return colelction of NodeStatusNeighbourNode wrappers
   */
  public static List<NodeStatusNeighbourNode>
                wrapGameNodeStatusCollection(Collection<NodeStatus> nodes) {
    return nodes.stream()
            .map(NodeStatusNeighbourNode::new)
            .collect(Collectors.toList());
  }
}
