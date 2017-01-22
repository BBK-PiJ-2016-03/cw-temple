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
    private Map<Long, Node> allNodes;

    {
        allNodes = new HashMap<>();
    }

    public void addCurrentNode(Node node, Collection<NodeStatus> neighbours){
        node = addNeighboursToNode(node, neighbours);
        setCurrent(node);
        if(start == null) setStart(node);
    }

    private Node addNeighboursToNode(Node node, Collection<NodeStatus> neighbours) {
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
        return new Node(nodeStatus.getId(), nodeStatus.getDistanceToTarget());
    }

    public Node getCurrent() {
        return current;
    }

    private void setCurrent(Node current) {
        this.current = current;
    }

    private void setStart(Node start) {
        this.start = start;
    }

    public Long getNextMove(){
        return 0L;
    }
}
