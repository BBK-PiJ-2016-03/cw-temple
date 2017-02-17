package student.Nodes;

import game.NodeStatus;

/**
 * Created by aworton on 16/02/17.
 */
@SuppressWarnings("ALL")
public class NodeStatusNeighbourNode implements HasIdAndDistance {

    private final NodeStatus instance;

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
