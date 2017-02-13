package student.DataObjects;

import student.Nodes.CavernNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
public class Connection {
    private Set<CavernNode> connectedNodes;
    private int weight;

    public Connection(int weight, CavernNode... nodes){
        setConnectedNodes(nodes);
        setWeight(weight);
    }

    public Connection(CavernNode... nodes){
        setConnectedNodes(nodes);
        setWeight(1);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Set<CavernNode> getConnectedNodes() {
        return connectedNodes;
    }

    public void setConnectedNodes(CavernNode[] nodes) {
        if(nodes[0] != null && nodes[1] != null)
            this.connectedNodes = new HashSet<>(Arrays.asList(nodes));
    }

    public NodeConnection getConnectedNode(CavernNode node){
        return connectedNodes.stream()
                .filter(n -> !n.equals(node))
                .map(n -> new NodeConnection(n, this.weight))
                .findFirst()
                .get();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass())
            return false;

        if(!this.connectedNodes.equals(((Connection)obj).connectedNodes))
            return false;

        return true;
    }

    @Override
    public int hashCode(){
        return connectedNodes.hashCode();
    }
}
