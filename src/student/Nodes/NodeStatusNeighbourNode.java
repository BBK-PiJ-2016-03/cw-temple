package student.Nodes;

import game.NodeStatus;

/**
 * Created by aworton on 16/02/17.
 */
@SuppressWarnings("ALL")
public class NodeStatusNeighbourNode implements HasIdAndDistance {

    private final NodeStatus instance;

    public NodeStatusNeighbourNode(NodeStatus suppliedInstance) {
        this.instance = suppliedInstance;
    }

    @Override
    public final long getId() {
        return instance.getId();
    }

    @Override
    public final int getDistance() {
        return instance.getDistanceToTarget();
    }
}
