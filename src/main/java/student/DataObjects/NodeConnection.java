package student.DataObjects;

import student.Nodes.CavernNode;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
@SuppressWarnings("ALL")
public class NodeConnection {
    private CavernNode node;
    private int pathWeight;

    public NodeConnection(CavernNode suppliedNode, int suppliedPathWeight) {
        setNode(suppliedNode);
        setPathWeight(suppliedPathWeight);
    }

    public final CavernNode getNode() {
        return node;
    }

    private void setNode(CavernNode suppliedNode) {
        this.node = suppliedNode;
    }

    public final int getPathWeight() {
        return pathWeight;
    }

    private void setPathWeight(int suppliedPathWeight) {
        this.pathWeight = suppliedPathWeight;
    }

    @Override
    public final String toString(){
        return "Id: "+node.getId()+" Weight: "+pathWeight;
    }
}
