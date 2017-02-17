package student.Nodes;

import game.Node;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by aworton on 17/02/17.
 */
public class NodeNeighbourNode implements HasIdAndDistance {

    private Node instance;

    public NodeNeighbourNode(Node instance) {
        this.instance = instance;
    }

    @Override
    public long getId() {
        return instance.getId();
    }

    @Override
    public int getDistance() {
        //this is bad, but so is a lack of covariant Collections.
        throw new NotImplementedException();
    }
}
