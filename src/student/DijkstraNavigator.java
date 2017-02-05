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

        initialiseAllNodes();

        return null;
    }

    /***
     * set the initial state of each node.
     * - All path values to be set to max
     * - Golden value set to false
     * - Start node path value set to 0
     */
    protected void initialiseAllNodes() {
        map.getAllNodes().forEach(e -> {
            e.setGoldenValue(false);
            if(e.equals(startNode))
                e.setPathValue(0);
            else
                e.setPathValue(Integer.MAX_VALUE);
        });
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
