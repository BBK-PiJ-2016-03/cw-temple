package student.Nodes;

import game.NodeStatus;

/**
 * Created by aworton on 16/02/17.
 */
public class NodeStatusNeighbourNode implements HasIdAndDistance {

    private NodeStatus instance;

    public NodeStatusNeighbourNode(NodeStatus instance) {
        this.instance = instance;
    }

    @Override
    public long getId() {
        return instance.getId();
    }

    @Override
    public int getDistance() {
        return instance.getDistanceToTarget();
    }
}
