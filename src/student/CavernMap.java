package student;

import game.NodeStatus;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Alexander Worton on 22/01/2017.
 */
public class CavernMap {
    private CavernSquare start;
    private CavernSquare currentLocation;
    private java.util.Map<Long, CavernSquare> allNodes;

    {
        allNodes = new HashMap<>();
    }

    public void addCurrentNode(CavernSquare cavernSquare, Collection<NodeStatus> neighbours){
        cavernSquare = addNeighboursToNode(cavernSquare, neighbours);
        setCurrent(cavernSquare);
        if(start == null) setStart(cavernSquare);
    }

    private CavernSquare addNeighboursToNode(CavernSquare cavernSquare, Collection<NodeStatus> neighbours) {
        addNeighbourNodesToNode(cavernSquare, neighbours);
        addNodeToMap(cavernSquare);
        return cavernSquare;
    }

    private void addNeighbourNodesToNode(CavernSquare cavernSquare, Collection<NodeStatus> neighbours) {
        neighbours.stream()
                .map(this::convertStatusToNode)
                .peek(this::addNodeToMap)
                .peek(cavernSquare::addDestination);
    }

    private void addNodeToMap(CavernSquare cavernSquare) {
        if(!allNodes.containsKey(cavernSquare.getId()))
            allNodes.put(cavernSquare.getId(), cavernSquare);
    }

    private CavernSquare convertStatusToNode(NodeStatus nodeStatus) {
        return new CavernSquare(nodeStatus.getId(), nodeStatus.getDistanceToTarget());
    }

    public CavernSquare getCurrentLocation() {
        System.out.println("At " + currentLocation.getId());
        return currentLocation;
    }

    private void setCurrent(CavernSquare currentLocation) {
        this.currentLocation = currentLocation;
    }

    private void setStart(CavernSquare start) {
        this.start = start;
    }
}
