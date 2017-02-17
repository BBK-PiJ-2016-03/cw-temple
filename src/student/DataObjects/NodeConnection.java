package student.DataObjects;

import student.Nodes.CavernNode;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
@SuppressWarnings("ALL")
public class NodeConnection {
    private CavernNode node;
    private int pathWeight;

    public NodeConnection(CavernNode node, int pathWeight) {
        setNode(node);
        setPathWeight(pathWeight);
    }

    public CavernNode getNode() {
        return node;
    }

    private void setNode(CavernNode node) {
        this.node = node;
    }

    public int getPathWeight() {
        return pathWeight;
    }

    private void setPathWeight(int pathWeight) {
        this.pathWeight = pathWeight;
    }

    @Override
    public String toString(){
        return "Id: "+node.getId()+" Weight: "+pathWeight;
    }
}
