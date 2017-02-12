package student.Navigators;

import game.NodeStatus;
import student.Maps.CavernMap;
import student.Nodes.CavernNode;
import student.Nodes.CavernNodeImpl;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Alexander Worton on 06/02/2017.
 */
public class TargetSeeker implements Seeker {

    private Navigator navigator;
    private CavernMap map;
    private long currentLocationId;
    private List<CavernNode> path;

    public TargetSeeker(Navigator nav, CavernMap map) {
        setNav(nav);
        setMap(map);
    }

    @Override
    public long getNextMove(long location, Collection<NodeStatus> neighbours) {
        setCurrentLocationId(location);
        if(!map.contains(location))
            throw new IllegalStateException("Node with that id not known");
        CavernNode currentLocation = map.getNode(location);
        addNeighboursToMap(currentLocation, neighbours);
        return getNextClosestNodeId();
    }

    /**
     * select any remaining unexplored neighbour node, closest first, then plot a path
     * to the next closest unexplored node in map
     * @return next closest node to target
     */
    private long getNextClosestNodeId() {
        if(pathExists())
            return getNextPathNodeId();
        return getNextNodeId();
    }

    private long getNextNodeId() {
        Long nextNodeId = getClosestNeighbourNode();
        if(nextNodeId == null) {
            nextNodeId = getNewPathToClosestAvailableNode();
        }
        return nextNodeId;
    }

    private long getClosestNeighbourNode(){
        long nodeId = 0L;
        return nodeId;
    }

    private long getNewPathToClosestAvailableNode() {
        navigator.setStartNode(map.getNode(this.currentLocationId));
        navigator.setDestinationNode(getClosestUnvisitedNodeOnMap());
        this.path = navigator.getPathFromStartToDestination();
        return getNextPathNodeId();
    }

    /**
     *
     * @return an unvisited node which is closest to target
     */
    private CavernNode getClosestUnvisitedNodeOnMap() {
        return map.getAllNodes().stream()
                .filter(n -> !n.isVisited())
                .sorted(Comparator.comparingInt(n -> n.getDistance()))
                .findFirst()
                .get();
    }

    /**
     * add neighbours to the map when supplied
     * @param currentLocation the current location
     * @param neighbours the neighbouring nodes
     */
    private void addNeighboursToMap(CavernNode currentLocation, Collection<NodeStatus> neighbours) {
        neighbours.forEach(n -> {
            if(!map.contains(n.getId())) {
                CavernNode node = new CavernNodeImpl(n.getId());
                map.addNode(node);
                map.connectNodes(currentLocation, node);
            }
        });
    }

    public Navigator getNavigator() {
        return this.navigator;
    }

    public void setNav(Navigator nav) {
        this.navigator = nav;
    }

    public CavernMap getMap() {
        return this.map;
    }

    public void setMap(CavernMap map) {
        this.map = map;
    }

    /**
     * pop the element at the front of the list and return the id if available
     * @return null if list empty or null, node's id otherwise
     */
    private Long getNextPathNodeId() {
        if(!pathExists())
            return null;
        return path.remove(0).getId();
    }

    private Boolean pathExists(){
        return this.path != null && this.path.size() > 0;
    }

    public void setCurrentLocationId(long currentLocationId) {
        this.currentLocationId = currentLocationId;
    }
}
