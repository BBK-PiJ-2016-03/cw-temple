package student;

import game.NodeStatus;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander Worton on 22/01/2017.
 */
public class NodeGraph {
    private Node start;
    private Node current;
    private Map<Long, Node> allNodes = new HashMap<>();

    public void addNode(NodeStatus nodeStatus, Collection<NodeStatus> neighbours){
        Node node = createNodeFromNodeStatus(nodeStatus, neighbours);
        setCurrent(node);
        if(start == null) start = node;
    }

    private Node createNodeFromNodeStatus(NodeStatus nodeStatus, Collection<NodeStatus> neighbours) {
        Node node = convertStatusToNode(nodeStatus);
        addNeighbourNodesToNode(node, neighbours);
        addNodeToMap(node);
        return node;
    }

    private void addNeighbourNodesToNode(Node node, Collection<NodeStatus> neighbours) {
        neighbours.stream()
                .map(this::convertStatusToNode)
                .peek(this::addNodeToMap)
                .peek(node::addDestination);
    }

    private void addNodeToMap(Node node) {
        if(!allNodes.containsKey(node.getId()))
            allNodes.put(node.getId(), node);
    }

    private Node convertStatusToNode(NodeStatus nodeStatus) {
        return new Node(nodeStatus.getId(), nodeStatus.hashCode(), nodeStatus.getDistanceToTarget());
    }

    public Node getCurrent() {
        return current;
    }

    public void setCurrent(Node current) {
        this.current = current;
    }
}
