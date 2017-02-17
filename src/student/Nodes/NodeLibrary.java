package student.Nodes;

import game.Node;
import game.NodeStatus;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aworton on 17/02/17.
 */
public class NodeLibrary {

    /**
     * Helper method to convert a collection of Nodes to a collection of wrapped NodeNeighbournodes
     * @param nodes
     * @return colelction of NodeNeighbourNode
     */
    public static List<NodeNeighbourNode> wrapGameNodeCollection(Collection<Node> nodes){
        return nodes.stream()
                .map(n -> new NodeNeighbourNode(n))
                .collect(Collectors.toList());
    }

    /**
     * Helper method to convert a collection of NodeStatus's to a collection of wrapped NodeStatusNeighbournodes
     * @param nodes
     * @return colelction of NodeStatusNeighbourNodes
     */
    public static List<NodeStatusNeighbourNode> wrapGameNodeStatusCollection(Collection<NodeStatus> nodes) {
        return nodes.stream()
                .map(n -> new NodeStatusNeighbourNode(n))
                .collect(Collectors.toList());
    }
}
