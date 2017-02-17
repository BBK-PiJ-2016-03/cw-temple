package student.Nodes;

import game.Node;

/**
 * Created by aworton on 17/02/17.
 */
@SuppressWarnings("ALL")
public class NodeNeighbourNode implements HasIdAndDistance {

    private final Node instance;

    public NodeNeighbourNode(Node suppliedInstance) {
        this.instance = suppliedInstance;
    }

    @Override
    public final long getId() {
        return instance.getId();
    }

    @Override
    public final int getDistance() {
        //this is bad, but so is a lack of covariant Collections.
        throw new IllegalStateException("Node does not hold distance data");
    }
}
