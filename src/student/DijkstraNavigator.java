package student;

import java.util.Queue;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public class DijkstraNavigator implements Navigator {

    private CavernMap map;
    private CavernNode startNode;
    private CavernNode destinationNode;

    public DijkstraNavigator(CavernMap map) {
        setMap(map);
    }

    @Override
    public void setStartNode(CavernNode node) {
        this.startNode = node;
    }

    @Override
    public void setDestinationNode(CavernNode node) {
        this.destinationNode = node;
    }

    @Override
    public Queue<CavernNode> getPathFromStartToDestination() {
        if(getStartNode() == null || getDestinationNode() == null)
            throw new IllegalStateException("Start and destination nodes must be set before generating path");

        setAllNodesValueToMax();

        return null;
    }

    private void setMap(CavernMap map) {
        this.map = map;
    }

    private CavernNode getStartNode() {
        return startNode;
    }

    private CavernNode getDestinationNode() {
        return destinationNode;
    }
}
